package cn.jack.library_wrapper_mvvm.viewmodel;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

import cn.jack.library_wrapper_mvvm.model.BaseModel;
import cn.jack.library_wrapper_mvvm.viewmodel.livedata.LiveDataManager;
import cn.jack.library_wrapper_mvvm.viewmodel.livedata.UiCommonLiveData;

/**
 * @author jack
 * @time 20-11-20 下午7:32
 * @desc ViewModel基类（辅助程序类）
 *
 * 官方文档：{https://developer.android.google.cn/topic/libraries/architecture/viewmodel?hl=zh_cn}
 *
 * 一.职责
 * 1.负责为界面准备数据（以注重生命周期的方式存储和管理界面相关的数据）
 * 2.拓展：为ViewModel添加一些常用事件{@link BaseTopViewModel}
 *
 * 二.特点
 * 1.ViewModel 对象存在的时间比视图或 LifecycleOwners(高版本sdk的Activity与Fragment默认实现了LifecycleOwner) 的特定实例存在的时间更长
 * 2.ViewModel 对象可以包含 LifecycleObservers
 *
 * 三.注意
 * 1.ViewModel 绝不能引用视图、Lifecycle 或可能存储对 Activity 上下文的引用的任何类。
 *
 * 四.ViewModel 的生命周期
 *
 * 五.在 Fragment 之间共享数据
 *
 */
public abstract class BaseViewModel extends BaseTopViewModel implements ILifecycleCallback{

    /**
     * ViewModel层持有Model层引用,Model的具体实现类为自定义的xxxRepository(数据仓库类)
     */
    protected BaseModel mModel;

    /**
     * ViewModel层持有LiveData的实现类，通过LiveDataManager类获取
     */

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public <M extends BaseModel> BaseViewModel(@NonNull Application application,M model) {
        super(application);
        this.mModel = model;
    }

    /**
     * 获取LiveData管理类的对象
     * @return LiveDataManager
     */
    public LiveDataManager getLiveDataManager() {
        return LiveDataManager.getInstance();
    }

    /**
     * =============================================== 公共部分,v层通过观察vm层,自行决定是否需要调用v层的方法 start  =================================================
     */

    /**
     * 对话框
     */
    public void showDialog() {
        showDialog(null);
    }

    /**
     * 对话框,自定义提示内容
     */
    public void showDialog(String title) {

    }

    /**
     * 关闭对话框
     */
    public void dismissDialog() {
        LiveDataManager.getInstance().getDismissDialogEvent().call();
    }

    /**
     * 跳转页面
     */
    public void openActivity(Class<?> clz) {
        openActivity(clz, null);
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void openActivity(Class<?> clz, Bundle bundle) {
        Map<String, Object> params = new HashMap<>();
        params.put(LiveDataManager.getInstance().getCLASS(), clz);
        if (bundle != null) {
            params.put(LiveDataManager.getInstance().getBUNDLE(), bundle);
        }
        LiveDataManager.getInstance().getStartActivityEvent().setValue(params);
    }

    /**
     * 关闭界面
     */
    public void finish() {
        LiveDataManager.getInstance().getFinishEvent().call();
    }

    /**
     * 返回上一层
     */
    public void onBackPressed() {
        LiveDataManager.getInstance().getOnBackPressedEvent().call();
    }

    public void closeSoftKey(){
        LiveDataManager.getInstance().getCloseSoftKeyEvent().call();
    }

    /**
     * =============================================== 公共部分,v层通过观察vm层,自行决定是否需要调用v层的方法 end =================================================
     */

    //ViewModel销毁时调用
    @Override
    protected void onCleared() {
        super.onCleared();
        if (mModel != null) {
            mModel.onCleared();
        }
    }

}
