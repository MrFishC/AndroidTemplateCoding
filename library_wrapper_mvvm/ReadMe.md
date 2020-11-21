# 架构组件

# 一.[应用架构指南](https://developer.android.google.cn/jetpack/docs/guide?hl=zh_cn)
## 1.常见的架构原则
+ 分离关注点
+ 通过模型驱动界面

## 2.职责划分

### 2.1.区域划分
+ 界面
+ ViewModle:为界面提供数据（包含数据处理业务逻辑），与模型进行通信
+ 存储区：处理数据操作，XxxRepository类
    + 使用Dragger2

### 2.2.区域对象关系
+ 连接 ViewModel 与存储区
+ Room使用
+ XxxRepository以纳入Room数据源

### 2.3.测试每个组件
+ 见官网文档

# 二.[向项目添加组件](https://developer.android.google.cn/topic/libraries/architecture/adding-components?hl=zh_cn)