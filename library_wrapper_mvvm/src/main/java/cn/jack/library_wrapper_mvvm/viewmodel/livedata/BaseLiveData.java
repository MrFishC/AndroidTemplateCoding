package cn.jack.library_wrapper_mvvm.viewmodel.livedata;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.MutableLiveData;

/**
 * @author jack
 * @time 20-11-20 下午7:36
 * @desc LiveData基类
 *
 * 官方文档：{https://developer.android.google.cn/topic/libraries/architecture/livedata?hl=zh_cn}
 *
 * 一.特点
 * 1.可观察的数据存储器类(遵循观察者模式)
 * 2.能够感知组件（Fragment、Activity、Service）的生命周期；
 *
 * 二.优势
 * 1.能够保证数据和UI统一
 * 2.不会发生内存泄漏
 * 3.不会因 Activity 停止而导致崩溃
 * 4.不再需要手动处理生命周期
 * 5.组件和数据相关的内容能实时更新
 * 6.针对configuration change时，不需要额外的处理来保存数据
 * 7.共享资源
 *
 * 三.使用
 * 1.通过 setValue(T) 和 postValue(T) 方法，修改存储在 LiveData 对象中的值
 * 2.创建 LiveData 实例以存储某种类型的数据。这通常在 ViewModel 类中完成
 *
 * 四.注意事项
 * 1.请确保用于更新界面的 LiveData 对象存储在 ViewModel 对象中
 *
 */
public class BaseLiveData<T> extends MutableLiveData<T> {

    //将更新 LiveData 实例的值，并将更改通知给任何活跃观察者。
    @MainThread
    @Override
    public void setValue(T value) {
        super.setValue(value);
    }

    //同上
    @WorkerThread
    @Override
    public void postValue(T value) {
        super.postValue(value);
    }

    //拓展一个空参的方法
    @MainThread
    public void call() {
        setValue(null);
    }

}
