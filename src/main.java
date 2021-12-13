import acm.graphics.GObject;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import acm.util.RandomGenerator;

public class main extends GraphicsProgram
{
    GameObjects.Platform platform = new GameObjects.Platform((Vars.APPLICATION_WIDTH-15)/2 - Vars.PADDLE_WIDTH/2,
            600, Vars.PADDLE_WIDTH, Vars.PADDLE_HEIGHT);
    GameObjects.ball ball = new GameObjects.ball(platform.getPlatformInstance().getX()+platform.getPlatformInstance().getWidth()/2 - Vars.BALL_RADIUS/2,
            platform.getPlatformInstance().getY() - Vars.BALL_RADIUS - 15, Vars.BALL_RADIUS);

    private boolean gameStarted = false;
    public void run()
    {
        this.setSize(Vars.APPLICATION_WIDTH, Vars.APPLICATION_HEIGHT);
        this.setBackground(Color.decode("#263238"));

        // init key listeners
        addMouseListeners();
        addKeyListeners();

        // draw platform
        add(platform.getPlatformInstance());

        // draw ball
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
        while(!Vars.GameIsOver)
        {
            checkCollisions();
            ball.move();
            checkCollisions();
            platform.move();
            pause(3);
        }
    }

    private void checkCollisions()
    {
        double bx1 = ball.getBallInstance().getX() - 1;
        double by1 = ball.getBallInstance().getY() - 1;

        double bx2 = ball.getBallInstance().getX() + ball.getBallInstance().getWidth() - 1;
        double by2 = by1;

        double bx3 = ball.getBallInstance().getX() + 1;
        double by3 = ball.getBallInstance().getY() + ball.getBallInstance().getHeight() + 1;

        double bx4 = ball.getBallInstance().getX() + ball.getBallInstance().getWidth() + 1;
        double by4 = by3;

        GObject obj = null;

        if(getElementAt(bx1, by1) != null)
            obj = getElementAt(bx1, by1);
        else if(getElementAt(bx2, by2) != null)
            obj = getElementAt(bx2, by2);
        else if(getElementAt(bx3, by3) != null)
            obj = getElementAt(bx3, by3);
        else if(getElementAt(bx4, by4) != null)
            obj = getElementAt(bx4, by4);

        if(obj == platform.getPlatformInstance()) {
            ball.setDirection(Math.PI / 4);
        }
        else if(obj != null){
            ball.setDirection(1.5 * Math.PI);
            remove(obj);
            GameObjects.Bricks.deleteBrick();
        }
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

    private void drawBricks() {
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