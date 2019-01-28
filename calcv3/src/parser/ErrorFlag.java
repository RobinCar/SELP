package parser;

public class ErrorFlag {

    private static boolean flag = false;

    public static void setFlag() {
        ErrorFlag.flag = true;
    }

    public static void reset() {
        ErrorFlag.flag = false;
    }

}
