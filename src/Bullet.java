import java.awt.*;

public class Bullet extends Rectangle {
    public int positionTargetX;
    public int positionTargetY;

    public int speedBullet;

    public int IDBullet;

    public Bullet(int airID, int idEnemy, int positionBulletX, int positionBulletY,int bulletSize,int speedBullet){
        super(positionBulletX,positionBulletY,bulletSize,bulletSize);
        this.speedBullet = speedBullet;
        this.IDBullet = idEnemy;
    }

    public void draw(Graphics g){
        g.drawImage(GameField.tileset_bullet[0],positionTargetX,positionTargetY,width,height,null);
    }

    public void update(){
        try {
            positionTargetX = GameField.mobs[IDBullet].x + width/2;
            positionTargetY = GameField.mobs[IDBullet].y + height/2;
         } catch(Exception e){}
    }
}
