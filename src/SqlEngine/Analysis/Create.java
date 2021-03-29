package SqlEngine.Analysis;

import SqlEngine.IO.*;
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
    public static void create(List<SqlSegment> result, IOCore core) {
        ioCore = core;
        String sqlSubType = result.get(1).getStart();// sql
        String sqlName = result.get(1).getBody();// 表名字
        ArrayList<String> dbResult = new ArrayList<>();
        try {
            if (sqlSubType.contains("table")) {
                String[] attr = result.get(2).getBody().split(", ");
                List<String> arrList = Arrays.asList(attr);
                ArrayList<String> attributes = new ArrayList(arrList);
                dbResult = createTable(sqlName, attributes);
            }
            if (sqlSubType.contains("database")) {
                dbResult = createDB(sqlName);
            }
            System.out.println(dbResult.toString());

        } catch (IOException pe) {
            System.out.println(pe.toString());
        }

    }

    /**
     * 创建数据表
     */
    private static ArrayList<String> createDB(String dbName) {
        ioCore.createDB(dbName);
        return ioCore.output;
    }

    /**
     * @Description ：创建表格的方法,使用txt文件存储表
     */
    private static ArrayList<String> createTable(String tbName, ArrayList<String> attributes) throws IOException {

        try {
            ioCore.createTB(tbName, attributes);
        } catch (IOException pe) {

        }
        return ioCore.output;
    }
}
