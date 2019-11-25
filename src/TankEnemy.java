
public class TankEnemy extends Enemy {
    public int healthTankEnemy = 5000;
    public int walkSpeedTankEnemy = 40;
    TankEnemy(){
    }
    public void spawnMob(int mobID){
        for(int y = 0; y<GameField.room.Block.length; y++){
            if(GameField.room.Block[y][0].groundID == Value.groundRoad){
                setBounds(GameField.room.Block[y][0].x,GameField.room.Block[y][0].y,mobSize,mobSize);
                xC=0;
                yC=y;
                this.health = healthTankEnemy;
                this.walkSpeed = walkSpeedTankEnemy;
            }
        }
        this.mobID = mobID;
        inGame = true;
    }
}
