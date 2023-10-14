# excel-data-generator
一个可以解析 excel 模板并生成出对应数据的工具

该项目编写于 Java 17

## 使用方法

### 配置
配置文件位于项目根目录下的 `config.json`

```json
{
  "inputFilePath": "input.xlsx",
  "inputConfig": [
    {
      "name": "线路号"
    }, {
      "name": "计划样本量",
      "repeatColumn": true
    }, {
      "name": "车辆自编号"
    }
  ],
  "outputFilePath": "output.xlsx",
  "outputConfig": [
    {
      "name": "线路号"
    }, {
      "name": "车辆自编号"
    }, {
      "name": "性别"
    }
  ]
}
```

`outputConfig`中的 name 决定了输出的顺序

`name`用于匹配excel表头，需要与表头内容一致

`name`也用于匹配输入与输出，`inputConfig`的name和`outputConfig`的name需要一致才能正常输出

`inputConfig` 中的 `repeatColumn` 用于标记“重复数量”列，程序会读取这一列的数，生成对应数量的这一列的数据

### 解析
这是一个 excel 表格模板

![image](https://github.com/Starsdust2004/excel-data-generator/assets/61131579/31e352f5-f715-402c-9c9c-531d962ee099)

其中，在数据生成方面，“,”可以分割不同的字符，“;”可以分割不同的概率组

分号前一组的概率比后一组低一半

计划样本量为每组数据生成的次数，比如 29 就是根据这一行模板生成 29 次，最后输出 29 条数据
