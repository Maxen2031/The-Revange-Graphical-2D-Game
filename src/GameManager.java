public class GameManager {
    Entity entities[];
    Map gameMap;

    public GameManager() {
        entities = new Entity[10];
    }

    public void initialize() {
        try {
            while (true) {
                // Update all entities

                for (Entity entity : entities) {
                    entity.update();
                }



                Thread.sleep(1000);
            }
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void initializeEntity(Entity entity) {
        this.entities[this.entities.length] = entity;
    }
}
