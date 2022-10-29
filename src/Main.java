import java.io.IOException;

public class Main {
    public final static int TILESIZE = 48;
    public final static int WORLDCOL = 50;
    public final static int WORLDROW = 50;
    public static String gameTitle = "THE REVENGE";

    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.initializeMainMenu();
    }
}