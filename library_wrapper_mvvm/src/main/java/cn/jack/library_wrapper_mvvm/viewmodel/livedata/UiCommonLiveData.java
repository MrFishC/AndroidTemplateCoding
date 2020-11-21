package cn.jack.library_wrapper_mvvm.viewmodel.livedata;

import java.util.Map;

/**
 * @author jack
 * @time 20-11-21 下午2:53
 * @desc UiCommonLiveData的使用{https://developer.android.google.cn/topic/libraries/architecture/livedata?hl=zh_cn#work_livedata}
 *
 * 1.在VM层创建 UiCommonLiveData 实例以存储某种类型的数据;
 * 2.在V层创建（可定义 onChanged() 方法的）Observer的对象
 * 3.使用observe()方法(UiCommonLiveData对象调用observe方法，传入LifecycleOwner[高版本SDK中的Activity 或 Fragment的父类实现了LifecycleOwner接口]对象);
 *
 * {https://www.cnblogs.com/liyanyan665/p/11379441.html}
 *
 * 如果 Lifecycle 对象未处于活跃状态，那么即使值发生更改，也不会调用观察者。
 * 销毁 Lifecycle 对象后，会自动移除观察者。
 */
public class UiCommonLiveData<T> extends BaseLiveData<T>{

    //通常，LiveData 仅在数据发生更改时才发送更新，并且仅发送给活跃观察者
    //V层设置监听，VM层通过setValue(T)等方法

    //当 LiveData 对象具有活跃观察者时，会调用 onActive() 方法
    @Override
    protected void onActive() {
        super.onActive();
    }

    //当 LiveData 对象没有任何活跃观察者时，会调用 onInactive() 方法
    @Override
    protected void onInactive() {
        super.onInactive();
    }

}
