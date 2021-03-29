package SqlEngine;

import SqlEngine.Analysis.*;
import SqlEngine.IO.IOCore;
import SqlEngine.Parser.*;

import java.util.List;

/**
 * @ Description : 实现一个sql解析器,目前支持create, show, use,
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

    IOCore ioCore; //Keeps track of where we are in the tokens array, check syntax is correct

    public SqlRun() {
        ioCore = new IOCore(); //

    }
    public  void Run(String sql) {
        // 数据格式化
        SqlParserUtil sqlParser = new SqlParserUtil();
        List<SqlSegment> result = sqlParser.getParsedSqlList(sql);//保存解析结果
        if(result.size() == 0) throw new Error("sql error");
        String sqlType = result.get(0).getStart(); // sql类型
        System.out.println(sqlType);

        switch (sqlType) {
            case create:
                Create.create(result,ioCore);
                break;
            case help:
                Help.help();
                break;
            case show:
                Show.showSql(sql);
                break;
            case use:
                Use.use(result,ioCore);
                break;
            case quit:
                Quit.quitSql();
                break;
            case describe:
                Describe.describeSql(sql);
                break;
            case insert:
                Insert.insertSql(result,ioCore);
                break;
            case select:
                Select.selectSql(sql);
                break;
            case drop:
                Drop.dropSql(sql);
                break;
            default:
                System.out.println("输入的命令无法识别,可以输入help查看目前支持的sql语句");
                // Input.get();
                break;
        }
//        // System.out.println(start);
    }

}

