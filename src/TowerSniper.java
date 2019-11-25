import java.awt.*;

/**
 * Created by DAO NGAN on 11/24/2019.
 */
public class TowerSniper extends Tower {
    public TowerSniper(int x, int y, int width, int height, int airID) {
        super(x, y, width, height, airID);
        towerSpeedShot = 500;
        towerSquareSize = 200;
        dame = 200;
        towerSquare = new Rectangle(x-towerSquareSize/2,y-towerSquareSize/2,towerSquareSize,towerSquareSize);
        System.out.println("Sniper");
    }
}

