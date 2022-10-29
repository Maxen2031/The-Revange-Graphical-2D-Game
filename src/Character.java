import javax.swing.*;

public class Character extends Entity{
    private JLabel image;
    private Panel gamePanel;
    private KeyboardInput keyboard;

    public Character(Panel gamePanel, KeyboardInput keyboard) {
        this.setX(10 * Tile.tileSize);
        this.setY(7 * Tile.tileSize);
        this.image = new JLabel(this.generateImage());
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
    }

    public Character(int x, int y, Panel gamePanel) {
        super(x, y);
        this.image = new JLabel(this.generateImage());
        this.gamePanel = gamePanel;
    }

    private ImageIcon generateImage() {
        return new ImageIcon("Resources/Entities/Character/CharacterDown1.png");
    }

    private JLabel getImage() {
        return this.image;
    }

    @Override
    public void draw() {
        this.getImage().setBounds( 14 * Main.TILESIZE, 7 * Main.TILESIZE, 52, 52);
        this.gamePanel.add(this.getImage());
    }

    @Override
    public void update() {
        System.out.println("update");
        if (keyboard.upPressed == true) {
            this.setY(this.getY() + 1);
        }

        else if (keyboard.downPressed == true) {
            this.setY(this.getY() - 1);
        }

        else if (keyboard.rightPressed == true) {
            this.setX(this.getX() + 1);
        }

        else if (keyboard.leftPressed == true) {
            this.setX(this.getX() - 1);
        }
    }
}
