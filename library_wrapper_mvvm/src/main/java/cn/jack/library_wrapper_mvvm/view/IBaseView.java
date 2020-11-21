package cn.jack.library_wrapper_mvvm.view;

/**
 * @author jack
 * @time 20-11-22 上午1:29
 * @desc 需要BaseActivity类或其子类去实现的方法
 */
interface IBaseView {

    void init();

    /**
     * 初始化界面传递参数
     */
    void initParam();

    /**
     * 初始化数据
     */
    void initData();

    /**
     * 初始化监听
     */
    void initListener();

}
