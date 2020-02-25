import javax.swing.*;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame {
    public Drawing screen;
    public Input input;

    public int fixedTime = 1000 / 60;
    public boolean run = true;

    public MainWindow(int width, int height){
        screen = new Drawing();
        screen.setSize(width, height);
        screen.setDoubleBuffered(true);

        input = new Input();

        addKeyListener(input);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.getContentPane().add(screen);

        screen.startLoop();

        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startLoop();
    }

    public void startLoop(){
        try{
            while (run){
                // main stuff
                //clear basically remove old drawings from draw queue
                //loop is the main loop
                //input update, updates the keypress logic
                //sleep, well for sleep
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
        //main loop change to watever
        x++;
        //creates a new rect object at (x, 10), with size of 50x50
        Rect rect = new Rect(x,10, 50, 50);
        //Adds the rect to the draw list
        //if screen.clear() is not called this same rect will be drawned over and over again
        //yes you can just remove the clear method and just change the actual rect.
        screen.drawRect(rect);

        //do stuff when E is pressed
        //this is how to use Input
        if(Input.getKeyDown(KeyEvent.VK_E)){
            x = 0;
        }
    }

    public static void main(String[] args) {
        //create the window
        new MainWindow(600,600);
    }
}
