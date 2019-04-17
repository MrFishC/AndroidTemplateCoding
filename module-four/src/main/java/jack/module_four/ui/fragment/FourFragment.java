package jack.module_four.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.alibaba.android.arouter.facade.annotation.Route;
import jack.library_base.router.RouterPathFragment;
import jack.module_four.R;
import jack.module_four.BR;
import jack.module_four.databinding.FourFragmentBinding;
import jack.module_four.ui.viewmodel.FragmentFourViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-17
 * describe:主页面第四个fragment
 */

@Route(path = RouterPathFragment.Four.PAGER_FOUR)
public class FourFragment extends BaseFragment<FourFragmentBinding,FragmentFourViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.four_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

}
