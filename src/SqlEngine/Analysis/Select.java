package SqlEngine.Analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import SqlEngine.IO.IOCore;
import SqlEngine.Parser.ParseException;
import SqlEngine.Parser.SqlSegment;

/**
 * @ Description : 实现select语句
 */
public class Select {
    public static IOCore ioCore;

    /**
     * @Description : 实现select查询的主函数,目前只实现了select * from 表名;
     * @return : void
     */
    public static void select(List<SqlSegment> result, IOCore core) throws ParseException,IOException {
        ioCore = core;
        String tbName = result.get(1).getBody();// 表名字
        String[] attr = result.get(2).getBody().split(", ");
        List<String> arrList = Arrays.asList(attr);
        ArrayList<String> attributes = new ArrayList(arrList);
        ioCore.select(tbName, attributes, null);
    }
}
