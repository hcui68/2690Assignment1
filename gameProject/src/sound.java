import javax.sound.sampled.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/*

Reference: https://blog.csdn.net/qq_44752978/article/details/116297832?spm=1001.2101.3001.6650.9&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-9.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-9.no_search_link

 */
public class sound extends Thread{
    private String filename;
    private final int buffer_size = 524288;
    public sound(String file){
        this.filename = file;
    }

    public void run(){
        File soundFile = new File(filename);
        if(!soundFile.exists()){
            System.out.println("error");
            return;
        }
        while (true){
            AudioInputStream a = null;
            try{
                a = AudioSystem.getAudioInputStream(soundFile);
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AudioFormat format = a.getFormat();
            SourceDataLine auline = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            try{
                auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            if(auline.isControlSupported(FloatControl.Type.PAN)){
                FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
            }
            auline.start();
            int nBytesRead = 0;
            byte[] abData = new byte[buffer_size];
            try{
                while (nBytesRead != -1){
                    nBytesRead = a.read(abData, 0, abData.length);
                    if (nBytesRead>=0){
                        auline.write(abData, 0, nBytesRead);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                auline.drain();
            }
        }
    }
}
