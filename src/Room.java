
import java.awt.*;

public class Room {
    public int worldWidth = 12;
    public int worldHeight = 8;
    public int blockSize = 64;
    public Block[][] Block;

    public Room(){
        define();
    }

    public void define(){
        Block = new Block[worldHeight][worldWidth];
        for(int y = 0; y< Block.length; y++){
            for(int x = 0; x < Block[0].length; x++){
                Block[y][x] = new Block((GameField.myWidth/2)-((worldWidth*blockSize)/2)+x*blockSize,y*blockSize,blockSize,blockSize,Value.groundGrass,Value.airAir);
            }
        }
    }
    public void physic(){
        for(int i = 0; i< GameField.theTower.size(); i++){
            GameField.theTower.get(i).physic();
        }
    }

    public void draw(Graphics g) {
        for (int y = 0; y < Block.length; y++) {
            for (int x = 0; x < Block[0].length; x++) {
                Block[y][x].draw(g);
            }
        }
        for (int i=0;i<GameField.theTower.size();i++){
            GameField.theTower.get(i).draw(g);
        }
        for (int i=0;i<GameField.theTower.size();i++) {
            GameField.theTower.get(i).fight(g);
        }
    }
}
