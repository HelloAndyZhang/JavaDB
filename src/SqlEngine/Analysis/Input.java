package SqlEngine.Analysis;

import java.util.Scanner;

/**
 * @ Description : 获取输入的命令
 */
public class Input {

    public static void get() {
        // 一个完整的语句输入默认以;结尾
//        Scanner scanner = new Scanner(System.in);
//        String input = "";
//        do {
//            System.out.print(">>");
//            input += " " + scanner.nextLine();
//            // 解决;后有多个空格不能结束的问题
//            input = input.replaceFirst("(\\s+)$", "");
//            // System.out.println(input);
//        } while (!input.endsWith(";"));
//
//        // System.out.println(input);
//        // 格式化字符串
//        String sql = Format.sqlFromat(input);
//        // System.out.println(sql);
//        // System.out.println("----------");
//        SqlAnalysis.analysis(sql);
    }

    public void execute(String input) {
        // 一个完整的语句输入默认以;结尾
//        do {
//            System.out.print(">>");
//            // 解决;后有多个空格不能结束的问题
//            input = input.replaceFirst("(\\s+)$", "");
//            // System.out.println(input);
//        } while (!input.endsWith(";"));
//
//        // System.out.println(input);
//        // 格式化字符串
//        String sql = Format.sqlFromat(input);
//        // System.out.println(sql);
//        // System.out.println("----------");
//        SqlAnalysis.analysis(sql);
    }
}
