# MvvmAndDatabinding
Mvvm+Databinding学习
# Mvvm 和 组件化

> https://github.com/goldze/MVVMHabitComponent
> https://blog.csdn.net/guiying712/article/details/55213884#2%E5%A6%82%E4%BD%95%E7%BB%84%E4%BB%B6%E5%8C%96

> 每一次挑战都能让自己成长,战!

> 对于架构,最常用的可能是Mvc,比较流行的是Mvp,它在某种程度上与Mvvm模式非常相似。不过Mvvm在Mvp的基础上更进一步的提高了开发效率，拥有了数据绑定的能力。

    ### 1.组件化方案架构特点:
        高内聚，低耦合，代码边界清晰，每一个组件都可以拆分出来独立运行;
        所有组件寄托于宿主App，加载分离的各个组件，各自编译自己的模块，有利于多人团队协作开发;

    ### 2.准备工作
        + 了解MVVMHabit:
            + 基于谷歌最新AAC架构，MVVM设计模式的一套快速开发库，整合Okhttp+RxJava+Retrofit+Glide等主流模块，满足日常开发需求。使用该框架可以快速开发一个高质量、易维护的Android应用;
        + 了解ARouter:
            + 阿里出的一个用于帮助 Android App 进行组件化改造的框架 —— 支持模块间的路由、通信、解耦;

    ### 3.创建项目

    #### 3.1.创建宿主
         > 宿主项目没有layout和activity;
         + 职责:负责配置构建编译/打包参数，依赖子模块;
         + 包含两个部分:
            + AndroidManifest.xml,用来配置application、启动页面等;
            + build.gradle,负责配置构建编译/打包参数，依赖子模块;

    #### 3.2.创建组件
         > 组件是一个特殊的Module,在合并打包的时候它是一个library：apply plugin: ‘com.android.library’，在独立编译运行的时候，它是一个application：apply plugin: ‘com.android.application’;

    #### 3.3.创建Library
        > 除了业务组件之外，还需要创建两个基础Library,library-base和library-res;
        + library-base(核心库)：
            + 存放一些公共方法、公共常量、组件通信的契约类等.上层被所有组件依赖,下层依赖公共资源库/图片选择库/路由库等通用库,通过它,避免了组件直接依赖各种通用库,承上启下,作为整个组件化的核心库;
        + library-res：
            + 为了缓解base库的压力,专门分离出一个公共资源库,被base库所依赖,主要存放与res相关的公共数据,比如图片/style/anim/color等;

    #### 3.4.第三方框架准备
        + MVVMHabit配置:

            ```
            //工程的gradle配置
            allprojects {
                repositories {
                    ...
                    google()
                    jcenter()
                    maven { url 'https://jitpack.io' }
                }
            }

            //宿主项目中的gradle中配置
            dependencies {
                //...
                implementation 'com.github.goldze:MVVMHabit:?'
            }
            ```

        + ARouter：

            ```
            //以下都在宿主项目中的gradle中配置
            defaultConfig {
                //...
                javaCompileOptions {
                    annotationProcessorOptions {
                        arguments = [AROUTER_MODULE_NAME: project.getName()]
                    }
                }
            }

            dependencies {
                api 'com.alibaba:arouter-api:?'
                annotationProcessor 'com.alibaba:arouter-compiler:?'
            }
            ```

    #### 3.5.组件分离
        > 组件化其实是一个 分离--组合 的过程;
        > 分离:分离产品原型;
        > 组合:是组合代码模块;
        > 拿到需求后,一定不要急着开干,首先将产品原型分离成一个个子原型,分工开发后,将编写完成的子业务模块又打包组合成一个完整的Apk;

        + 分离示例
            todo 列出项目的功能点

    ### 4.组件配置
        > gradle是组件化的基石,想搭建好组件化项目,gradle知识一定要扎实（Android已经留下了gradle的烙印,加油,缺啥补啥,战!）;

    #### 4.1.依赖关系

        + 宿主依赖业务组件
        todo 配代码
        + 业务组件依赖library-base
        todo 配代码
        + library-base依赖公共库
        todo 配代码

    #### 4.2.开启dataBinding
        + Android MVVM模式离不开DataBinding，每个组件中都需要开启，包括宿主App

        ```
        android {
            //开启DataBinding
            dataBinding {
                enabled true
            }
        }
        ```

    #### 4.3.模式开关
        + 需要一个全局变量来控制当前运行的工程是隔离状态还是合并状态。在gradle.properties中定义：
        ```
        isBuildModule=false
        ```
        
    #### 4.4.debug切换
        + 在组件的build.gradle中动态切换library与application
        ```
        if (isBuildModule.toBoolean()) {
            //作为独立App应用运行
            apply plugin: 'com.android.application'
        } else {
            //作为组件运行
            apply plugin: 'com.android.library'
        }
        ```
        + 当isBuildModule 为 true 时，它是一个application，拥有自己的包名;
        TODO 如何配置?

    #### 4.5.manifest配置
        todo 待补充

    #### 4.6.统一资源
        + 在组件的build.gradle配置统一资源前缀
        todo 待补充
        + 可以将每个组件的build.gradle公共部分抽取出一个module.build.gradle
        todo 待补充

    ### 5.组件初始化
        > 组件在独立运行时，也就是debug期，有单独的manifest，当然也就可以指定Application类进行初始化。
        那么当组件进行合并的时，Application只能有一个，并且存在宿主App中，组件该如何进行初始化？
    ### 5.1.反射
        + 反射是一种解决组件初始化的方法。
