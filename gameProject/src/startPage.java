import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class startPage extends JFrame implements MouseListener {

    JLabel start, help, configuration, exit;
    JPanel mainPage;

    public startPage(){
        start = new JLabel(new ImageIcon("resources/start1.png"));//start icon
        start.setBounds(200,200,319,100);
        start.setEnabled(false);
        start.addMouseListener(this);
        this.add(start);

        help = new JLabel(new ImageIcon("resources/help1.png"));//help icon
        help.setBounds(200,350,310,90);
        help.setEnabled(false);
        help.addMouseListener(this);
        this.add(help);

        configuration = new JLabel(new ImageIcon("resources/config1.png"));//config icon
        configuration.setBounds(200,500,350,90);
        configuration.setEnabled(false);
        configuration.addMouseListener(this);
        this.add(configuration);

        exit = new JLabel(new ImageIcon("resources/exit1.png"));//exit icon
        exit.setBounds(200,650,270,90);
        exit.setEnabled(false);
        exit.addMouseListener(this);
        this.add(exit);

        mainPage newPage = new mainPage();
        this.add(newPage);

        this.setSize(1200,900);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon().getImage());//game logo
        this.setVisible(true);
    }

    public static void main(String[] args){
        new startPage();
    }

    /* display background image
    *
    *
    * */
    class mainPage extends JPanel{
        Image background;
        public mainPage(){
            try{
                background = ImageIO.read(new File("resources/bg1.png"));
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        public void paint(Graphics g){
            super.paint(g);
            g.drawImage(background, 0, 0, 1200, 900, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(start)){
            new loadingPage().Start();
            dispose();
        }else if(e.getSource().equals(exit)){
            dispose();
        }else if(e.getSource().equals(configuration)){
            //dispose();
        }else if(e.getSource().equals(help)){
            JOptionPane.showMessageDialog(null, "Please enjoy!");
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
        if(e.getSource().equals(start)){
            start.setEnabled(true);
        }else if(e.getSource().equals(help)){
            help.setEnabled(true);
        }else if(e.getSource().equals(configuration)){
            configuration.setEnabled(true);
        }else if(e.getSource().equals(exit)){
            exit.setEnabled(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(start)){
            start.setEnabled(false);
        }else if(e.getSource().equals(help)){
            help.setEnabled(false);
        }else if(e.getSource().equals(configuration)) {
            configuration.setEnabled(false);
        }else if(e.getSource().equals(exit)){
            exit.setEnabled(false);
        }
    }

}
