import java.util.ArrayList;

public class Utility {
    public static String contactinate(Object[] array) {
        String str = "";

        for (Object element : array) {
            str = str + " " + element;
        }

        return str;
    }
}
