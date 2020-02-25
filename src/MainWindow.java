import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow extends JFrame {
    public Drawing canvas;
    public Input input;

    public int fps = 1000 / 60;
    public boolean run = true;

    public MainWindow(){
        canvas = new Drawing();
        canvas.setSize(400, 400);
        canvas.setDoubleBuffered(true);

        input = new Input();

        addKeyListener(input);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.getContentPane().add(canvas);

        canvas.startLoop();
    }

    public void startLoop(){
        try{
            while (run){
                loop();
                input.update();
                Thread.sleep(fps);
            }
        }catch (Exception e){

        }
    }

    public void loop(){
        if(Input.getKeyDown(KeyEvent.VK_E)){
            System.out.println("nibba");
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
