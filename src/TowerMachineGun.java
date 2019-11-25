import java.awt.*;

public class TowerMachineGun extends Tower {
    public TowerMachineGun(int x, int y, int width, int height, int airID) {
        super(x, y, width, height,airID);
        towerSpeedShot = 40;
        dame = 50;
        towerSquareSize = 50;
        towerSquare = new Rectangle(x-towerSquareSize/2,y-towerSquareSize/2,width+towerSquareSize,height+towerSquareSize);
    }
}
