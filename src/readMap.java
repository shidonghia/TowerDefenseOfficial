
import java.io.*;
import java.util.*;

public class readMap {
    public void loadSave(File loadPath){
        try {
            Scanner loadScanner = new Scanner(loadPath);

            while (loadScanner.hasNext()){
                // GameField.killToWin = loadScanner.nextInt();

                for(int y = 0; y<GameField.room.Block.length; y++){
                    for(int x = 0; x<GameField.room.Block[0].length; x++){
                        GameField.room.Block[y][x].groundID = loadScanner.nextInt();
                    }
                }

                for(int y = 0; y<GameField.room.Block.length; y++){
                    for(int x = 0; x<GameField.room.Block[0].length; x++){
                        GameField.room.Block[y][x].airID = loadScanner.nextInt();
                    }
                }
            }
            loadScanner.close();
        } catch (Exception e) { }
    }
}
