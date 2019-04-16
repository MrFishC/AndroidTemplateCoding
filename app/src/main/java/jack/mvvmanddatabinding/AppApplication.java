package jack.mvvmanddatabinding;

import jack.library_base.config.ModuleLifecycleConfig;
import me.goldze.mvvmhabit.base.BaseApplication;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:宿主应用的application
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化组件(靠前)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);

        //....

        //初始化组件(靠后)
        ModuleLifecycleConfig.getInstance().initModuleLow(this);
    }
}