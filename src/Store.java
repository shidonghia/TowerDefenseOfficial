
import java.awt.*;

public class Store {
    public static int shopWidth = 5;
    public static int buttonSize = 52;
    public static int cellSpace = 2;
    public static int awayFromRoom = 29;
    public static int iconSize = 20;
    public static int iconSpace = 6;
    public static int iconTextY = 15;
    public static int itemIn = 4;
    public static int heldID = -1;


    public static int[] buttonID = {Value.NormalTower,Value.DameTower,Value.SpeedShotTower,Value.sellTower,Value.airTrashCan};
    public static int realID = -1;


    public static int[] buttonPrice = {10,20,30,0,0};

    public Rectangle buttonHealth;
    public Rectangle buttonCoins;
    public Rectangle[] button = new Rectangle[shopWidth];

    public boolean holdItem = false;


    public Store(){
        define();
    }

    public void click(int mouseButton){
        if(mouseButton==1){
            for(int i=0;i<button.length;i++){
                if(button[i].contains(GameField.mse)){
                    if(buttonID[i]!=Value.airAir) {
                        if (buttonID[i] == Value.airTrashCan) { //Delete Item.
                            holdItem = false;
                        } else {
                            heldID = buttonID[i];
                            realID = i;
                            holdItem = true;
                        }
                    }
                }
            }
            if(holdItem){
                if(GameField.coinage>=buttonPrice[realID]){
                    for(int y = 0; y<GameField.room.Block.length; y++){
                        for(int x = 0; x<GameField.room.Block[y].length; x++){
                            if(GameField.room.Block[y][x].contains(GameField.mse)){
                                if(heldID==Value.sellTower && (GameField.room.Block[y][x].airID==Value.NormalTower || GameField.room.Block[y][x].airID==Value.DameTower || GameField.room.Block[y][x].airID==Value.SpeedShotTower)){
                                    GameField.coinage+=5;
                                    for(int i =0;i<GameField.theTower.size();i++){
                                        if(GameField.theTower.get(i).x==GameField.room.Block[y][x].x
                                                && GameField.theTower.get(i).y==GameField.room.Block[y][x].y){
                                            GameField.theTower.remove(i);
                                            GameField.room.Block[y][x].airID = Value.airAir;
                                        }
                                    }

                                }
                                if(GameField.room.Block[y][x].groundID!=Value.groundRoad && GameField.room.Block[y][x].airID==Value.airAir){
                                    if(heldID!=Value.sellTower){
                                        GameField.room.Block[y][x].airID = heldID;
                                        switch (GameField.room.Block[y][x].airID) {
                                            case Value.DameTower: GameField.theTower.add(new TowerSniper(GameField.room.Block[y][x].x, GameField.room.Block[y][x].y, GameField.room.Block[y][x].width, GameField.room.Block[y][x].height, GameField.room.Block[y][x].airID));
                                                break;
                                            case Value.NormalTower: GameField.theTower.add(new TowerNormal(GameField.room.Block[y][x].x, GameField.room.Block[y][x].y, GameField.room.Block[y][x].width, GameField.room.Block[y][x].height, GameField.room.Block[y][x].airID));
                                                break;
                                            case Value.SpeedShotTower: GameField.theTower.add(new TowerMachineGun(GameField.room.Block[y][x].x, GameField.room.Block[y][x].y, GameField.room.Block[y][x].width, GameField.room.Block[y][x].height, GameField.room.Block[y][x].airID));
                                                break;
                                        }
                                    }
                                    GameField.coinage -= buttonPrice[realID];
                                }

                            }
                        }
                    }
                }
            }
        }
    }


    public void define(){
        for(int i=0;i<button.length;i++){
            button[i] = new Rectangle((GameField.myWidth/2)-(shopWidth*(buttonSize+cellSpace)/2) + (buttonSize+cellSpace)*i,GameField.room.Block[GameField.room.worldHeight-1][0].y+GameField.room.blockSize+awayFromRoom,buttonSize,buttonSize);
        }

        buttonHealth = new Rectangle(GameField.room.Block[0][0].x-1,button[0].y,iconSize,iconSize);
        buttonCoins = new Rectangle(GameField.room.Block[0][0].x-1,button[0].y+button[0].height-iconSize,iconSize,iconSize);
    }

    public void draw(Graphics g){
        for(int i=0;i<button.length;i++){
            if(button[i].contains(GameField.mse)) {
                g.setColor(new Color(255,255,255,255));
                g.fillRect(button[i].x,button[i].y,button[i].width,button[i].height);
            }
            g.drawImage(GameField.tileset_res[0], button[i].x,button[i].y,button[i].width,button[i].height,null);
            if(buttonID[i]!=Value.airAir) g.drawImage(GameField.tileset_air[buttonID[i]],button[i].x+itemIn,button[i].y+itemIn,button[i].width-itemIn*2,button[i].height-itemIn*2,null);
            if(buttonPrice[i]>0) {
                g.setColor(new Color(255,255,255));
                g.setFont(new Font("Courier New",Font.BOLD,14));
                g.drawString("$"+buttonPrice[i],button[i].x+itemIn,button[i].y+itemIn);
            }
        }

        g.drawImage(GameField.tileset_res[1],buttonHealth.x,buttonHealth.y,buttonHealth.width,buttonHealth.height,null);
        g.drawImage(GameField.tileset_res[2],buttonCoins.x,buttonCoins.y,buttonCoins.width,buttonCoins.height,null);
        g.setFont(new Font("Courier New",Font.BOLD,14));
        g.setColor(new Color(255,255,255));
        g.drawString("" + GameField.health,buttonHealth.x + buttonHealth.width+iconSpace,buttonHealth.y+iconTextY);
        g.drawString("" + GameField.coinage,buttonCoins.x + buttonCoins.width+iconSpace,buttonCoins.y+iconTextY);

        //di chuyen icon thap
        if(holdItem){
            g.drawImage(GameField.tileset_air[heldID],GameField.mse.x+itemIn-(button[0].width-itemIn*2)/2,GameField.mse.y+itemIn-(button[0].width-itemIn*2)/2,button[0].width-itemIn*2,button[0].height-itemIn*2,null);
        }
    }
}
