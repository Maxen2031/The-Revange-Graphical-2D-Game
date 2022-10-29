import javax.swing.*;
import java.util.HashMap;

public class Tile {
    private static String[] images = {
            "Resources/Tiles/OutdoorTiles/GrassTile.png",
            "Resources/Tiles/OutdoorTiles/WaterTile.png",
            "Resources/Tiles/OutdoorTiles/TreeTile.png",
    };

    private int xSpan;
    private int ySpan;
    private JLabel image;

    public Tile(int xSpan, int ySpan, int id) {
        this.image = new JLabel(new ImageIcon(this.generateImage(id)));
        this.xSpan = xSpan;
        this.ySpan = ySpan;
    }

    private String generateImage(int id) {
        return images[id];
    }

    public JLabel getImage() {
        return this.image;
    }
}
