package jack.library_base.router;

/**
 * created by Jack
 * email:yucrun@163.com
 * date:19-4-16
 * describe:用于组件化开发中ARouter多Fragment跳转的统一路径注册,一定要清楚地写好注释，标明功能界面;
 */
public class RouterPathFragment {

    /**
     * module-one
     */
    public static class One {
        private static final String ONE = "/one";
        /*首页-one*/
        public static final String PAGER_ONE = ONE + "/One";
    }

    /**
     * module-second
     */
    public static class Second {
        private static final String SECOND = "/second";
        /*首页-second*/
        public static final String PAGER_SECOND = SECOND + "/Second";
    }

    /**
     * module-third
     */
    public static class Third {
        private static final String THIRD = "/third";
        /*首页-third*/
        public static final String PAGER_THIRD = THIRD + "/Third";
    }

    /**
     * module-four
     */
    public static class Four {
        private static final String FOUR = "/four";
        /*首页-four*/
        public static final String PAGER_FOUR = FOUR + "/Four";
    }
}
