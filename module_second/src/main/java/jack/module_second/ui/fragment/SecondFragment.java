package jack.module_second.ui.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.alibaba.android.arouter.facade.annotation.Route;
import jack.library_base.router.RouterPathFragment;
import jack.module_second.BR;
import jack.module_second.databinding.SecondFragmentBinding;
import jack.module_second.ui.viewmodel.FragmentSecondViewModel;
import jack.module_second.R;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-17
 * describe:主页面第二个fragment
 */

@Route(path = RouterPathFragment.Third.PAGER_THIRD)
public class SecondFragment extends BaseFragment<SecondFragmentBinding,FragmentSecondViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.second_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

}
