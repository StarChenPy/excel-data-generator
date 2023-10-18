package xyz.starsdust.exceldatagenerator.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.data.ReadCellData;
import xyz.starsdust.exceldatagenerator.pojo.DataInputType;
import xyz.starsdust.exceldatagenerator.pojo.DataOutputType;
import xyz.starsdust.exceldatagenerator.util.Config;
import xyz.starsdust.exceldatagenerator.util.Parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcel extends AnalysisEventListener<Map<Integer, String>> {
    private final Map<String, Integer> headMap = new HashMap<>();           // 第一个 String 为名字, 第二个 int 为列数
    private final List<Map<String, String>> dataList = new ArrayList<>();   // 第一个 String 为名字, 第二个 String 为内容
    private final List<String> inputHeadNameList = new ArrayList<>();
    private final List<String> outputHeadNameList = new ArrayList<>();
    private String repeatColumnName;
    private int repeatColumnNumber;

    public ReadExcel() {
        for (DataInputType inputType : Config.getInstance().getConfig().getInputConfigList()) {
            // 如果这一行是重复数量行，就不把这行加入到输入列表中
            if (inputType.isRepeatColumn()) {
                this.repeatColumnName = inputType.getName();
                continue;
            }
            this.inputHeadNameList.add(inputType.getName());
        }

        for (DataOutputType outputType : Config.getInstance().getConfig().getOutputConfigList()) {
            this.outputHeadNameList.add(outputType.getName());
        }
    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        headMap.forEach((k, v) -> {
            String headName = v.getStringValue();

            // 如果这一列的名字在配置文件中, 就把名字和所在列数添加到Map中
            // 除非这一列是重复数量行, 那会单独记录
            if (this.repeatColumnName != null && this.repeatColumnName.equals(headName)) {
                this.repeatColumnNumber = k;
            } else if (inputHeadNameList.contains(headName)) {
                this.headMap.put(headName, k);
            }
        });
    }

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        int repeatNumber = Integer.parseInt(data.get(this.repeatColumnNumber));
        for (int i = 0; i < repeatNumber; i++) {
            Map<String, String> bufferMap = new HashMap<>();

            headMap.forEach((k, v) -> {
                String parsedData = Parser.parseString(data.get(v));
                bufferMap.put(k, parsedData);
            });

            this.dataList.add(bufferMap);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里要解析数据并将其写入outputDataList
        WriteExcel excel = new WriteExcel();

        // 为 excel 写入表头
        excel.setHead(this.outputHeadNameList);

        // 为 excel 写入内容
        List<List<String>> outputDataList = new ArrayList<>();
        for (Map<String, String> data : dataList) {
            List<String> list = new ArrayList<>();
            for (String headName : outputHeadNameList) {
                list.add(data.get(headName));
            }
            outputDataList.add(list);
        }
        excel.setData(outputDataList);

        // 保存并输出
        excel.writeExcel();
    }
}
