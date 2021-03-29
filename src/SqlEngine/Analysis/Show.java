package SqlEngine.Analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import SqlEngine.IO.IOCore;
import SqlEngine.Parser.SqlSegment;

/**
 * @ Description : 以show为开头的命令
 */
public class Show {
    public static IOCore ioCore;

    public static void showSql(List<SqlSegment> result, IOCore core) {

        ioCore = core;
        String sqlSubType = result.get(1).getStart();// sql
        String sqlName = result.get(1).getBody();// 表名字
        ArrayList<String> dbResult = new ArrayList<>();
        if (sqlSubType.contains("table")) {
            String[] attr = result.get(2).getBody().split(", ");
            List<String> arrList = Arrays.asList(attr);
            ArrayList<String> attributes = new ArrayList(arrList);
        }
        if (sqlSubType.contains("database")) {

        }
        System.out.println(dbResult.toString());

    }

}
