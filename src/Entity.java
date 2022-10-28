

import javax.swing.JPanel;

public class Entity extends JPanel{
    private static Entity[] entities = new Entity[100];
    private int health;
    private Dimension2 position;

    public Entity() {
        position = new Dimension2(0, 0);

        entities[this.getAmountOfEntities()] = this;
    }

    public Entity(int x, int y) {
        position = new Dimension2(x, y);
    }

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public void update() {

    }

    public void draw() {

    }

    public int getAmountOfEntities() {
        int amount = 0;

        for (Entity entity : this.entities) {
            if (entity == null) continue;

            amount++;
        }

        return amount;
    }

    public static Entity[] getEntities() {
        return entities;
    }
}
