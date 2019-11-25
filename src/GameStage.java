import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameStage extends JFrame {
    public static String tittle = " Tower Defense";
    public static Dimension size = new Dimension(1000,700);


    public void init() {
        setLayout(new GridLayout(1,1,1,1));

        GameField screen = new GameField(this);
        add(screen);

        Sound s = new Sound( "C:\\Users\\DAO NGAN\\IdeaProjects\\TowerDefenseReal\\nhac.wav");
        s.start();
        setVisible(true);

    }


    public GameStage(){
        setTitle(tittle);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }


    public static void main(String[] args){
        GameStage newFrame = new GameStage();
    }
}