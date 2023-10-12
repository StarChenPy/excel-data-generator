# excel-data-generator
一个可以解析 excel 模板并生成出对应数据的工具
## 使用方法

### 配置
配置文件位于项目根目录下的 `config.json`

```json
{
  "inputConfig": [
    {
      "id": 0,
      "name": "线路号"
      
    }, {
      "id": 1,
      "name": "计划样本量"
      
    }, {
      "id": 2,
      "name": "车辆自编号"
      
    }
  ],
  "outputConfig": [
    {
      "id": 0,
      "name": "线路号",
      "isParse": true
    }, {
      "id": 1,
      "name": "计划样本量",
      "isParse": true
    }, {
      "id": 2,
      "name": "车辆自编号",
      "isParse": true
    }
  ]
}
```

`inputConfig`和`outputConfig`中的 id 一一对应，`outputConfig`中的id决定了输出的顺序
`name`用于匹配excel表头，需要与表头内容一致
`outputConfig`中的isParse用于是否解析，为true时会根据解析规则解析内容

### 解析
这是一个 excel 表格模板

![image](https://github.com/Starsdust2004/excel-data-generator/assets/61131579/31e352f5-f715-402c-9c9c-531d962ee099)

其中，在数据生成方面，“,”可以分割不同的字符，“;”可以分割不同的概率组

分号前一组的概率比后一组低一半

可以在`config.json`中配置是否解析
