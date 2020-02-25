import java.awt.*;

public class Rect {
    int x, y, width, height;

    Color color = Color.white;

    public boolean borderOnly = false;

    Rect(int x, int y, int width, int height){
        this(Color.white, x, y, width, height);
    }

    Rect(Color color,int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }


    public void fill(Graphics graphics){
        graphics.setColor(color);
        graphics.fillRect(x,y,width,height);
    }

    public void drawBorder(Graphics graphics){
        graphics.setColor(color);
        graphics.drawRect(x,y,width,height);
    }
}
