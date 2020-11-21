package cn.jack.library_wrapper_mvvm.viewmodel.livedata;

import java.util.Map;

/**
 * @author jack
 * @time 20-11-21 下午11:57
 * @desc LiveData管理类
 */
public class LiveDataManager {

    //服务于页面跳转
    private String CLASS = "CLASS";
    private String BUNDLE = "BUNDLE";

    /**
     * 使用静态内部类的方式实现单例
     *
     * 加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。
     */
    public static LiveDataManager getInstance() {
        return LiveDataManager.Holder.INSTANCE;
    }

    private static class Holder {
        private static final LiveDataManager INSTANCE = new LiveDataManager();
    }

    private LiveDataManager() {

    }

    public String getCLASS() {
        return CLASS;
    }

    public String getBUNDLE() {
        return BUNDLE;
    }

    //通常，LiveData 仅在数据发生更改时才发送更新，并且仅发送给活跃观察者
    //V层设置监听，VM层通过setValue(T)等方法

    private UiCommonLiveData<String>                mShowDialogEvent;
    private UiCommonLiveData<Void>                  mDismissDialogEvent;
    private UiCommonLiveData<Void>                  mFinishEvent;
    private UiCommonLiveData<Void>                  mOnBackPressedEvent;
    private UiCommonLiveData<Void>                  mCloseSoftKeyEvent;
    private UiCommonLiveData<Map<String, Object>>   mStartActivityEvent;
    private UiCommonLiveData<String>                  mToastStateEvent;

    //todo 状态布局/网络情况展示

    /**
     * 展示对话框事件对象
     */
    public BaseLiveData<String> getShowDialogEvent() {
        return mShowDialogEvent = createLiveData(mShowDialogEvent);
    }

    /**
     * 关闭对话框事件对象
     */
    public BaseLiveData<Void> getDismissDialogEvent() {
        return mDismissDialogEvent = createLiveData(mDismissDialogEvent);
    }

    /**
     * 关闭界面事件对象
     */
    public BaseLiveData<Void> getFinishEvent() {
        return mFinishEvent = createLiveData(mFinishEvent);
    }

    /**
     * 点击返回按钮事件对象
     */
    public BaseLiveData<Void> getOnBackPressedEvent() {
        return mOnBackPressedEvent = createLiveData(mOnBackPressedEvent);
    }

    /**
     * 关闭软件盘事件
     */
    public BaseLiveData<Void> getCloseSoftKeyEvent() {
        return mCloseSoftKeyEvent = createLiveData(mCloseSoftKeyEvent);
    }

    /**
     * 跳转activtiy事件对象
     */
    public BaseLiveData<Map<String, Object>> getStartActivityEvent() {
        return mStartActivityEvent = createLiveData(mStartActivityEvent);
    }

    /**
     * 吐司事件
     */
    public BaseLiveData<String> getToastStateEvent() {
        return mToastStateEvent = createLiveData(mToastStateEvent);
    }

    /**
     * Create a UiCommonLiveData
     * @param liveData UiCommonLiveData
     * @return UiCommonLiveData
     */
    private static<T> UiCommonLiveData<T> createLiveData(UiCommonLiveData<T> liveData) {
        if (liveData == null) {
            liveData = new UiCommonLiveData<T>();
        }
        return liveData;
    }

}
