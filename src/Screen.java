

import javax.swing.*;
import java.awt.*;

import java.awt.Dimension;

public class Screen extends JFrame implements Runnable {
    public static int sizeX = Map.cameraXTiles * Tile.tileSize;
    public static int sizeY = Map.cameraYTiles * Tile.tileSize;

    private Panel mainMenuPanel;
    private Map map;
    private JComponent[] mainMenuComponent;
    private Character character;
    private GameManager gameManager;
    private Thread gameThread;
    private KeyboardInput keyboard;
    private Entity[] entities;

    public Screen() {
        this.setSize(sizeX, sizeY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //this.setResizable(false);
        this.setVisible(true);
        this.keyboard = new KeyboardInput();
        this.addKeyListener(keyboard);
        this.entities = Entity.getEntities();

    }

    public void initializeMainMenu() {
        this.mainMenuComponent = new JComponent[4];

        this.mainMenuPanel = new Panel();
        this.mainMenuPanel.setBackground(Color.black);
        this.mainMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        this.add(this.mainMenuPanel, BorderLayout.CENTER);
        this.mainMenuComponent[0] = this.mainMenuPanel;

        Panel topPanel = new Panel();
        topPanel.setBackground(Color.black);
        topPanel.setPreferredSize(new Dimension(0, 100));
        topPanel.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.mainMenuComponent[1] = topPanel;

        Panel sidePanelWest = new Panel();
        sidePanelWest.setBackground(Color.black);
        sidePanelWest.setPreferredSize(new Dimension(250, 100));
        sidePanelWest.setLayout(new BorderLayout());
        this.add(sidePanelWest, BorderLayout.WEST);
        this.mainMenuComponent[2] = sidePanelWest;

        Panel sidePanelEast = new Panel();
        sidePanelEast.setBackground(Color.black);
        sidePanelEast.setPreferredSize(new Dimension(250, 100));
        sidePanelEast.setLayout(new BorderLayout());
        this.add(sidePanelEast, BorderLayout.EAST);
        this.mainMenuComponent[3] = sidePanelEast;

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
        Panel gamePanel = new Panel();
        gamePanel.setLayout(null);
        gamePanel.setBackground(new Color(0x4F9966));
        gamePanel.setVisible(true);

        this.character = new Character(gamePanel, keyboard);
        character.draw();

        this.map = new Map(gamePanel, character, this);
        this.map.createMap();

        this.add(gamePanel);
    }

    public void setComponentVisibility(JComponent[] component, boolean visibility) {
        for (JComponent item : component) {
            item.setVisible(visibility);
        }
    }

    public void startGame() {
        this.setComponentVisibility(this.mainMenuComponent, false);
        this.initializeGame();

        this.startGameThread();
    }

    public Button initializeButton(String text, String type) {
        Button button = new Button(type, this);
        button.setText(text);
        button.setPreferredSize(new Dimension(200, 70));
        button.setFont(new Font("Sans", Font.BOLD, 30));
        this.mainMenuPanel.add(button);

        return button;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        this.gameManager = new GameManager(this.map, this.entities);
        gameManager.initialize();
    }
}
