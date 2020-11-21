package jack.module_third.ui.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.alibaba.android.arouter.facade.annotation.Route;
import jack.library_base.router.RouterPathFragment;
import jack.module_third.BR;
import jack.module_third.R;
import jack.module_third.databinding.ThirdFragmentBinding;
import jack.module_third.ui.viewmodel.FragmentThirdViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-17
 * describe:主页面第三个fragment
 */

@Route(path = RouterPathFragment.Second.PAGER_SECOND)
public class ThirdFragment extends BaseFragment<ThirdFragmentBinding,FragmentThirdViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.third_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

}
