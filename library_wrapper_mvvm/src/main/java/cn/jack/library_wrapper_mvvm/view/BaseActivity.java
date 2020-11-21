package cn.jack.library_wrapper_mvvm.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import cn.jack.library_wrapper_mvvm.viewmodel.BaseViewModel;

/**
 * @author jack
 * @time 20-11-21 下午12:51
 * @desc activity基类
 */
public abstract class BaseActivity<V extends ViewDataBinding,VM extends BaseViewModel> extends AppCompatActivity implements IBaseView{

    protected V mBinding;
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        initViewDataBindingAndViewModel();

        //注册监听
        registorUIChangeLiveDataCallBack();

        //默认的初始化的顺序
        initPrepare();
    }


    /**
     * 可以自定拓展，修改该方法（建议）
     *
     * 沉寂式状态栏
     * Arouter
     * 事件总线
     */
    @Override
    public final void init() {

    }


    /**
     * 模板设计模式
     */
    protected final void initPrepare() {
        //初始化参数
        initParam();
        //初始化数据
        initData();
        //设置监听
        initListener();
    }

    /**
     * VM层调用UiCommonLiveData(LiveData的子类)的setValue(T)等方法,触发Observer的onChanged回调执行;
     * 在viewmodel中执行逻辑的时候,通知view层更改ui的回调,公共部分
     *
     * （匿名内部类使代码结构更清爽）
     */
    protected void registorUIChangeLiveDataCallBack(){
        //1.展示 加载对话框(带自定义标题)
        mViewModel.getLiveDataManager().getShowDialogEvent().observe(this, mShowDialogObserver);
        //2.关闭 加载对话框
        mViewModel.getLiveDataManager().getDismissDialogEvent().observe(this, mDismissDialogObserver);
        //3.跳入新页面
        mViewModel.getLiveDataManager().getStartActivityEvent().observe(this, mOpenActivityObserver);
        //4.关闭界面
        mViewModel.getLiveDataManager().getFinishEvent().observe(this, mCloseActivityObserver);
        //5.关闭上一层
        mViewModel.getLiveDataManager().getOnBackPressedEvent().observe(this, mBackPressObserver);
        //6.关闭软件盘
        mViewModel.getLiveDataManager().getCloseSoftKeyEvent().observe(this, mCloseSoftKeyObserver);
        //7.吐司
        mViewModel.getLiveDataManager().getToastStateEvent().observe(this, mToastObserver);
    }

    private final Observer<String> mShowDialogObserver = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String title) {
            //对话框工具类 加载对话框          todo 创建一个类管理所有的工具类

        }
    };

    private final Observer<Void> mDismissDialogObserver = new Observer<Void>() {
        @Override
        public void onChanged(@Nullable Void v) {
            //对话框工具类 关闭对话框

        }
    };

    private final Observer<Map<String, Object>> mOpenActivityObserver = new Observer<Map<String, Object>>() {
        @Override
        public void onChanged(@Nullable Map<String, Object> params) {
            Class<?> clz = (Class<?>) params.get(mViewModel.getLiveDataManager().getCLASS());
            Bundle bundle = (Bundle) params.get(mViewModel.getLiveDataManager().getBUNDLE());

            //            openActivity(clz, bundle);
            //页面跳转工具类

        }
    };

    private final Observer<Void> mCloseActivityObserver = new Observer<Void>() {
        @Override
        public void onChanged(@Nullable Void v) {
            finish();
        }
    };

    private final Observer<Void> mBackPressObserver = new Observer<Void>() {
        @Override
        public void onChanged(@Nullable Void v) {
            onBackPressed();
        }
    };

    private final Observer<Void> mCloseSoftKeyObserver = new Observer<Void>() {
        @Override
        public void onChanged(@Nullable Void v) {
            //软件盘工具类关闭软件盘

        }
    };

    private final Observer<String> mToastObserver = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String toast) {
            //吐司工具类 展示信息

        }
    };

    /**
     * 初始化 DataBinding和ViewModel
     */
    private void initViewDataBindingAndViewModel() {

        mBinding = DataBindingUtil.setContentView(this, initContentView());

        mViewModel = initViewModel();

        //使用自定义的ViewModelFactory来创建ViewModel
        if (mViewModel == null) {
            Class modelClass;
            //Type:是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
            //获得带有泛型的父类
            Type type = getClass().getGenericSuperclass();

            //ParameterizedType参数化类型，即泛型
            if (type instanceof ParameterizedType) {
                //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) createViewModel( modelClass);
        }

        //关联ViewModel
        mBinding.setVariable(initVariableId(), mViewModel);

        //让ViewModel拥有View的生命周期感应
        //将实现了LifecycleObserver接口的ViewModol实例作为观察者，添加到Activity/Fragment的生命周期观察者队列中
        getLifecycle().addObserver(mViewModel);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //解除ViewModel生命周期感应(将ViewModel从Activity/Fragment的生命周期观察者队列中移除)
        if(mViewModel!=null){
            getLifecycle().removeObserver(mViewModel);
        }

        if(mBinding != null){
            mBinding.unbind();
        }

    }

    /**
     * @return 布局layout的id
     */
    protected abstract int initContentView();

    /**
     * 初始化ViewModel
     * @return 继承BaseViewModel的ViewModel
     */
    protected VM initViewModel() {
        return null;
    }

    /**
     * 初始化ViewModel的id
     *
     * 使用BR.xxx找到这个ViewModel的id,必须要导对应的包，具体原因可查看XxxImpl类源码
     * @return BR的id (BR由系统生成)
     */
    protected abstract int initVariableId();

    /**
     * @return  mode实例
     */
    private <T extends ViewModel> T createViewModel(Class<T> cls) {
        return new ViewModelProvider(this).get(cls);
    }

}
