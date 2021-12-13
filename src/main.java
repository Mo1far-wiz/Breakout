import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import acm.util.RandomGenerator;

public class main extends GraphicsProgram
{
    private boolean gameStarted = false;
    public void run()
    {
        this.setSize(Vars.APPLICATION_WIDTH, Vars.APPLICATION_HEIGHT);
        this.setBackground(Color.decode("#263238"));

        // init key listeners
        addMouseListeners();
        addKeyListeners();

        // draw platform
        GameObjects.Platform platform = new GameObjects.Platform((Vars.APPLICATION_WIDTH-15)/2 - Vars.PADDLE_WIDTH/2, 600, Vars.PADDLE_WIDTH, Vars.PADDLE_HEIGHT);
        add(platform.getPlatformInstance());

        // draw ball
        GameObjects.ball ball = new GameObjects.ball(platform.getPlatformInstance().getX()+platform.getPlatformInstance().getWidth()/2 - Vars.BALL_RADIUS/2,
                platform.getPlatformInstance().getY() - Vars.BALL_RADIUS, Vars.BALL_RADIUS);
        add(ball.getBallInstance());

        // init menu
        Menu menu = new Menu();
        add(menu.getMenuGObject());

        // wait 4 game to start
        while(!gameStarted) { pause(5); }

        // remove menu
        remove(menu.getMenuGObject());

        // draw bricks
        drawBricks();

        // game loop
        while(true)
        {
            ball.move();
            platform.move();
            pause(5);
        }
    }

    private void checkCollisions()
    {

    }

    public void keyPressed(KeyEvent e)
    {
        if(!gameStarted && e.getKeyCode() == 32)
            gameStarted = true;
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