import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Map {
    public static int worldXTiles = 102;
    public static int worldYTiles = 66;
    public static String[] mapFiles = {
            "Resources/Map/Map001.txt"
    };


    private int[][] map;
    private Screen screen;
    private Panel mapPanel;
    private Character character;
    private Entity[] entities;

    public Map(Panel mapPanel, Character character, Screen screen) {
        this.setMap();
        this.mapPanel = mapPanel;
        this.character = character;
        this.screen = screen;
        this.entities = Entity.getEntities();
    }

    public void renderMap() {
        this.disolveMap();

        int tileXMin = this.character.getX() - Map.worldXTiles / 2;
        int tileXMax = this.character.getX() + Map.worldXTiles / 2;
        int tileYMin = this.character.getY() - Map.worldYTiles / 2;
        int tileYMax = this.character.getY() + Map.worldYTiles / 2;
        System.out.println(tileXMin);
        System.out.println(tileXMax);
        System.out.println(tileYMin);
        System.out.println(tileYMax);

        this.mapPanel.revalidate();
        this.mapPanel.repaint();
    }

    public void disolveMap() {
        this.mapPanel.removeAll();

        for (Entity entity : entities) {
            if (entity == null) continue;

            entity.draw();
        }
    }

    public void setMap() {
        try {
            this.readFile();
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void readFile() throws FileNotFoundException {
        int[][] map = new int[worldYTiles][worldXTiles];

        Scanner scanner = new Scanner(getMapFile(0));

        for (int i = 0; i < map.length;  i++) {
            String[] line = scanner.nextLine().trim().split("," + " ");
            for (int j = 0; j < line.length; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(Arrays.deepToString(map));
    }

    private File getMapFile(int index)  {
        String filePath = mapFiles[index];
        File file = new File(filePath);

        return file;
    }
}
