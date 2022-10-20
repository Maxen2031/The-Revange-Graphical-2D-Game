

import javax.swing.JPanel;

public class Entity extends JPanel{
    private int health;
    private Dimension2 position;

    public Entity() {
        position = new Dimension2(0, 0);
    }

    public Entity(int x, int y) {
        position = new Dimension2(x, y);
    }

    public void updateEntity() {

    }
}
