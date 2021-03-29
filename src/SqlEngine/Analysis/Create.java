package SqlEngine.Analysis;

import  SqlEngine.IO.*;
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
    public  static void create(List<SqlSegment> result, IOCore core ) {
        ioCore = core;
        String sqlSubType = result.get(1).getStart();// sql
        String sqlName = result.get(1).getBody();// 表名字
        ArrayList<String> dbResult = new ArrayList<>();
        try {
            if(sqlSubType.contains("table")) {
                String[] attr = result.get(2).getBody().split(", ");
                List<String> arrList = Arrays.asList(attr);
                ArrayList<String> attributes = new ArrayList(arrList ) ;
                dbResult =  createTable(sqlName, attributes);
            }
            if(sqlSubType.contains("database")){
                dbResult = createDB(sqlName);
            }
            System.out.println(dbResult.toString());

        }catch (IOException pe){
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
    private static ArrayList<String>  createTable(String tbName , ArrayList<String> attributes) throws IOException {

        try {
            ioCore.createTB(tbName, attributes);
        }catch (IOException pe){


        }

        return ioCore.output;

        // 创建表
//            File table = new File(tablePath, tName);


//            if (!table.exists()) {
//
//                // 创建表,以一个文本文件表示一个表
//                try {
//                    table.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

//                // 提取sql语句中关于表中字段的信息
//                // 获取分隔符
//                String sep = SQLConstant.getSeparate();
//                // System.out.println(sql);
//                // 遍历整个sql语句,如果原文本中存在分隔符,则在分隔符前再加一个分隔符,相当于转义
//                String str = sql.replaceAll(sep + "", sep + sep);
//                // System.out.println(str);
//                // 提取出两个括号之间的内容
//                Pattern pattern = Pattern.compile("\\(.*\\)");
//                Matcher matcher = pattern.matcher(sql);
//                String s = "";
//                if (matcher.find()) {
//                    s = matcher.group(0);
//                    // System.out.println(s);
//                }
//                // 分别提取每个字段的内容
//                String s1 = s.substring(1, s.length() - 1);
//                // System.out.println(s1);
//                String[] strings = s1.split(",");
//                // 分别存放三行的信息
//                // String[] strings1 = new String[strings.length];
//                // String[] strings2 = new String[strings.length];
//                // String[] strings3 = new String[strings.length];
//                List<String> list1 = new ArrayList<>();
//                List<String> list2 = new ArrayList<>();
//                List<String> list3 = new ArrayList<>();
//                // 第一行存取列名,第二行存取类型,第三行存取剩余的说明信息
//                for (String s2 : strings) {
//                    String s3 = s2.trim();
//                    System.out.println("xx" + s3);
//                    String[] strings1 = s3.split(" ");
//                    if (strings1.length > 1) {
//                        list2.add(strings1[1]);
//                    }
//                    list1.add(strings1[0]);
//                    for (int i = 2; i < strings1.length; i++) {
//                        // list3.add(strings1[i]);
//                        if (strings1[i].equals("not") && strings1[i + 1].equals("null")) {
//                            list3.add("not null");
//                            i++;
//                        } else {
//                            list3.add(strings1[i]);
//                        }
//                    }
//                    // System.out.println(s3);
//                }
//                // System.out.println("------------");
//                // for(String a:list1){
//                // System.out.println(a);
//                // }
//                // System.out.println("-----------------");
//                // for(String a:list2){
//                // System.out.println(a);
//                // }
//                // System.out.println("-----------------");
//                // for(String a:list3){
//                // System.out.println(a);
//                // }
//
//                // 向表中写入字段信息
//                writeFile(list1);
//                writeFile(list2);
//                writeFile(list3);
//                System.out.println("Query OK");
//            } else {
//                System.out.println("ERROR: 该表已经存在");
//            }

            // sdnu.machi.Input.get();
//        } else {
//            System.out.println("ERROR: 语句有错误");
//            // sdnu.machi.Input.get();
//        }

        // Input.get();
    }

    /**
     * @Description : 将字符串数组写入文件
     * @param : list 需要写入的字符串列表
     * @return : 无
     */
    private static void writeFile(List<String> list) {
        // 将字符串数组连接成一个字符串
        String str = "";
        // System.out.println(str);
        // 获取分隔符
        String sep = SQLConstant.getSeparate();
        // 获取当前表的路径
        String path = SQLConstant.getNowPath();
        String nowPath = path + "\\" ;
        // 拼接字符串
        for (String s1 : list) {
            // System.out.print(s1 + "");
            str += s1 + sep;
        }
        // System.out.println();
        // System.out.println(str);
        // System.out.println(str);

        try {
            FileOutputStream fos = new FileOutputStream(new File(nowPath), true);
            str += "\r\n";
            fos.write(str.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
