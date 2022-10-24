

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class Screen extends JFrame {
    public static int sizeX = 800;
    public static int sizeY = 600;

    public Screen() {
        this.setSize(sizeX, sizeY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void initializeMainMenu() {
        Panel mainMenuPanel = new Panel();
        mainMenuPanel.setBounds(0, 0, sizeX, sizeY);
        mainMenuPanel.setLayout(new BorderLayout());
        mainMenuPanel.setVisible(true);

        Label title = new Label(Main.gameTitle, 20);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        mainMenuPanel.add(title);

        Button playButton = new Button("playButton", new Dimension(100, 50));
        playButton.setPreferredSize(new Dimension(100, 50));
        //playButton.setHorizontalAlignment(JLabel.CENTER);
        //playButton.setVerticalAlignment(JLabel.TOP);
        mainMenuPanel.add(playButton);

        this.add(mainMenuPanel);
    }
}
