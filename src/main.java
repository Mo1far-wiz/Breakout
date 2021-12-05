import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.*;
import acm.util.RandomGenerator;

public class main extends GraphicsProgram {
    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 800;

    public static final int PADDLE_WIDTH = 60;
    public static final int PADDLE_HEIGHT = 10;

    private static final int NBRICKS_PER_ROW = 10;
    private static final int NBRICKS_ROWS = 10;

    private static final int BRICK_SEP = 10;

    private static final int BRICK_WIDTH =
            ((APPLICATION_WIDTH - 15) - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
    private static final int BRICK_HEIGHT = 8;

    private static final int BRICK_Y_OFFSET = 70;

    private static final int BALL_RADIUS = 10;

    private physics physics = new physics();
    private RandomGenerator rg = new RandomGenerator();

    public void run()
    {
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

        physics.createBall(200, 200);
        physics.ball ball = physics.getBall();

        add(ball.getBallInstance());
        //add(ball.dir);

        ball.setDirection(rg.nextDouble(0.1,2*Math.PI));

        /*physics.createBall(200, 200);
        physics.ball ball2 = physics.getBall();
        add(ball2.getBallInstance());
        ball2.setDirection(rg.nextDouble(0.1,2*Math.PI));*/

        while(true)
        {
            ball.checkCollision();
            ball.move();

            /*ball2.checkCollision();
            if(ball2.lineAlllowed)
                add(ball2.getLine());
            ball2.move();*/

            pause(5);
        }
    }

    public void drawBricks() {
        DrawGraphics bricks = new DrawGraphics();
        for (int x = 0; x < NBRICKS_PER_ROW; ++x)
            for (int y = 0; y < NBRICKS_ROWS; ++y) {
                int bx = x * (BRICK_WIDTH + BRICK_SEP);
                int by = BRICK_Y_OFFSET + y * (BRICK_HEIGHT + BRICK_SEP);
                //add(bricks.setBrick(bx, by, y));
            }
    }

    public int getNBRICKS_PER_ROW() {
        return NBRICKS_PER_ROW;
    }

    public int getNBRICKS_ROWS() {
        return NBRICKS_ROWS;
    }

    public int getBRICK_SEP() {
        return BRICK_SEP;
    }

    public int getBRICK_WIDTH() {
        return BRICK_WIDTH;
    }

    public int getBRICK_HEIGHT() {
        return BRICK_HEIGHT;
    }

    public int getBRICK_Y_OFFSET() {
        return BRICK_Y_OFFSET;
    }

    public int getBALL_RADIUS() {
        return BALL_RADIUS;
    }
}