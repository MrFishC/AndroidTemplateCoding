package jack.mvvmanddatabinding;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;

import jack.library_base.config.ModuleLifecycleConfig;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:宿主应用的application
 */
public class AppApplication extends Application {

    private static Application sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        setApplication(this);

        //初始化组件(靠前)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);

        //....

        //初始化组件(靠后)
        ModuleLifecycleConfig.getInstance().initModuleLow(this);
    }

    /**
     * 当主工程没有继承BaseApplication时，可以使用setApplication方法初始化BaseApplication
     *
     * @param application
     */
    public static synchronized void setApplication(@NonNull Application application) {
        sInstance = application;

        //注册监听每个activity的生命周期,便于堆栈式管理
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    /**
     * 获得当前app运行的Application
     */
    public static Application getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("please inherit BaseApplication or call setApplication.");
        }
        return sInstance;
    }

}