package xyz.starsdust.exceldatagenerator.excel;

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
    private final List<DataInputType> inputConfig = Config.getInstance().getConfig().getInputConfigList();
    private final List<DataOutputType> outputConfig = Config.getInstance().getConfig().getOutputConfigList();
    private final Map<Integer, Integer> headNumberMap = new HashMap<>();
    private final List<Map<Integer, String>> dataList = new ArrayList<>();

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        headMap.forEach((k, v) -> {
            for (DataInputType inputType : this.inputConfig) {
                // 如果这一列的名字在配置文件中，将其所在行数绑定到id上
                if (inputType.getName().equals(v.getStringValue())) {
                    this.headNumberMap.put(inputType.getId(), k);
                    break;
                }
            }
        });
    }

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        Map<Integer, String> bufferMap = new HashMap<>();

        this.headNumberMap.forEach((k, v) -> {
            if (data.containsKey(v)) {
                bufferMap.put(k, data.get(v));
            }
        });

        this.dataList.add(bufferMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里要解析数据并将其写入outputDataList
        WriteExcel excel = new WriteExcel();

        // 为 excel 写入表头
        List<String> headList = new ArrayList<>();
        for (DataOutputType outputType : this.outputConfig) {
            headList.add(outputType.getId(), outputType.getName());
        }
        excel.setHead(headList);

        // 为 excel 写入内容
        List<List<String>> dataList = new ArrayList<>();
        for (Map<Integer, String> data : this.dataList) {
            List<String> list = new ArrayList<>();
            for (DataOutputType outputType : outputConfig) {
                if (data.containsKey(outputType.getId())) {
                    String string = data.get(outputType.getId());
                    if (outputType.isParse()) {
                        string = Parser.parseString(string);
                    }
                    list.add(string);
                }
            }
            dataList.add(list);
        }
        excel.setData(dataList);

        // 保存并输出
        excel.writeExcel();
    }
}
