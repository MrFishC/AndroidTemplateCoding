package jack.module_main.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import java.util.ArrayList;
import java.util.List;
import jack.library_base.router.RouterPathActivity;
import jack.library_base.router.RouterPathFragment;
import jack.module_main.BR;
import jack.module_main.R;
import jack.module_main.databinding.MainActivityMainBinding;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:程序主页面
 */
@Route(path = RouterPathActivity.Main.PAGER_MAIN)
public class MainActivity extends BaseActivity<MainActivityMainBinding, BaseViewModel> {

    private List<Fragment> mFragments;

    //MainActivityMainBinding 根据布局文件来生成对应的名称
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.main_activity_main;
    }

    @Override
    public int initVariableId() {
        //todo 未明白具体用法
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();

        //初始化Fragment
        initFragment();
        //初始化底部Button
        initBottomTab();
    }

    /**
     * 底部导航栏
     */
    private void initBottomTab() {
        //未能通过 databing.生成的控件id的方式去调用了,即不能使用binding.mainBottomTab,原因何在? 重启了项目然后又可以了.
        //NavigationController用法,https://github.com/tyzlmjj/PagerBottomTabStrip/wiki/V2_%E5%BF%AB%E9%80%9F%E6%9E%84%E5%BB%BA
        NavigationController navigationController = binding.mainBottomTab.material()
                .addItem(R.drawable.iv_timetables_selector,getString(R.string.text_timetable))
                .addItem(R.drawable.iv_register_selector, getString(R.string.text_register))
                .addItem(R.drawable.iv_contact_selector, getString(R.string.text_contact))
                .addItem(R.drawable.iv_work_selector, getString(R.string.text_work))
                .build();

        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                //选中时触发
                Fragment currentFragment = mFragments.get(index);
                if (currentFragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_fragment_contain, currentFragment);
                    transaction.commitAllowingStateLoss();
                }
            }

            @Override
            public void onRepeat(int index) {
                //重复选中时触发
            }
        });
    }

    private void initFragment() {

        //ARouter拿到多Fragment(这里需要通过ARouter获取，不能直接new,因为在组件独立运行时，宿主app是没有依赖其他组件，所以new不到其他组件的Fragment)
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(RouterPathFragment.First.PAGER_FIRST).navigation();
        Fragment categoryFragment = (Fragment) ARouter.getInstance().build(RouterPathFragment.Second.PAGER_SECOND).navigation();
        Fragment serviceFragment = (Fragment) ARouter.getInstance().build(RouterPathFragment.Third.PAGER_THIRD).navigation();
        Fragment mineFragment = (Fragment) ARouter.getInstance().build(RouterPathFragment.Four.PAGER_FOUR).navigation();

        mFragments = new ArrayList<>();

        mFragments.add(homeFragment);
        mFragments.add(categoryFragment);
        mFragments.add(serviceFragment);
        mFragments.add(mineFragment);

        if (homeFragment != null) {
            //默认选中第一个
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.main_fragment_contain, homeFragment);
            transaction.commitAllowingStateLoss();
        }

    }

}
