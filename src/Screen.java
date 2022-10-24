

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import java.awt.Dimension;

public class Screen extends JFrame {
    public static int sizeX = 800;
    public static int sizeY = 600;
    public static int titleSize = 1200;

    private Panel mainMenuPanel;
    private Panel topPanel;

    public Screen() {
        this.setSize(sizeX, sizeY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new Color(0, 0, 0));
        //this.setResizable(false);
        this.setVisible(true);
    }

    public void initializeMainMenu() {
        this.mainMenuPanel = new Panel();
        this.mainMenuPanel.setBackground(Color.black);
        this.mainMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        this.add(this.mainMenuPanel, BorderLayout.CENTER);

        Panel topPanel = new Panel();
        topPanel.setBackground(Color.black);
        topPanel.setPreferredSize(new Dimension(0, 100));
        topPanel.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);

        Panel sidePanelWest = new Panel();
        sidePanelWest.setBackground(Color.black);
        sidePanelWest.setPreferredSize(new Dimension(200, 100));
        sidePanelWest.setLayout(new BorderLayout());
        this.add(sidePanelWest, BorderLayout.WEST);

        Panel sidePanelEast = new Panel();
        sidePanelEast.setBackground(Color.black);
        sidePanelEast.setPreferredSize(new Dimension(200, 100));
        sidePanelEast.setLayout(new BorderLayout());
        this.add(sidePanelEast, BorderLayout.EAST);

        Label title = new Label(Main.gameTitle, new Font("Sans", Font.BOLD, 30));
        title.setText(Main.gameTitle);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(new Color(255, 255, 255));
        topPanel.add(title);

        this.initializeButton("Play", "playButton");
        this.initializeButton("Settings", "playButton");
        this.initializeButton("Help", "playButton");
    }

    public void initializeGame() {
        this.mainMenuPanel.setVisible(false);
    }

    public Button initializeButton(String text, String type) {
        Button button = new Button(type, this);
        button.setText(text);
        button.setPreferredSize(new Dimension(200, 70));
        button.setFont(new Font("Sans", Font.BOLD, 30));
        this.mainMenuPanel.add(button);

        return button;
    }
}
