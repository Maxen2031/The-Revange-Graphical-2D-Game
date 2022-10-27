import javax.swing.*;

public class Character extends Entity{
    private JLabel image;
    private Panel gamePanel;

    public Character(Panel gamePanel) {
        this.setX(10);
        this.setY(7);
        this.image = new JLabel(this.generateImage());
        this.gamePanel = gamePanel;
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

    public void drawCharacter() {
        this.getImage().setBounds(10 * 48, 7 * 48, 52, 52);
        this.gamePanel.add(this.getImage());
    }

    @Override
    public void update() {

    }
}
