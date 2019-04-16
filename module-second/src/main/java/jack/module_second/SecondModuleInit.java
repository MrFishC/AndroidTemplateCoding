package jack.module_second;

import android.app.Application;

import jack.library_base.base.IModuleInit;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:业务模块module-second初始化
 */
public class SecondModuleInit implements IModuleInit {

    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("业务模块初始化 -- second - onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        KLog.e("业务模块初始化 -- second -onInitLow");
        return false;
    }
}
