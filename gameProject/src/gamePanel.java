import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class gamePanel extends JPanel {
    private player player;
    Image background;


    public gamePanel(player player){
        this.player = player;



        try{
            background = ImageIO.read(new File("src/resources/bg2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(background, 0, 0, 1500, 900, null);
        g.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("",Font.BOLD,60 ));
        g.drawString(""+player.getScore(), 355, 250);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("",Font.BOLD,60 ));
        g.drawString(""+ player.getTimes(), 1100, 250);
        g.drawString("Total Score:"+ player.getTotalScore(), 550, 200);

    }

}
