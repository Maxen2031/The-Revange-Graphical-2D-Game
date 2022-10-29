import javax.swing.*;

public class Tile {
    public static int tileSpan = 6;
    public static int tileSize = 48;

    private static String[] images = {
            "Resources/Chunks/OutdoorChunks/GrassTile.png",
            "Resources/Chunks/OutdoorChunks/TreeTile.png",
            "Resources/Tiles/OutdoorTiles/WaterTile.png",
    };

    private JLabel image;

    public Tile(int id) {
        this.image = new JLabel(new ImageIcon(this.generateImage(id)));
    }

    private String generateImage(int id) {
        return images[id];
    }

    public JLabel getImage() {
        return this.image;
    }
}
