package jack.module_first.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.alibaba.android.arouter.facade.annotation.Route;
import jack.library_base.router.RouterPathFragment;
import jack.module_first.BR;
import jack.module_first.R;
import jack.module_first.databinding.FirstFragmentBinding;
import jack.module_first.ui.viewmodel.FragmentFristViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-17
 * describe:主页面第一个fragment
 */

//无法自动生成 FirstFragmentDatabinding的原因是什么,尝试了关闭项目重新启动,然后,又能自动生成了.
@Route(path = RouterPathFragment.First.PAGER_FIRST)
public class FirstFragment extends BaseFragment<FirstFragmentBinding,FragmentFristViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.first_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

}
