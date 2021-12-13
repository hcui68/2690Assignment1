import javax.swing.*;
import java.awt.*;

public class loadingPage extends JFrame implements Runnable{

    JLabel background;
    JProgressBar jpb;

    public void Start(){
        loadingPage frame = new loadingPage();
        Thread t = new Thread(frame);
        t.start();
        dispose();
    }


    public loadingPage() {
        background = new JLabel(new ImageIcon("resources/loading.png"));
        this.add(BorderLayout.NORTH, background);

        jpb = new JProgressBar();
        jpb.setStringPainted(true);
        jpb.setBackground(Color.ORANGE);
        this.add(BorderLayout.SOUTH, jpb);

        this.setSize(385,131);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(1);
        this.setUndecorated(true);
        //this.setIconImage(new ImageIcon("resources/loading.png").getImage());
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new loadingPage().Start();
    }


    @Override
    public void run() {
        int [] values = {0,10,20,30,40,50,60,70,80,90,100};
        for(int i=0; i<values.length; i++){
            jpb.setValue(values[i]);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}