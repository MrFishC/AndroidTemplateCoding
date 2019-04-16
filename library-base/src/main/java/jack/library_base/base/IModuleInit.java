package jack.library_base.base;

import android.app.Application;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:
 */
public interface IModuleInit {
    //初始化优先的
    boolean onInitAhead(Application application);

    //初始化靠后的
    boolean onInitLow(Application application);
}
