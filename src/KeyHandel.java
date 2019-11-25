import java.awt.*;
import java.awt.event.*;
public class KeyHandel implements MouseMotionListener, MouseListener {

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        GameField.store.click(e.getButton());
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        GameField.mse = new Point(e.getX() + ((GameStage.size.width - GameField.myWidth)/2),e.getY() + ((GameStage.size.height - GameField.myHeight) - (GameStage.size.width - GameField.myWidth)/2));
    }

    public void mouseMoved(MouseEvent e) {
        GameField.mse = new Point(e.getX() - ((GameStage.size.width - GameField.myWidth)/2),e.getY() - ((GameStage.size.height - GameField.myHeight) - (GameStage.size.width - GameField.myWidth)/2));
    }
}
