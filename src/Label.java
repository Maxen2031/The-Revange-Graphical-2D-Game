

import javax.swing.JLabel;
import java.awt.Font;

public class Label extends JLabel{
    private static String defaultFont = "Sans";

    public Label() {

    }

    public Label(String text, Font font) {
        super(text);
        this.setFont(font);
    }
}
