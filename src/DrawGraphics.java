import acm.graphics.GRect;
import java.awt.*;

public class DrawGraphics extends main {
    public GRect setBrick(double x, double y, int nrow){
        GRect brick = new GRect(getBRICK_WIDTH(), getBRICK_HEIGHT());
        nrow /= 2;
        brick.setFilled(true);
        brick.setLocation(x, y);
        if(nrow == 0)
            brick.setColor(Color.RED);
        else if(nrow == 1)
            brick.setColor(Color.ORANGE);
        else if(nrow == 2)
            brick.setColor(Color.YELLOW);
        else if(nrow == 3)
            brick.setColor(Color.GREEN);
        else if(nrow == 4)
            brick.setColor(Color.CYAN);
        return brick;
    }
}
