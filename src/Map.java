import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Map {
    public static int worldXSize = 44 * 6;
    public static int worldYSize = 15 * 6;
    public static int worldXTiles = 42;
    public static int worldYTiles = 30;
    public static int cameraXTiles = 21;
    public static int cameraYTiles = 15;
    private JLabel[] mapComponents = new JLabel[100000];

    public static String[] mapFiles = {
            "Resources/Map/Map001.txt",
            "Resources/Map/Map002.txt",
            "Resources/Map/Map003.txt",
            "Resources/Map/Map004.txt",
    };

    public static int[][] mapComposition = {
            {0, 1},
            {2, 3},
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

        Entity.drawAllEntities();

        for (int rowIndex = 0; rowIndex < this.map.length; rowIndex++) {
            currentX = 0;
            int[] row = this.map[rowIndex];
            System.out.println(rowIndex);
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

    private int readMapRowLength() {
        int rowLength = 0;

        try {
            for (int rowIndex = 0; rowIndex < mapComposition.length; rowIndex++) {
                int[] row = mapComposition[rowIndex];

                String filePath = mapFiles[row[0]];

                File file = new File(filePath);

                rowLength += this.readRowLengthFromTxtFile(file);
            }
        }

        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return rowLength;
    }

    private int readMapColLength() {
        int colLength = 0;

        try {
            int[] row = mapComposition[0];

            for (int cellIndex = 0; cellIndex < row.length; cellIndex++) {
                String filePath = mapFiles[row[cellIndex]];

                File file = new File(filePath);

                colLength += this.readColLengthFromTxtFile(file);
            }
        }

        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return colLength;
    }

    private int readRowLengthFromTxtFile (File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        int lines = 0;

        while (scanner.hasNextLine() && scanner.nextLine() != null) {
            System.out.println("Run");
            lines++;
        }

        return lines;
    }

    private int readColLengthFromTxtFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String[] line = scanner.nextLine().trim().split(", ");

        return line.length;
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
        int rowLength = this.readMapRowLength();
        int colLength = this.readMapColLength();

        int[][] map = new int[rowLength][colLength];

        System.out.println(map.length);
        System.out.println(map[1].length);

        for (int rowIndex = 0; rowIndex < mapComposition.length; rowIndex++) {
            int[] row = mapComposition[rowIndex];

            for (int cellIndex = 0; cellIndex < row.length; cellIndex++) {
                int toAddRow = rowIndex * 15;
                int toAddCol = cellIndex * 21;
                int cell = row[cellIndex];

                File mapFile = this.getMapFile(cell);
                Scanner scanner = new Scanner(mapFile);

                int val = 0;
                int individualRowLength = this.readRowLengthFromTxtFile(new File(mapFiles[0]));

                for (int i = 0; i < individualRowLength;  i++) {
                    String[] line = scanner.nextLine().trim().split("," + " ");

                    for (int j = 0; j < line.length; j++) {
                        val++;
                        map[i + toAddRow][j + toAddCol] = Integer.parseInt(line[j]);
                    }
                }
            }
        }

        System.out.println("MAPLENGTH: " + map.length);
        System.out.println("MAPLENGTH: " + map[0].length);

        return map;
    }

    private File getMapFile(int index)  {
        String filePath = mapFiles[index];
        File file = new File(filePath);

        return file;
    }
}
