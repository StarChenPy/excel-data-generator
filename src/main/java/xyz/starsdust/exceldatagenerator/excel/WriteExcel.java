package xyz.starsdust.exceldatagenerator.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class WriteExcel {
    private List<List<String>> headList = new ArrayList<>();
    private List<List<String>> dataList = new ArrayList<>();

    public void writeExcel() {
        // 写法1
        String fileName = "output.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName).head(this.headList).sheet("模板").doWrite(this.dataList);
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

    public void setData(List<List<String>> list) {
        this.dataList = list;
    }
}
