import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Map {
    public static int worldXSize = 44 * 6;
    public static int worldYSize = 11 * 6;
    public static int worldXTiles = 102;
    public static int worldYTiles = 66;
    public static int cameraXTiles = 17;
    public static int cameraYTiles = 13;
    private JLabel[] mapComponents = new JLabel[100000];

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

    public void createMap() {
        int currentX = 0;
        int currentY = 0;
        int counter = 0;

        for (int rowIndex = 0; rowIndex < this.map.length; rowIndex++) {
            currentX = 0;
            System.out.println(currentY);
            int[] row = this.map[rowIndex];

            for (int cellIndex = 0; cellIndex < row.length; cellIndex++) {
                int cell = row[cellIndex];
                //System.out.println(cell);
                Tile chunk = new Tile(cell);
                chunk.getImage().setBounds(currentX, currentY, Tile.tileSize, Tile.tileSize);
                this.mapPanel.add(chunk.getImage());
                mapComponents[counter] = chunk.getImage();
                currentX += Tile.tileSize;
                counter++;
            }

            currentY += Tile.tileSize;
        }

        Entity.drawAllEntities();
    }

    public HashMap getBoundaries() {
        HashMap<String, Integer> boundaries = new HashMap<String, Integer>();

        int tileXMin = this.character.getX() - Map.worldXTiles / 2;
        int tileXMax = this.character.getX() + Map.worldXTiles / 2;
        int tileYMin = this.character.getY() - Map.worldYTiles / 2;
        int tileYMax = this.character.getY() + Map.worldYTiles / 2;

        boundaries.put("tileXMin", tileXMin);
        boundaries.put("tileXMax", tileXMax);
        boundaries.put("tileYMin", tileYMin);
        boundaries.put("tileYMax", tileYMax);

        return boundaries;
    }

    public void renderMap() {
        HashMap boundaries = this.getBoundaries();
        /*
        System.out.println(boundaries.get("tileXMin"));
        System.out.println(boundaries.get("tileXMax"));
        System.out.println(boundaries.get("tileYMin"));
        System.out.println(boundaries.get("tileYMax"));*/

        int xChange = this.character.getXMovement();
        int yChange = this.character.getYMovement();

        System.out.println(xChange);
        System.out.println(yChange);

        for (JLabel mapComponent : mapComponents) {
            if (mapComponent == null) continue;

            mapComponent.setBounds(mapComponent.getBounds().x - xChange, mapComponent.getBounds().y + yChange, 48, 48);
        }

       // this.mapPanel.revalidate();
        //this.mapPanel.repaint();
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
            this.map = this.readFile();
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private int[][] readFile() throws FileNotFoundException {
        int[][] map = new int[worldYSize][worldXSize];

        Scanner scanner = new Scanner(getMapFile(0));

        for (int i = 0; i < 11;  i++) {
            String[] line = scanner.nextLine().trim().split("," + " ");

            for (int j = 0; j < line.length; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(Arrays.toString(map));

        return map;
    }

    private File getMapFile(int index)  {
        String filePath = mapFiles[index];
        File file = new File(filePath);

        return file;
    }
}
