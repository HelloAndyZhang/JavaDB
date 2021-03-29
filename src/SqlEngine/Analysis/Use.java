package SqlEngine.Analysis;

import SqlEngine.IO.IOCore;
import SqlEngine.Parser.SqlSegment;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description : 对use命令进行解析
 */
public class Use {
    public static IOCore ioCore;

    public static ArrayList<String> use(List<SqlSegment> result, IOCore core) {
        ioCore = core;
        String dbName = result.get(0).getBody();// 表名字
        ioCore.useDB(dbName);
        return ioCore.output;
    }
}
