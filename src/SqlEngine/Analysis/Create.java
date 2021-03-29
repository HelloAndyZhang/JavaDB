package SqlEngine.Analysis;

import SqlEngine.IO.*;
import SqlEngine.Parser.ParseException;
import SqlEngine.Parser.SqlSegment;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Description : 以create开头的sql命令
 */
public class Create {

    public static IOCore ioCore;

    /**
     * 创建数据表
     */
    public static void create(List<SqlSegment> result, IOCore core) throws ParseException  {
        ioCore = core;
        String sqlSubType = result.get(1).getStart();// sql
        String sqlName = result.get(1).getBody();// 表名字
        ArrayList<String> dbResult = new ArrayList<>();
        if (sqlSubType.contains("table")) {
            String[] attr = result.get(2).getBody().split(", ");
            List<String> arrList = Arrays.asList(attr);
            ArrayList<String> attributes = new ArrayList(arrList);
            createTable(sqlName, attributes);
        }
        if (sqlSubType.contains("database")) {
             createDB(sqlName);
        }
        System.out.println(dbResult.toString());
    }

    /**
     * 创建数据表
     */
    private static void createDB(String dbName)throws ParseException {
        ioCore.createDB(dbName);
    }

    /**
     * @Description ：创建表格的方法,使用txt文件存储表
     */
    private static ArrayList<String> createTable(String tbName, ArrayList<String> attributes) throws ParseException {

        try {
            ioCore.createTB(tbName, attributes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ioCore.output;
    }
}
