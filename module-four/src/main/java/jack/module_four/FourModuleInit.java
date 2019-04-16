package jack.module_four;

import android.app.Application;

import jack.library_base.base.IModuleInit;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:业务模块module-four初始化
 */
public class FourModuleInit implements IModuleInit {

    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("业务模块初始化 -- four - onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        KLog.e("业务模块初始化 -- four -onInitLow");
        return false;
    }
}
