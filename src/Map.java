import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Map {
    public static int worldXTiles = 101;
    public static int worldYTiles = 101;
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
        int totalRow = 11;
        int totalColumn = 21;
        char[][] charArray = new char[totalRow][totalColumn];
        File file = new File("Resources/Map/Map001.txt");

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }


        for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < totalColumn && i < chars.length; i++) {
                charArray[row][i] = chars[i];
            }
        }

        this.map = parseToIntArray(charArray);
    }

    public int[][] parseToIntArray(char[][] charArray) {
        int[][] intArray = new int[charArray.length][charArray[0].length];

        for (int rowIndex = 0; rowIndex < charArray.length; rowIndex++) {
            int[] intRow = new int[charArray[0].length];

        }

        System.out.println(Arrays.deepToString(intArray));

        return intArray;
    }
}
