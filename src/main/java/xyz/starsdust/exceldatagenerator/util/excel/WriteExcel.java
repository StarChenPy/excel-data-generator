package xyz.starsdust.exceldatagenerator.util.excel;

import com.alibaba.excel.EasyExcel;
import xyz.starsdust.exceldatagenerator.util.Config;

import java.util.ArrayList;
import java.util.List;

public class WriteExcel {
    private List<List<String>> headList = new ArrayList<>();
    private List<List<String>> dataList = new ArrayList<>();

    /**
     * 将excel文件导出
     *
     */
    public void writeExcel() {
        String outputPath = Config.getInstance().getConfig().getOutputPath();
        EasyExcel.write(outputPath).head(this.headList).sheet("sheet1").doWrite(this.dataList);
    }

    /**
     * 这个方法只能写入一行表头
     * 不过大部分时间应该够用了
     * @param list 表头列表
     */
    public void setHead(List<String> list) {
        List<List<String>> headList = new ArrayList<>();

        for (String headName : list) {
            List<String> arrayList = new ArrayList<>();
            arrayList.add(headName);
            headList.add(arrayList);
        }

        this.headList = headList;
    }

    /**
     * 写入excel内容
     * @param list 内容列表
     */
    public void setData(List<List<String>> list) {
        this.dataList = list;
    }
}
