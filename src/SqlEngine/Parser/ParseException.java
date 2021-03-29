package SqlEngine.Parser;

//OK
public class ParseException extends Exception {

    String msg;

    public ParseException(String msg) {
        this.msg = msg;
    }

    public String ToString() {
        return "ERROR: " + msg;
    }
}
