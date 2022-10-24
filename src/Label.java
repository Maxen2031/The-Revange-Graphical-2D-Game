

import javax.swing.JLabel;
import java.awt.Font;

public class Label extends JLabel{
    private static String defaultFont = "Sans";

    public Label(String text, int fontWeight, int fontSize) {
        super(text);
        this.setFont(new Font(defaultFont, fontWeight, fontSize));
    }
}
