import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;


public class Menu extends GraphicsProgram {
    double menu_height = Vars.APPLICATION_HEIGHT / 2;
    GRect background = new GRect(0, Vars.BRICK_Y_OFFSET, Vars.APPLICATION_WIDTH , menu_height);
    GLabel text = new GLabel("Atari Breakout.\n (press space to start)");
    GCompound menu = new GCompound();
    public Menu(){
        background.setFilled(true);
        background.setColor(Color.decode("#117a65"));

        text.setFont("TimesNewRoman-" + (int)((Vars.APPLICATION_WIDTH/2.7) * (menu_height/2.5) / 1000));
        double text_x = (Vars.APPLICATION_WIDTH - text.getWidth() * 1.1);
        double text_y = (menu_height / 2) + Vars.BRICK_Y_OFFSET + (text.getAscent() / 2);
        text.setLocation(text_x, text_y);
        text.setColor(Color.decode("#fdfefe"));

        menu.add(background);
        menu.add(text);
    }

    public GObject getMenuGObject(){
        return menu;
    }
}
