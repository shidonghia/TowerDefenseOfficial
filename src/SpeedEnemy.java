
public class SpeedEnemy extends Enemy {
    public int healthSpeedEnemy = 500;
    public int walkSpeedSpeedEnemy = 50;
    SpeedEnemy(){
    }
    public void spawnMob(int mobID){
        for(int y = 0; y<GameField.room.Block.length; y++){
            if(GameField.room.Block[y][0].groundID == Value.groundRoad){
                setBounds(GameField.room.Block[y][0].x,GameField.room.Block[y][0].y,mobSize,mobSize);
                xC=0;
                yC=y;
                this.health = healthSpeedEnemy;
                this.walkSpeed = walkSpeedSpeedEnemy;
            }
        }
        this.mobID = mobID;
        inGame = true;
    }
}
