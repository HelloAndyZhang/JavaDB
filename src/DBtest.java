import SqlEngine.*;
import SqlEngine.Parser.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class DBtest {
    final static String tests = "DROP DATABASE markbook;\n" + "CREATE DATABASE markbook;\n" + "USE markbook;\n"
            + "CREATE TABLE marks (name, mark, pass);\n" + "INSERT INTO marks VALUES ('Steve', 65, true);\n"
            + "INSERT INTO marks VALUES ('Dave', 55, true);\n"
            + "INSERT INTO marks VALUES ('Bob', 35, false);\n"
            + "INSERT INTO marks VALUES ('Clive', 20, false);\n" + "SELECT * FROM marks;\n"
            + "SELECT * FROM marks;\n" + "DELETE FROM marks WHERE mark < 40;\n" + "SELECT * FROM marks;\n";
    final static String tests2 = "INSERT INTO marks VALUES ('Steve', 65, true);\n"
            + "INSERT INTO marks VALUES ('Dave', 55, true);\n"
            + "INSERT INTO marks VALUES ('Bob', 35, false);\n"
            + "INSERT INTO marks VALUES ('Clive', 20, false);\n" + "SELECT * FROM marks;\n"
            + "SELECT * FROM marks;\n" + "DELETE FROM marks WHERE mark < 40;\n" + "SELECT * FROM marks;\n";

    public static void main(String[] args) throws ParseException, IOException {
        SqlRun sqlRun = new SqlRun();
        try {
            sqlRun.Run("CREATE DATABASE markbook;");
        } catch (ParseException pe) {
            System.out.println(pe.ToString());
        }

        try {
            sqlRun.Run("USE markbook;");
        } catch (ParseException pe) {
            System.out.println(pe.ToString());
        }
        try {
            sqlRun.Run("CREATE TABLE marks (name, mark, pass);");
        } catch (ParseException pe) {
            System.out.println(pe.ToString());
        }
        try {
            sqlRun.Run("INSERT INTO marks VALUES ('Steve', 65, true);");
        } catch (ParseException pe) {
            System.out.println(pe.ToString());
        }
        try {
            sqlRun.Run("SELECT * FROM marks;");
        } catch (ParseException pe) {
            System.out.println(pe.ToString());
        }
    }
}
