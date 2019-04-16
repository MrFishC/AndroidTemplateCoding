package jack.library_base.config;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:组件生命周期反射类名管理,通过反射动态调用各个组件的初始化方法
 *
 * todo 注意：以下模块中初始化的Module类不能被混淆
 */
public class ModuleLifecycleReflexs {

    //基础模块
    private static final String BaseInit = "jack.library_base.base.BaseModuleInit";
    //业务模块-登录模块
    private static final String LoginInit = "jack.module_login.LoginModuleInit";
    //业务模块-首页
    private static final String MainInit = "jack.module_main.MainModuleInit";
    //业务模块-首页第一个fragment
    private static final String OneInit = "jack.module_one.OneModuleInit";
    //业务模块-首页第二个fragment
    private static final String SecondInit = "jack.module_second.SecondModuleInit";
    //业务模块-首页第三个fragment
    private static final String ThirdInit = "jack.module_third.ThirdModuleInit";
    //业务模块-首页第四个fragment
    private static final String FourInit = "jack.module_four.FourModuleInit";

    public static String[] initModuleNames = {BaseInit,LoginInit, MainInit,OneInit,SecondInit,ThirdInit,FourInit};

}
