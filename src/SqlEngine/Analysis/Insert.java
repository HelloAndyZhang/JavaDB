package SqlEngine.Analysis;

import SqlEngine.IO.IOCore;
import SqlEngine.Parser.ParseException;
import SqlEngine.Parser.SqlSegment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ Description : 实现insert命令
 */
public class Insert {

    public static IOCore ioCore;

    public static void insert(List<SqlSegment> result, IOCore core) throws ParseException, IOException {
        ioCore = core;
        String tbName = result.get(1).getBody();// 表名字
        String[] attr = result.get(2).getBody().split(", ");
        List<String> arrList = Arrays.asList(attr);
        ArrayList<String> attributes = new ArrayList(arrList);
        ioCore.insertInto(tbName, attributes);
    }
}
