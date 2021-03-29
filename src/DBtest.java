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

        public static void main(String[] args) {
                // String[] commandLine = tests2.split("\\n");
                SqlRun sqlRun = new SqlRun();
                sqlRun.Run("CREATE DATABASE markbook;");
                sqlRun.Run("USE markbook;");
                sqlRun.Run("CREATE TABLE marks (name, mark, pass);");
                sqlRun.Run("INSERT INTO marks VALUES ('Steve', 65, true);");
                sqlRun.Run("SELECT * FROM marks;");
                // for (int i = 0; i < commandLine.length; i++) {
                // SqlRun sqlRun = new SqlRun();
                // sqlRun.Run(commandLine[i]);

                // // System.out.println("cc" + commandLine[i]);
                // // input.execute(commandLine[i]);
                // }

        }
}
