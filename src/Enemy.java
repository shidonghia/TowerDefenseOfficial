import java.awt.*;

public abstract class Enemy extends Rectangle {
    public int xC,yC; // toa do
    public int health;
    public int walkFrame = 0, walkSpeed;

    public int healthSpace = 3, healthHeight = 6;
    public int mobSize = 40;
    public double healthSize = 40;
    public int upward = 0, downward = 1,right = 2,left = 3; //gán phím di chuyển 
    public int direction = right; // hướng di chuyển mặc định
    public int mobWalk = 0; // bước di chuyển
    public int mobID = Value.mobAir;
    public boolean inGame = false;

    // điều hướng di chuyển
    public boolean hasUpward = false;
    public boolean hasDownward = false;
    public boolean hasLeft = false;
    public boolean hasRight = false;

    public Enemy(){

    }

    // tao quai
    public abstract void spawnMob(int mobID);

    public void deleteMob(){
        inGame=false;
        direction = right;
        mobWalk=0;
        healthSize=40;
    }

    public void loseHealth(){
        GameField.health-=1;
    }

    // di chuyen
    public void physic(){
        if(walkFrame>=walkSpeed) {
            if(direction==right) {
                x += 1;
            }
            else if(direction==upward) {
                y-=1;
            }
            else if(direction==downward){
                y+=1;
            }
            else if(direction==left){
                x-=1;
            }

            mobWalk+=1;
            if(mobWalk==GameField.room.blockSize){
                if(direction==right) {
                    xC += 1;
                    hasRight = true;
                }
                else if(direction==upward) {
                    yC-=1;
                    hasUpward = true;
                }
                else if(direction==downward){
                    yC+=1;
                    hasDownward = true;
                }
                else if(direction==left){
                    xC-=1;
                    hasLeft = true;
                }
                if(!hasUpward) {
                    try {
                        if (GameField.room.Block[yC + 1][xC].groundID == Value.groundRoad) {
                            direction = downward;
                        }
                    } catch (Exception e) {
                    }
                }
                if(!hasDownward) {
                    try {
                        if (GameField.room.Block[yC - 1][xC].groundID == Value.groundRoad) {
                            direction = upward;
                        }
                    } catch (Exception e) {
                    }
                }
                if(!hasLeft) {
                    try {
                        if (GameField.room.Block[yC][xC + 1].groundID == Value.groundRoad) {
                            direction = right;
                        }
                    } catch (Exception e) { }
                }
                if(!hasRight) {
                    try {
                        if (GameField.room.Block[yC][xC - 1].groundID == Value.groundRoad) {
                            direction = left;
                        }
                    } catch (Exception e) { }
                }
                if(GameField.room.Block[yC][xC].airID==Value.airCave){
                    deleteMob();
                    loseHealth();
                }
                hasUpward = false;
                hasDownward = false;
                hasLeft = false;
                hasRight = false;
                mobWalk=0;
            }
            walkFrame=0;
        }
        else {
            walkFrame+=1;
        }
    }

    public void loseHealth(double amo){
        healthSize-=healthSize*(amo/health);
        health -= amo;
        checkDeath();
    }
    public void checkDeath(){
        if(health < 1) {
            //Sound dead = new Sound("C:\\Users\\DAO NGAN\\IdeaProjects\\TowerDefense\\dead2.wav");
            //dead.start();
            deleteMob();
            GameField.killed++;
            getMoney();
        }

    }

    public boolean isDead(){
        if(inGame){
            return false;
        }
        else {
            return true;
        }
    }

    public void getMoney(){
        GameField.coinage += Value.deathReward[mobID];
    }

    public void draw(Graphics g){

        g.drawImage(GameField.tileset_mob[mobID],x,y,width,height,null);
        g.setColor(new Color(180,50,50));
        g.fillRect(x,y-(healthSpace+healthHeight),width,healthHeight);



        g.setColor(new Color(50,180,50));
        g.fillRect(x,y-(healthSpace+healthHeight),(int)healthSize,healthHeight);

        g.setColor(new Color(0,0,0));
        g.drawRect(x,y-(healthSpace+healthHeight),(int)healthSize-1,healthHeight-1);
    }
}