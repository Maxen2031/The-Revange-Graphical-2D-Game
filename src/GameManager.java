public class GameManager {
    Entity entities[];
    Map gameMap;

    public GameManager(Map map) {
        entities = new Entity[10];
        this.gameMap = map;
    }

    public void initialize() {
        while (true) {
            // Update all entities
            System.out.println("run");
            /*
            for (Entity entity : entities) {
                if (entity == null) continue;
                entity.update();
            }*/

            gameMap.renderMap();

            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex) {
                ex.printStackTrace();
            }

            gameMap.disolveMap();
        }
    }

    public void initializeEntity(Entity entity) {
        this.entities[this.entities.length] = entity;
    }
}
