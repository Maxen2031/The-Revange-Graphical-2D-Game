import javax.swing.*;

public class Character extends Entity{
    private int x;
    private int y;
    private JLabel image;
    private Panel gamePanel;

    public Character(Panel gamePanel) {
        this.x = 11;
        this.y = 8;

        this.image = new JLabel(this.generateImage());
        this.gamePanel = gamePanel;
    }

    private ImageIcon generateImage() {
        return new ImageIcon("Resources/Entities/Character/CharacterDown1.png");
    }

    private JLabel getImage() {
        return this.image;
    }

    public void drawCharacter() {
        this.getImage().setBounds(10 * 48, 7 * 48, 52, 52);
        this.gamePanel.add(this.getImage());
    }

    @Override
    public void update() {

    }
}
