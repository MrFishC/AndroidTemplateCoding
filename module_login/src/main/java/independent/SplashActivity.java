package independent;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.launcher.ARouter;
import jack.library_base.router.RouterPathActivity;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:欢迎页面
 */
public class SplashActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                inMain();
            }
        }, 3 * 1000);
    }

    /**
     * 进入主页面
     */
    private void inMain() {
        // 1. Simple jump within application (Jump via URL in 'Advanced usage')
        ARouter.getInstance().build(RouterPathActivity.Main.PAGER_MAIN).navigation();
        finish();
    }
}
