import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Tile {
    public static int COLLISSION_MARGIN = 10;
    public static int tileSpan = 6;
    public static int tileSize = 48;

    private static String[] images = {
            "Resources/Chunks/OutdoorChunks/GrassTile.png",
            "Resources/Chunks/OutdoorChunks/TreeTile.png",
            "Resources/Tiles/OutdoorTiles/WaterTile.png",
    };

    private static boolean[] collidables = {
            false,
            true,
            true,
    };

    private JLabel image;
    private boolean canCollide;

    public Tile(int id) {
        String path = this.generateImage(id);
        this.image = this.createImageForTile(path);
        this.canCollide = getCollidable(path);
    }

    private JLabel createImageForTile(String path) {
        JLabel jlabel = new JLabel(new ImageIcon(path));

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        jlabel.setBorder(border);

        return jlabel;
    }

    private String generateImage(int id) {
        return images[id];
    }

    public JLabel getImage() {
        return this.image;
    }

    private static boolean getCollidable(String path) {
        int index = getIndexFromPath(path);

        return collidables[index];
    }

    public boolean getCanCollide() {
        return this.canCollide;
    }

    public void setCanCollide(boolean canCollide) {
        this.canCollide = canCollide;
    }

    private static int getIndexFromPath(String path) {
        for (int i = 0; i < images.length; i++) {
            String comparePath = images[i];

            if (comparePath.equals(path)) return i;
        }

        return 0;
    }
}
