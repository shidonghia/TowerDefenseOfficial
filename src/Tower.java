import java.awt.*;

public class Tower extends Rectangle {

    public Rectangle towerSquare;
    public int towerSquareSize;
    public int dame;
    public int loseFrame = 0, towerSpeedShot;
    public int airID;

    public int shotMob = -1;
    public boolean shoting = false;

    // xac dinh vi tri
    public Tower(int x, int y, int width, int height, int airID){
        setBounds(x,y,width,height);
        towerSquare = new Rectangle(x-towerSquareSize/2,y-towerSquareSize/2,width+towerSquareSize,height+towerSquareSize);
        this.airID = airID;
    }

    public void draw(Graphics g){
        //g.drawImage(GameField.tileset_ground[groundID],x,y,width,height,null);


        if(airID!=Value.airAir){
            g.drawImage(GameField.tileset_air[airID],x,y,width,height,null);
        }
    }

    // ham bắn
    public void physic(){

        if(!shoting) {
            if (airID == Value.NormalTower || airID == Value.DameTower || airID == Value.SpeedShotTower) {
                for (int i = 0; i < GameField.mobs.length; i++) {
                    if (GameField.mobs[i].inGame ) {
                        if (towerSquare.intersects(GameField.mobs[i])) {
                            shoting = true;
                            shotMob = i;
                            break;
                        }
                    }

                }
            }
        }
        if(shoting){
            if(loseFrame>towerSpeedShot) {

                if (airID == Value.NormalTower ) {
                    GameField.mobs[shotMob].loseHealth(dame);
                }
                if (airID == Value.DameTower ) {
                    GameField.mobs[shotMob].loseHealth(dame);

                }
                if (airID == Value.SpeedShotTower ) {
                    GameField.mobs[shotMob].loseHealth(dame);
                }
                loseFrame=0;
            }
            else {
                loseFrame+=1;
            }

            if(GameField.mobs[shotMob].isDead() || GameField.mobs[shotMob].isDead()){


                shoting=false;
                shotMob=-1;
                GameField.hasWon();
            }
        }
    }

    public void fight(Graphics g){

        if(GameField.isDebug) {

            if (airID == Value.NormalTower) {
                g.drawRect(towerSquare.x, towerSquare.y, towerSquare.width, towerSquare.height);
            }
            if (airID == Value.DameTower) {
                g.drawRect(towerSquare.x, towerSquare.y, towerSquare.width, towerSquare.height);
            }
            if (airID == Value.SpeedShotTower) {
                g.drawRect(towerSquare.x, towerSquare.y, towerSquare.width, towerSquare.height);
            }
        }

        if (shoting) {
            //Sound shot = new Sound("C:\\Users\\DAO NGAN\\IdeaProjects\\TowerDefense\\laze2.wav");
            if (airID == Value.NormalTower ) {
                Graphics2D g2d = (Graphics2D) g.create();
                float[] dash1 = {8f, 0f, 8f};
                BasicStroke bs1 = new BasicStroke(4, BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
                g2d.setColor(Color.blue);
                g2d.setStroke(bs1);
                g2d.drawLine(x+width/2,y+height/2,GameField.mobs[shotMob].x+GameField.mobs[shotMob].width/2
                        ,GameField.mobs[shotMob].y+GameField.mobs[shotMob].height/2);
                //shot.start();
            }
            if (airID == Value.DameTower) {

                g.setColor(Color.YELLOW);

                g.drawLine(x+width/2,y+height/2,GameField.mobs[shotMob].x+GameField.mobs[shotMob].width/2
                        ,GameField.mobs[shotMob].y+GameField.mobs[shotMob].height/2);
                //shot.start();

            }
            if (airID == Value.SpeedShotTower) {

                g.setColor(Color.RED);

                g.drawLine(x+width/2,y+height/2,GameField.mobs[shotMob].x+GameField.mobs[shotMob].width/2
                        ,GameField.mobs[shotMob].y+GameField.mobs[shotMob].height/2);
                //shot.start();
            }
        }
    }
}
