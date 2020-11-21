package cn.jack.library_wrapper_mvvm.viewmodel;

import androidx.lifecycle.DefaultLifecycleObserver;

/**
 * @author jack
 * @time 20-11-21 下午2:34
 * @desc 让VM层观察V层（VM实现LifecycleObserver接口）
 *
 * 官方文档{https://developer.android.google.cn/reference/android/arch/lifecycle/Lifecycle}
 */
interface ILifecycleCallback extends DefaultLifecycleObserver{

}
