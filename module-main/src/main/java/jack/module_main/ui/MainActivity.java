package jack.module_main.ui;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import jack.library_base.router.RouterPathActivity;
import jack.module_main.R;
import jack.module_main.databinding.MainActivityMainBinding;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:程序主页面
 */
@Route(path = RouterPathActivity.Main.PAGER_MAIN)
public class MainActivity extends BaseActivity<MainActivityMainBinding, BaseViewModel> {

    //MainActivityMainBinding 根据布局文件来生成对应的名称
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.main_activity_main;
    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
