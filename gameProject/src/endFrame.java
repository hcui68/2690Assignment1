import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class endFrame extends JFrame implements MouseListener {

    JLabel replay,menu,exit;
    player player = new player();

    public endFrame() {
        replay = new JLabel(new ImageIcon("src/resources/replay.png"));
        replay.setBounds(200, 200, 360, 120);
        replay.addMouseListener(this);
        this.add(replay);
        menu = new JLabel(new ImageIcon("src/resources/menu.png"));
        menu.setBounds(200, 350, 320, 120);
        menu.addMouseListener(this);
        this.add(menu);
        exit = new JLabel(new ImageIcon("src/resources/exit1.png"));
        exit.setBounds(200, 500, 270, 90);
        exit.addMouseListener(this);
        this.add(exit);

        endPanel end = new endPanel(player);
        this.setTitle("ShootingGame");
        this.add(end);

        this.setSize(1500, 900);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("src/resource/bg1.png").getImage());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new endFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(replay)){
            new loadingPage().Start();
            dispose();
        } else if(e.getSource().equals(menu)){
            new startPage();
            dispose();
        }else if(e.getSource().equals(exit)){
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}