import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Input implements KeyListener {
    static Vector<Integer> Pressed = new Vector<>();
    static Vector<Integer> RemoveList = new Vector<>();
    static Vector<Integer> AddList = new Vector<>();

    public static boolean getKeyDown(Integer key){
        return AddList.contains(key);
    }

    public static boolean getKeyUp(Integer key){
        return RemoveList.contains(key);
    }

    public static boolean getKey(Integer key){
        return Pressed.contains(key);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!Pressed.contains(e.getKeyCode())){
            Pressed.add(e.getKeyCode());
            AddList.add(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        RemoveList.add(e.getKeyCode());
        Pressed.removeElement(e.getKeyCode());
    }

    public void update(){
        AddList = new Vector<>();
        RemoveList = new Vector<>();
    }
}
