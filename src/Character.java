import javax.swing.*;

public class Character extends Entity{
    private static String[] upImages = {"Resources/Entities/Character/CharacterUp3.png", "Resources/Entities/Character/CharacterUp2.png", "Resources/Entities/Character/CharacterUp1.png"};
    private static String[] downImages = {"Resources/Entities/Character/CharacterDown3.png", "Resources/Entities/Character/CharacterDown2.png", "Resources/Entities/Character/CharacterDown1.png"};
    private static String[] leftImages = {"Resources/Entities/Character/CharacterLeft3.png", "Resources/Entities/Character/CharacterLeft2.png", "Resources/Entities/Character/CharacterLeft1.png"};
    private static String[] rightImages = {"Resources/Entities/Character/CharacterRight3.png", "Resources/Entities/Character/CharacterRight2.png", "Resources/Entities/Character/CharacterRight1.png"};

    private JLabel image;
    private Panel gamePanel;
    private KeyboardInput keyboard;
    private int lastX;
    private int lastY;
    private int speed;
    private int walkCounter = 0;
    private int imageIndex = 0;

    public Character(Panel gamePanel, KeyboardInput keyboard) {
        this.setX(10 * Tile.tileSize);
        this.setY(7 * Tile.tileSize);

        this.lastX = this.getX();
        this.lastY = this.getY();
        this.speed = 10;

        this.image = new JLabel(upImages[0]);
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
    }

    public Character(int x, int y, Panel gamePanel) {
        super(x, y);
        this.image = new JLabel(upImages[0]);
        this.gamePanel = gamePanel;
    }

    public void setImage(String icon) {
        this.getImage().setIcon(new ImageIcon(icon));
    }

    private JLabel getImage() {
        return this.image;
    }

    public int getXMovement() {
        return this.getX() - this.lastX;
    }

    public int getYMovement() {
        return this.getY() - this.lastY;
    }

    @Override
    public void draw() {
        this.getImage().setBounds( 11 * Main.TILESIZE, 8 * Main.TILESIZE, 52, 52);
        this.gamePanel.add(this.getImage());
    }

    @Override
    public void update() {
        this.lastX = this.getX();
        this.lastY = this.getY();
        this.walkCounter++;

        if (walkCounter == 10) {
            this.imageIndex++;
            walkCounter = 0;

            if (this.imageIndex >= 2) this.imageIndex = 0;
        }

        if (keyboard.upPressed == true) {
            this.setY(this.getY() + this.speed);
            this.setImage(upImages[this.imageIndex]);
        }

        else if (keyboard.downPressed == true) {
            this.setY(this.getY() - this.speed);
            this.setImage(downImages[this.imageIndex]);
        }

        else if (keyboard.rightPressed == true) {
            this.setX(this.getX() + this.speed);
            this.setImage(rightImages[this.imageIndex]);
        }

        else if (keyboard.leftPressed == true) {
            this.setX(this.getX() - this.speed);
            this.setImage(leftImages[this.imageIndex]);
        }
    }
}
