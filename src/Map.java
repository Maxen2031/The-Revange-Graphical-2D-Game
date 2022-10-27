import javax.swing.*;
import java.awt.image.BufferedImage;

public class Map {
    private BufferedImage grassTile;
    private BufferedImage rockTile;
    private BufferedImage waterTile;
    private int[][] map;
    private JLabel[] mapObjects;

    private Panel mapPanel;
    private Character character;

    public Map(Panel mapPanel, Character character) {
        this.setMap();
        this.mapPanel = mapPanel;
        this.character = character;
    }

    public void renderMap() {
        int xCoordinate = 0;
        int yCoordinate = 0;
        int counter = 0;
        System.out.println("Position");
        System.out.println(character.getX());
        System.out.println(character.getY());

        int minX = (character.getX() - 10);
        int maxX = (character.getX() + 10);
        int minY = (character.getY() - 7);
        int maxY = (character.getY() + 6);

        mapObjects = new JLabel[400];

        for (int rowIndex = minY; rowIndex <= maxY; rowIndex++) {
            int[] row = map[rowIndex];
            xCoordinate = 0;

            for (int tileIndex = minX; tileIndex <= maxX; tileIndex++) {
                int tileId = row[tileIndex];
                Tile tile = new Tile(tileId);
                tile.getImage().setBounds(xCoordinate, yCoordinate, 48, 48);
                mapPanel.add(tile.getImage());
                mapObjects[counter] = tile.getImage();
                xCoordinate += 48;
                counter++;
            }

            yCoordinate += 48;
        }
    }

    public void disolveMap() {
        for (JLabel img : mapObjects) {
            if (img == null) continue;

            mapPanel.remove(img);
        }
    }

    public void setMap() {
        this.map = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
        };
    }
}
