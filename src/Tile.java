import javax.swing.*;

public class Tile {
    private static String[] images = {
            "Resources/Tiles/OutdoorTiles/GrassTile.png",
            "Resources/Tiles/OutdoorTiles/WaterTile.gif",
            "Resources/Tiles/OutdoorTiles/TreeTile.png",
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
