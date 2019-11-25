import java.awt.*;

public class TowerNormal extends Tower {
    public TowerNormal(int x, int y, int width, int height, int airID) {
        super(x, y, width, height, airID);
        towerSpeedShot = 100;
        dame = 100;
        towerSquareSize = 100;
        towerSquare = new Rectangle(x - towerSquareSize / 2, y - towerSquareSize / 2, width + towerSquareSize, height + towerSquareSize);
    }
}
