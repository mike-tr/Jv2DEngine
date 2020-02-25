import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Input implements KeyListener {
    public boolean run = true;
    public int delay = 10;

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
            AddList.add(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        RemoveList.add(e.getKeyCode());
    }

    public void update(){
        for (int i = 0; i < AddList.size(); i++) {
            Pressed.add(AddList.get(i));
            //System.out.println(AddList.get(i));
        }
        for (int i = 0; i < RemoveList.size(); i++) {
            Pressed.remove(RemoveList.get(i));
        }

        AddList = new Vector<>();
        RemoveList = new Vector<>();
    }
}
