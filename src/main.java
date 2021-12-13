import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class main extends GraphicsProgram
{
    public void run()
    {
        this.setSize(Vars.APPLICATION_WIDTH, Vars.APPLICATION_HEIGHT);
        this.setBackground(Color.decode("#263238"));
        addMouseListeners();

        drawBricks();

        GameObjects.ball ball = new GameObjects.ball(100, 100, Vars.BALL_RADIUS);
        add(ball.getBallInstance());

        GameObjects.Platform platform = new GameObjects.Platform(100, 600, Vars.PADDLE_WIDTH, Vars.PADDLE_HEIGHT);
        add(platform.getPlatformInstance());

        while(true)
        {
            ball.move();
            platform.move();
            pause(5);
        }
    }

    public void mouseMoved(MouseEvent e)
    {
        Vars.MouseX = e.getX();
        Vars.MouseY = e.getY();
    }

    public void drawBricks() {
        for (int x = 0; x < Vars.NBRICKS_PER_ROW; ++x)
            for (int y = 0; y < Vars.NBRICKS_ROWS; ++y) {
                int bx = x * (Vars.BRICK_WIDTH + Vars.BRICK_SEP);
                int by = Vars.BRICK_Y_OFFSET + y * (Vars.BRICK_HEIGHT + Vars.BRICK_SEP);
                add(GameObjects.Bricks.setBrick(bx, by, y));
            }
    }

    public static void main(String[] args) {
        new main().start(args);
    }
}