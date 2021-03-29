package SqlEngine.Analysis;

import SqlEngine.IO.IOCore;
import SqlEngine.Parser.SqlSegment;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description : 对use命令进行解析 @ Author : 马驰 @ CreateDate : 2019/12/27 15:44
 */
public class Use {
    public static IOCore ioCore;

    public static  ArrayList<String>  use(List<SqlSegment> result, IOCore core ) {
        ioCore = core;
        String sqlSubType = result.get(0).getStart();// sql
        String dbName = result.get(0).getBody();// 表名字
        ioCore.useDB(dbName);

        return ioCore.output;
    }
}
