import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRoundRect;

import java.awt.*;

public class GameObjects{

    public static class Bricks {
        public static GRoundRect setBrick(double x, double y, int nrow) {
            GRoundRect brick = new GRoundRect(Vars.BRICK_WIDTH, Vars.BRICK_HEIGHT);
            brick.setFilled(true);
            brick.setLocation(x, y);

            int color_rows = Vars.NBRICKS_ROWS / 5;
            nrow /= color_rows;

            if (nrow > 4)
                nrow -= 5;

            if (nrow == 0)
                brick.setColor(Color.decode("#d50000"));
            else if (nrow == 1)
                brick.setColor(Color.decode("#f57f17"));
            else if (nrow == 2)
                brick.setColor(Color.decode("#ffea00"));
            else if (nrow == 3)
                brick.setColor(Color.decode("#558b2f"));
            else if (nrow == 4)
                brick.setColor(Color.decode("#00b8d4"));
            return brick;
        }
    }

    public static class Platform{
        private GObject platform = new GRect(0, 0);
        private double platform_weight;
        private double platform_height;

        public Platform(){

        }
    }
}
