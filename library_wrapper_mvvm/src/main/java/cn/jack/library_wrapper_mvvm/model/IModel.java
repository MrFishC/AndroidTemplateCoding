package cn.jack.library_wrapper_mvvm.model;

/**
 * @author jack
 * @time 20-11-20 下午7:24
 * @desc
 */
public interface IModel {
    /**
     * 处理Rxjava引起的内存泄漏
     */
    void onCleared();
}
