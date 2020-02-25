import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Drawing extends JPanel {
    public class Painter extends Thread{
        Drawing parent;

        Painter(Drawing parent){
            this.parent = parent;
        }

        @Override
        public void run(){
            while (parent.run){
                parent.repaint();
                delay(parent.fps);
            }
        }

        public void delay(int time){
            try{
                Thread.sleep(time);
            }catch (Exception e){

            }
        }
    }

    boolean run = true;
    int fps = 1000 / 60;
    int x = 10;
    public Color background = Color.black;
    Painter loop;

    Drawing(){
        loop = new Painter(this);
    }

    public void startLoop(){
        run = true;
        loop.start();
    }

    public void pauseLoop(){
        run = false;
    }

    Vector<Rect> rectangles = new Vector<>();
    public void paint(Graphics g) {
        g.setColor(background);
        g.fillRect(0,0, getWidth(), getHeight());

        for (Rect rect : rectangles){
            if(rect.borderOnly){
                rect.drawBorder(g);
            }else{
                rect.fill(g);
            }
        }
    }

    public void clear(){
        rectangles = new Vector<>();
    }
}