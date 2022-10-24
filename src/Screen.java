

import javax.swing.*;
import java.awt.*;

import java.awt.Dimension;

public class Screen extends JFrame {
    public static int sizeX = 800;
    public static int sizeY = 600;
    public static int titleSize = 1200;

    public Screen() {
        this.setSize(sizeX, sizeY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.setVisible(true);
    }

    public void initializeMainMenu() {
        Label title = new Label(Main.gameTitle, Font.BOLD, 20);
        title.setForeground(new Color(255, 255, 255));
        title.setBounds(330, 0, 300, 100);

        Button playButton = this.createMainMenuButton("playButton", "Play", 290, 130);
        Button settingsButton = this.createMainMenuButton("settingsButton", "Settings", 290, 220);
        Button howToPlayButton = this.createMainMenuButton("howToPlayButton", "How To Play", 290, 310);

        this.add(title);
        this.add(playButton);
        this.add(settingsButton);
        this.add(howToPlayButton);
    }

    private Button createMainMenuButton(String buttonType, String text, int x, int y) {
        Button button = new Button(buttonType);
        button.setText(text);
        button.setFont(new Font("Sans", Font.BOLD, 30));
        button.setBounds(x, y, 200, 50);

        return button;
    }

    private Label createLabel() {
        Label label = new Label(Main.gameTitle, Font.BOLD, 20);
        label.setForeground(new Color(255, 255, 255));
        label.setVisible(true);

        return label;
    }
}
