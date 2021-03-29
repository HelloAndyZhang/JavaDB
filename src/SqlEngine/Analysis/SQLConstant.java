package SqlEngine.Analysis;

/**
 * @ Description : 与数据库相关的常量
 */
public class SQLConstant {

    // 数据库的根路径
    private static final String path = "F:\\MyDatabase";

    // 数据库的当前路径
    private static String nowPath = path;

    // 自定义的分隔符
    private static final String separate = "~";

    public static String getPath() {
        return path;
    }

    /**
     * @Description ： 返回当前路径
     */
    public static String getNowPath() {
        return nowPath;
    }

    /**
     * @Description ： 设置当前路径
     */
    public static void setNowPath(String name) {
        nowPath = nowPath + "\\" + name;
    }

    public static String getSeparate() {
        return separate;
    }

}
