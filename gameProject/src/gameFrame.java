import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gameFrame extends JFrame {

    public static final int WIDTH=1500;
    public static final int HEIGHT=900;
    player player = new player();

    int total = 0;
    int i = 5;
    boolean isGameOver = false;

    public gameFrame(){


        gamePanel panel = new gamePanel(player);
        action();
        this.setTitle("ShootingGame");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.add(panel);

        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode()==KeyEvent.VK_LEFT && player.getX()>500){
                    //player.setX(player.getX()-5);
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT && player.getX()<1000){
                    //player.setX(player.getX()+5);
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){

                    if(player.getX()<800&&player.getX()>750){
                        /*
                        animation here
                         */
                        int pos = player.getX()-5;
                        int point = 10-(pos%750)/5;

                        player.setTimes(player.getTimes()-1);

                        player.setScore(point);
                        total = total + point;

                    }else if(player.getX()<=750&&player.getX()>700){
                        /*
                        animation here
                         */
                        int pos = player.getX()-10;
                        int point = 10-(750%pos)/5;

                        player.setTimes(player.getTimes()-1);

                        player.setScore(point);
                        total = total + point;

                    }
                    else if(player.getX()<=700&&player.getX()>640){
                        /*
                        animation here
                         */
                        int pos = player.getX()-4;
                        int point = 10-(pos%640)/10;

                        player.setTimes(player.getTimes()-1);

                        player.setScore(point);
                        total = total + point;

                    }
                    else if(player.getX()<=640&&player.getX()>550){
                        /*
                        animation here
                         */
                        int pos = player.getX()-15;
                        int point = 10-(640%pos)/10;

                        player.setTimes(player.getTimes()-1);

                        player.setScore(point);
                        total = total + point;

                    }
                    else if(player.getX()<=900&&player.getX()>800){
                        /*
                        animation here
                         */
                        int pos = player.getX()-5;
                        int point = 10-(900%pos)/10;

                        player.setTimes(player.getTimes()-1);

                        System.out.println(point);
                        player.setScore(point);
                        total = total + point;

                    }
                    else if(player.getX()<=1000&&player.getX()>900){
                        /*
                        animation here
                         */
                        int pos = player.getX()-10;
                        int point = 10-(pos%900)/10;

                        player.setTimes(player.getTimes()-1);

                        player.setScore(point);
                        total = total + point;

                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }  });

        while(true){

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            player.setX(player.getX()+i);
            if(player.getX()>=1000) {
               i = -5;
            }else if(player.getX()<=400) {
                i = 5;
            }

            panel.repaint();
        }
    }

    public void gameOver(){
        if(player.getTimes()==0){
            isGameOver = true;
            player.setTotalScore(total);
            Memory.memory(total);
            new endFrame();
            dispose();
        }

    }
    public void action(){
        new Thread(() -> {
            while(!isGameOver){
                    gameOver();
                repaint();
                try {
                    Thread.sleep(60);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }

        }).start();
    }

    public static void main(String[] args)  {
        new gameFrame();
    }

}
