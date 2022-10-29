public class GameManager {
    private Entity entities[];
    private Map gameMap;

    public GameManager(Map map, Entity[] entities) {
        this.entities = entities;
        this.gameMap = map;
    }

    public void initialize() {
        while (true) {
            // Update all entities
            System.out.println("run");

            for (Entity entity : entities) {
                if (entity == null) continue;
                entity.update();
            }

            gameMap.renderMap();

            try {
                Thread.sleep(1000/60);
            }
            catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void initializeEntity(Entity entity) {
        this.entities[this.entities.length] = entity;
    }
}
