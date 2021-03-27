import Interpreter.Input;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DBtest {
    final static String tests = "DROP DATABASE markbook;\n" + "CREATE DATABASE markbook;\n" + "USE markbook;\n"
            + "CREATE TABLE marks (name, mark, pass);\n" + "INSERT INTO marks VALUES ('Steve', 65, true);\n"
            + "INSERT INTO marks VALUES ('Dave', 55, true);\n" + "INSERT INTO marks VALUES ('Bob', 35, false);\n"
            + "INSERT INTO marks VALUES ('Clive', 20, false);\n" + "SELECT * FROM marks;\n"
            + "SELECT * FROM marks WHERE name != 'Dave';\n" + "SELECT * FROM marks WHERE pass == true;\n"
            + "UPDATE marks SET mark = 38 WHERE name == 'Clive';\n" + "SELECT * FROM marks WHERE name == 'Clive';\n"
            + "DELETE FROM marks WHERE name == 'Dave';\n" + "SELECT * FROM marks;\n"
            + "DELETE FROM marks WHERE mark < 40;\n" + "SELECT * FROM marks;\n" + "USE imdb;\n" + "DROP TABLE actors;\n"
            + "DROP TABLE movies;\n" + "DROP TABLE roles;\n" + "DROP DATABASE imdb;\n" + "CREATE DATABASE imdb;\n"
            + "USE imdb;\n" + "CREATE TABLE actors (name, nationality, awards);\n"
            + "INSERT INTO actors VALUES ('Hugh Grant', 'British', 3);\n"
            + "INSERT INTO actors VALUES ('Toni Collette', 'Australian', 12);\n"
            + "INSERT INTO actors VALUES ('James Caan', 'American', 8);\n"
            + "INSERT INTO actors VALUES ('Emma Thompson', 'British', 10);\n" + "CREATE TABLE movies (name, genre);\n"
            + "INSERT INTO movies VALUES ('Mickey Blue Eyes', 'Comedy');\n"
            + "INSERT INTO movies VALUES ('About a Boy', 'Comedy');\n"
            + "INSERT INTO movies VALUES ('Sense and Sensibility', 'Period Drama');\n"
            + "SELECT id FROM movies WHERE name == 'Mickey Blue Eyes';\n"
            + "SELECT id FROM movies WHERE name == 'About a Boy';\n"
            + "SELECT id FROM movies WHERE name == 'Sense and Sensibility';\n"
            + "SELECT id FROM actors WHERE name == 'Hugh Grant';\n"
            + "SELECT id FROM actors WHERE name == 'Toni Collette';\n"
            + "SELECT id FROM actors WHERE name == 'James Caan';\n"
            + "SELECT id FROM actors WHERE name == 'Emma Thompson';\n"
            + "CREATE TABLE roles (name, movie_id, actor_id);\n" + "INSERT INTO roles VALUES ('Edward', 3, 1);\n"
            + "INSERT INTO roles VALUES ('Frank', 1, 3);\n" + "INSERT INTO roles VALUES ('Fiona', 2, 2);\n"
            + "INSERT INTO roles VALUES ('Elinor', 3, 4);\n" + "SELECT * FROM actors\n" + // Missing semi-colon
            "SELECT * FROM crew;\n" + // Table does not exist
            "SELECT spouse FROM actors;\n" + // Attribute does not exist
            "SELECT * FROM actors);\n" + //// Rouge bracket at the end of the line
            "SELECT * FROM actors WHERE name == 'Hugh Grant;\n" + // Missing close quote
            "SELECT * FROM actors WHERE name > 10;\n" + // In situations where it is not possible to convert strings to
                                                        // numbers an error should be generated
            "SELECT name age FROM actors;\n" + // Missing comma between attribute names !
            "SELECT * FROM actors awards > 10;\n" + // Missing WHERE keyword
            "SELECT * FROM actors WHERE name LIKE 10;\n" + // Use of LIKE on numerical data
            " SELECT * FROM actors WHERE awards > 10;\n" + // Leading whitespace should not affect success of query
            "SELECT * FROM actors WHERE awards < 5;\n" + "ALTER TABLE actors ADD age;\n" + "SELECT * FROM actors;\n"
            + "UPDATE actors SET age = 45 WHERE name == 'Hugh Grant';\n"
            + "SELECT * FROM actors WHERE name == 'Hugh Grant';\n"
            + "SELECT nationality FROM actors WHERE name == 'Hugh Grant';\n" + "ALTER TABLE actors DROP age;\n"
            + "SELECT * FROM actors WHERE name == 'Hugh Grant';\n"
            + "SELECT * FROM actors WHERE (awards > 5) AND (nationality == 'British');\n"
            + "SELECT * FROM actors WHERE (awards > 5) AND ((nationality == 'British') OR (nationality == 'Australian'));\n"
            + "SELECT * FROM actors WHERE name LIKE 'an';\n" + "SELECT * FROM actors WHERE awards >= 10;\n"
            + "DELETE FROM actors WHERE name == 'Hugh Grant';\n" + "DELETE FROM actors WHERE name == 'James Caan';\n"
            + "DELETE FROM actors WHERE name == 'Emma Thompson';\n" + "JOIN actors AND roles ON id AND actor_id;\n"
            + "JOIN movies AND roles ON id AND movie_id;\n" + "DROP TABLE actors;\n" + "SELECT * FROM actors;\n"
            + "DROP DATABASE imdb;\n" + "USE imdb;\n" + // Unknown database
            "USE ebay;\n"; // Unknown database

    public static void main(String[] args) {
        Input input = new Input();
        String[] commandLine = tests.split("\\n");
        for (int i = 0; i < commandLine.length; i++) {
            input.execute(commandLine[i]);
        }

    }
}
