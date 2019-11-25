
public class BossEnemy extends Enemy {
    public int healthBossEnemy = 50000;
    public int walkSpeedBossEnemy = 100;
    BossEnemy(){
    }
    public void spawnMob(int mobID){
        for(int y = 0; y<GameField.room.Block.length; y++){
            if(GameField.room.Block[y][0].groundID == Value.groundRoad){
                setBounds(GameField.room.Block[y][0].x,GameField.room.Block[y][0].y,mobSize,mobSize);
                xC=0;
                yC=y;
                this.health = healthBossEnemy;
                this.walkSpeed = walkSpeedBossEnemy;
            }
        }
        this.mobID = mobID;
        inGame = true;
    }
}
