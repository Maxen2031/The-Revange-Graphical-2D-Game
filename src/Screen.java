

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    public static int sizeX = 800;
    public static int sizeY = 600;
    public static int titleSize = 1200;

    public Screen() {
        this.setSize(sizeX, sizeY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void initializeMainMenu() {
        Label title = new Label(Main.gameTitle, 40);
        this.add(title);
        title.setBounds(250, -500, titleSize, titleSize);
    }
}
