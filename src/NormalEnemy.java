
public class NormalEnemy extends Enemy {
    public int healthNormalEnemy = 2000;
    public int walkSpeedNormalEnemy = 20;
    NormalEnemy(){
    }
    public void spawnMob(int mobID){
        for(int y = 0; y<GameField.room.Block.length; y++){
            if(GameField.room.Block[y][0].groundID == Value.groundRoad){
                setBounds(GameField.room.Block[y][0].x,GameField.room.Block[y][0].y,mobSize,mobSize);
                xC=0;
                yC=y;
                this.health = healthNormalEnemy;
                this.walkSpeed = walkSpeedNormalEnemy;
            }
        }
        this.mobID = mobID;
        inGame = true;
    }
}
