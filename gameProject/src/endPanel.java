import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class endPanel extends JPanel {
    private player player;
    Image background;


    public endPanel(player player){
        this.player = player;
        try {
            background = ImageIO.read(new File("src/resources/bg1.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(background, 0, 0,1500,900 ,null);
        g.setColor(Color.pink);
        g.setFont(new Font("",Font.BOLD,70));
        g.drawString("Good Job!",750,400);

        g.setFont(new Font("",Font.BOLD,70));
        g.setColor(Color.ORANGE);
        g.drawString("Total Scores:"+Memory.answer(), 750, 600);

    }

}
