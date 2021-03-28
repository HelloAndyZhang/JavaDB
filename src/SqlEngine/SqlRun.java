package SqlEngine;

import SqlEngine.Analysis.*;
import SqlEngine.Parser.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @ Description : 实现一个sql解析器,目前支持create, show, use, quit @ Author : 马驰 @
 * CreateDate : 2019/12/26 17:03
 */
public class SqlRun {

    // 下面是目前支持的sql语句类型
    private static final String create = "create";
    private static final String help = "help";
    private static final String show = "show";
    private static final String use = "use";
    private static final String quit = "quit";
    private static final String describe = "describe";
    private static final String insert = "insert";
    private static final String select = "select";
    private static final String drop = "drop";

    public static void Run(String sql) {
        // 数据格式化
        SqlParserUtil sqlParser = new SqlParserUtil();

        List<SqlSegment> result = sqlParser.getParsedSqlList(sql);//保存解析结果

        result.forEach(i -> {
            System.out.println(i.getBody());
        });


//        // str = sql.split(" ");
//        String start = "";
//        // 正则表达式的匹配规则
//        String regex = "^[a-z]+";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(sql);
//        // 获取匹配值
//        while (matcher.find()) {
//            start = matcher.group();
//        }
//
//        // 根据第一个单词判断该语句的作用
//        switch (start) {
//            case create:
//                Create.createSql(sql);
//                break;
//            case help:
//                Help.help();
//                break;
//            case show:
//                Show.showSql(sql);
//                break;
//            case use:
//                Use.useSql(sql);
//                break;
//            case quit:
//                Quit.quitSql();
//                break;
//            case describe:
//                Describe.describeSql(sql);
//                break;
//            case insert:
//                Insert.insertSql(sql);
//                break;
//            case select:
//                Select.selectSql(sql);
//                break;
//            case drop:
//                Drop.dropSql(sql);
//                break;
//            default:
//                System.out.println("输入的命令无法识别,可以输入help查看目前支持的sql语句");
//                // Input.get();
//                break;
//        }
//        // System.out.println(start);
    }

}

