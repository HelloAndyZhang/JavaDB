package SqlEngine.IO;

import java.io.*;
import java.util.ArrayList;

public class IOCore {
    File currDB;
    public ArrayList<String> output;

    final String extension = ".text";

    public IOCore() {
        currDB = null;
        output = null;
    }

    public void useDB(String dbName) {
        currDB = new File(dbName);
        if (!currDB.exists())
            throw new Error("Database '" + dbName + "' does not exist");
        output = defaultOutput();
    }

    public void createDB(String dbName) {
        File db = new File(dbName);
        if (db.exists())
            throw new Error("Database '" + dbName + "' already exists");
        if (!db.mkdir())
            throw new Error("Couldn't create Database");
        output = defaultOutput();
    }

    public void createTB(String tbName, ArrayList<String> attributes) throws IOException {
        File tbFile = getFileOfTable(tbName, false);
        if (!tbFile.createNewFile())
            throw new Error("Couldn't create table");
        Table tb = new Table(attributes);
        writeTableToFile(tb, tbFile);
        output = defaultOutput();
    }

    public void dropDB(String dbName) {
        File db = new File(dbName);
        if (!db.exists())
            throw new Error("Database doesn't exist");
        File[] tables = db.listFiles();
        if (tables == null)
            throw new Error("CRITICAL: Wrong format of Database");
        for (File table : tables) {
            if (!table.delete())
                throw new Error("CRITICAL: Wrong format of Tables in Database");
        }
        if (!db.delete())
            throw new Error("Deleted Tables in Database but not Database itself");
        output = defaultOutput();
    }

    public void dropTB(String tbName) {
        File table = getFileOfTable(tbName, true);
        if (!table.delete())
            throw new Error("Couldn't delete table");
        output = defaultOutput();
    }

    public void insertInto(String tbName, ArrayList<String> values) throws IOException {
        File tableFile = getFileOfTable(tbName, true);
        Table table = readTableFromFile(tableFile);
        table.insert(values);
        writeTableToFile(table, tableFile);
        output = defaultOutput();
    }

    public void select(String tbName, ArrayList<String> attributes, Row cond) throws IOException {
        File tableFile = getFileOfTable(tbName, true);
        Table table = readTableFromFile(tableFile);
        if (attributes == null) {
            attributes = table.attributes;
        } else {
            for (String attribute : attributes) {
                if (!table.attributes.contains(attribute))
                    throw new Error(attribute + " is not an attribute in the table.");
            }
        }

        ArrayList<String> output = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (String attribute : attributes) {
            line.append(attribute).append("\t");
        }
        output.add(line.toString());

        for (Row row : table.rows.values()) {
            // || cond.compare(row)
            if (cond == null) {
                line.setLength(0);
                for (String attribute : attributes) {
                    line.append(row.map.get(attribute)).append("\t");
                }
                output.add(line.toString());
            }
        }
        this.output = output;
    }

    public ArrayList<String> getOutput() {
        return output;
    }

    private Table readTableFromFile(File tableFile) throws IOException {
        FileInputStream readFromFile = new FileInputStream(tableFile);
        ObjectInputStream readObjIn = new ObjectInputStream(readFromFile);
        try {
            Table tb = (Table) readObjIn.readObject();
            readObjIn.close();
            readFromFile.close();
            return tb;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new Error("CRITICAL: Couldn't deserialize Table file.");
        }
    }

    private void writeTableToFile(Table table, File file) throws IOException {
        FileOutputStream writeToFile = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(writeToFile);
        writer.writeObject(table);
        writeToFile.close();
        writer.close();
    }

    private File getFileOfTable(String tableName, boolean checkExists) {
        if (currDB == null)
            throw new Error("No Database Selected");
        File tableFile = new File(currDB.getName() + File.separator + tableName + extension);
        if (checkExists && !tableFile.exists()) {
            throw new Error("Table '" + tableName + "' does not exist");
        }
        return tableFile;
    }

    private ArrayList<String> defaultOutput() {
        ArrayList<String> out = new ArrayList<>();
        out.add("OK");
        return out;
    }
}
