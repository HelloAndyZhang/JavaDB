import Interpreter.Input;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DBtest {
    final static String tests = "DROP DATABASE markbook;\n" + "CREATE DATABASE markbook;\n" + "USE markbook;\n"
            + "CREATE TABLE marks (name, mark, pass);\n" + "INSERT INTO marks VALUES ('Steve', 65, true);\n"
            + "INSERT INTO marks VALUES ('Dave', 55, true);\n" + "INSERT INTO marks VALUES ('Bob', 35, false);\n"
            + "INSERT INTO marks VALUES ('Clive', 20, false);\n" + "SELECT * FROM marks;\n" + "SELECT * FROM marks;\n"
            + "DELETE FROM marks WHERE mark < 40;\n" + "SELECT * FROM marks;\n";

    public static void main(String[] args) {
        Input input = new Input();
        String[] commandLine = tests.split("\\n");
        for (int i = 0; i < commandLine.length; i++) {
            System.out.println("cc" + commandLine[i]);
            input.execute(commandLine[i]);
        }

    }
}
