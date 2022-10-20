

import javax.swing.JFrame;

public class Screen extends JFrame {
    public static int sizeX = 800;
    public static int sizeY = 600;

    public Screen() {
        this.setSize(sizeX, sizeY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initializeMainMenu() {
        Label title = new Label(Main.gameTitle, 20);
        this.add(title);
    }
}
