package jack.library_base.config;

import android.app.Application;

import io.reactivex.annotations.Nullable;
import jack.library_base.base.IModuleInit;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:作为组件生命周期初始化的配置类，通过反射机制，动态调用每个组件初始化逻辑
 */
public class ModuleLifecycleConfig {

    //内部类实现单例，在装载该内部类时才会去创建单例对象
    private static class SingletonHolder {
        public static ModuleLifecycleConfig instance = new ModuleLifecycleConfig();
    }

    public static ModuleLifecycleConfig getInstance() {
        return SingletonHolder.instance;
    }

    private ModuleLifecycleConfig() {}

    /**
     * 初始化组件-靠前
     * @param application
     */
    public void initModuleAhead(@Nullable Application application) {
        for (String moduleInitName :ModuleLifecycleReflexs.initModuleNames) {
            try {
                Class<?> clazz = Class.forName(moduleInitName);
                IModuleInit init = (IModuleInit) clazz.newInstance();
                //调用初始化方法
                init.onInitAhead(application);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化组件-靠后
     * @param application
     */
    public void initModuleLow(@Nullable Application application) {
        for (String moduleInitName : ModuleLifecycleReflexs.initModuleNames) {
            try {
                Class<?> clazz = Class.forName(moduleInitName);
                IModuleInit init = (IModuleInit) clazz.newInstance();
                //调用初始化方法
                init.onInitLow(application);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
