import javax.swing.*;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {
    public Drawing screen;
    public Input input;

    public int fixedTime = 1000 / 60;
    public boolean run = true;

    public MainWindow(){
        screen = new Drawing();
        screen.setSize(400, 400);
        screen.setDoubleBuffered(true);

        input = new Input();

        addKeyListener(input);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.getContentPane().add(screen);

        screen.startLoop();
    }

    public void startLoop(){
        try{
            while (run){
                screen.clear();
                loop();
                input.update();
                Thread.sleep(fixedTime);
            }
        }catch (Exception e){

        }
    }

    int x = 0;
    public void loop(){
        Rect rect = new Rect(x,10, 50, 50);
        screen.rectangles.add(rect);
        x++;

        if(Input.getKeyDown(KeyEvent.VK_E)){
            x = 0;
        }
    }

    public static void main(String[] args) {
        MainWindow frame = new MainWindow();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.startLoop();
    }
}
