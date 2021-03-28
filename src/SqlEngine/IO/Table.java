package SqlEngine.IO;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

//OK
public class Table implements Serializable {

    ArrayList<String> attributes;
    HashMap<Integer, Row> rows;
    Integer index;

    public Table(ArrayList<String> attributes) {
        this.attributes = new ArrayList<>();
        this.attributes.add("id");
        this.attributes.addAll(attributes);
        rows = new HashMap<>();
        index = 1;
    }

}
