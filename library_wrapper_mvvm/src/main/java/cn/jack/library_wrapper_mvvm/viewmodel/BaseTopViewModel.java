package cn.jack.library_wrapper_mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * @author jack
 * @time 20-11-20 下午7:30
 * @desc ViewModel层不能持有V层对象的引用,但有些情况需要使用到context,所以选择继承AndroidViewModel
 */
abstract class BaseTopViewModel extends AndroidViewModel {

    public BaseTopViewModel(@NonNull Application application) {
        super(application);
    }

}
