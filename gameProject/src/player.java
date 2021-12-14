
import javax.swing.*;
import java.awt.*;

public class player {
    private static int times;
    private int x, y, width, height, score, total;
    private Image image;
    public player(){
        this.image = new ImageIcon("src/resources/pov1.png").getImage();//reference: https://twitter.com/veryeviltomato/status/1174012059329146881
        this.width = 180;
        this.height = 300;
        this.x =400;
        this.y = 550;
        this.times = 5;
        this.total = 0;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getTotalScore() {
        return total;
    }

    public void setTotalScore(int total) {
        this.total = total;
    }
}
