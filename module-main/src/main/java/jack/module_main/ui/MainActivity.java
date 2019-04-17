package jack.module_main.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;

import jack.library_base.router.RouterPathActivity;
import jack.module_main.BR;
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

    public LinearLayout mNavigationView;
    public View mLlHome;
    public View mLlCategory;
    public View mLlService;
    public View mLlMine;

    //MainActivityMainBinding 根据布局文件来生成对应的名称
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.main_activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();

        mNavigationView = (LinearLayout) findViewById(R.id.navigation_bar_height);
        mLlHome =  findViewById(R.id.ll_home);
        mLlCategory =  findViewById(R.id.ll_category);
        mLlService =  findViewById(R.id.ll_service);
        mLlMine =  findViewById(R.id.ll_mine);

        selectedFragment(0);
    }

    private void selectedFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case 0:
//                if (timetablesFragment == null) {
//                    timetablesFragment = new TimetablesFragment();
//                    transaction.add(R.id.main_fragment_contain, timetablesFragment);
//                } else
//                    transaction.show(timetablesFragment);
//                break;
//            case 1:
//                if (registerFragment == null) {
//                    registerFragment = new RegisterFragment();
//                    transaction.add(R.id.main_fragment_contain, registerFragment);
//                } else
//                    transaction.show(registerFragment);
//                break;
//            case 2:
//                if (contactFragment == null) {
//                    contactFragment = new ContactFragment();
//                    transaction.add(R.id.main_fragment_contain, contactFragment);
//                } else
//                    transaction.show(contactFragment);
//                break;
//            case 3:
//                if (workFragment == null) {
//                    workFragment = new WorkFragment();
//                    transaction.add(R.id.main_fragment_contain, workFragment);
//                } else
//                    transaction.show(workFragment);
//                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
//        if (timetablesFragment != null)
//            transaction.hide(timetablesFragment);
//        if (registerFragment != null)
//            transaction.hide(registerFragment);
//        if (contactFragment != null)
//            transaction.hide(contactFragment);
//        if (workFragment != null)
//            transaction.hide(workFragment);
    }

    private void tabSelected(View linearLayout) {
        mLlHome.setSelected(false);
        mLlCategory.setSelected(false);
        mLlService.setSelected(false);
        mLlMine.setSelected(false);
        linearLayout.setSelected(true);
    }
}
