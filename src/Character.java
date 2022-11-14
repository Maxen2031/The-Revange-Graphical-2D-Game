import javax.swing.*;
import java.util.HashMap;

public class Character extends Entity{
    private static String[] upImages = {"Resources/Entities/Character/CharacterUp3.png", "Resources/Entities/Character/CharacterUp2.png", "Resources/Entities/Character/CharacterUp1.png"};
    private static String[] downImages = {"Resources/Entities/Character/CharacterDown3.png", "Resources/Entities/Character/CharacterDown2.png", "Resources/Entities/Character/CharacterDown1.png"};
    private static String[] leftImages = {"Resources/Entities/Character/CharacterLeft3.png", "Resources/Entities/Character/CharacterLeft2.png", "Resources/Entities/Character/CharacterLeft1.png"};
    private static String[] rightImages = {"Resources/Entities/Character/CharacterRight3.png", "Resources/Entities/Character/CharacterRight2.png", "Resources/Entities/Character/CharacterRight1.png"};

    private JLabel image;
    private Panel gamePanel;
    private Tile[] mapComponents;
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
        this.setImage(upImages[0]);
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
    }

    public Character(int x, int y, Panel gamePanel) {
        super(x, y);
        this.image = new JLabel();
        this.setImage(upImages[0]);
        this.gamePanel = gamePanel;
    }

    public void injectMapComponents(Tile[] mapComponents) {
        this.mapComponents = mapComponents;
    }

    public void setImage(String icon) {
        this.getImage().setIcon(new ImageIcon(icon));
    }

    public JLabel getImage() {
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
            if (this.isCollidingYUp() == true) return;

            this.setY(this.getY() + this.speed);
            this.setImage(upImages[this.imageIndex]);
        }

        else if (keyboard.downPressed == true) {
            if (this.isCollidingYDown() == true) return;

            this.setY(this.getY() - this.speed);
            this.setImage(downImages[this.imageIndex]);
        }

        else if (keyboard.rightPressed == true) {
            if (this.isCollidingXRight() == true) return;

            this.setX(this.getX() + this.speed);
            this.setImage(rightImages[this.imageIndex]);
        }

        else if (keyboard.leftPressed == true) {
            if (this.isCollidingXLeft() == true) return;

            this.setX(this.getX() - this.speed);
            this.setImage(leftImages[this.imageIndex]);
        }
    }

    private boolean isCollidingXRight() {
        HashMap<String, Boolean> collsion = this.getCharacterCollisions();

        return collsion.get("XRight");
    }

    private boolean isCollidingXLeft() {
        HashMap<String, Boolean> collsion = this.getCharacterCollisions();

        return collsion.get("XLeft");
    }

    private boolean isCollidingYUp() {
        HashMap<String, Boolean> collsion = this.getCharacterCollisions();

        return collsion.get("YUp");
    }

    private boolean isCollidingYDown() {
        HashMap<String, Boolean> collsion = this.getCharacterCollisions();

        return collsion.get("YDown");
    }

    private HashMap<String, Boolean> getCharacterCollisions() {
        System.out.println("NEW COLLIDE");
        HashMap<String, Boolean> map = new HashMap<>();

        map.put("XLeft", false);
        map.put("XRight", false);
        map.put("YUp", false);
        map.put("YDown", false);

        for (Tile tile : mapComponents) {
            if (tile == null) continue;
            if (tile.getCanCollide() == false) continue;

            int xCharacterLeft = this.getImage().getBounds().x - Main.TILESIZE/2;
            int xCharacterRight = this.getImage().getBounds().x + Main.TILESIZE/2;
            int yCharacterUp = this.getImage().getBounds().y - Main.TILESIZE/2;
            int yCharacterDown = this.getImage().getBounds().y + Main.TILESIZE/2;

            int xTileLeft = tile.getImage().getBounds().x - Main.TILESIZE/2;
            int xTileRight = tile.getImage().getBounds().x + Main.TILESIZE/2;
            int yTileUp = tile.getImage().getBounds().y - Main.TILESIZE/2;
            int yTileDown = tile.getImage().getBounds().y + (Main.TILESIZE/2);

            boolean charRight = xTileLeft - xCharacterRight >= 0 && xTileLeft - xCharacterRight <= Tile.COLLISSION_MARGIN;
            boolean charLeft = xCharacterLeft - xTileRight >= 0 && xCharacterLeft - xTileRight <= Tile.COLLISSION_MARGIN;

            boolean charUp = yCharacterUp - yTileDown >= 0 && yCharacterUp - yTileDown <= Tile.COLLISSION_MARGIN;
            System.out.println(yCharacterUp - yTileDown);
            boolean charDown = yCharacterDown - yTileUp >= 0 && yCharacterDown - yTileUp <= Tile.COLLISSION_MARGIN;

            boolean yWithinBounds = tile.getImage().getY() >= (yCharacterDown - 20) && tile.getImage().getY() <= (yCharacterUp + 20);
            boolean xWithinBounds = tile.getImage().getX() >= (xCharacterLeft - 20) && tile.getImage().getX() <= (xCharacterRight + 20);
            System.out.println(xCharacterLeft - xTileRight);

            if (charRight && yWithinBounds) {
                map.put("XRight", true);
                break;
            }

            if (charLeft && yWithinBounds) {
                map.put("XLeft", true);
                break;
            }

            if (charUp && xWithinBounds) {
                System.out.println("HERE: " + (yCharacterUp - yTileDown));
                map.put("YUp", true);
                break;
            }

            if (charDown && xWithinBounds) {
                map.put("YDown", true);
                break;
            }
        }

        return map;
    }
}
