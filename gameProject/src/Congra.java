import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.management.GarbageCollectorMXBean;
import java.net.URL;

public class Congra extends JFrame implements MouseListener {

    JLabel back;

    public Congra(){
        back = new JLabel(new ImageIcon("src/resources/back1.png"));
        back.setBounds(200, 200, 70, 30);
        back.addMouseListener(this);
        this.add(back);
    }

    /* animation code https://stackoverflow.com/questions/2935232/show-animated-gif*/

    public static void main(String[] args) {

        new Congra();
        URL url = Congra.class.getResource("/resources/animation.gif");//https://cutewallpaper.org/21/pixel-art-background-gif/view-page-21.html
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        JFrame f = new JFrame("Animation");
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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