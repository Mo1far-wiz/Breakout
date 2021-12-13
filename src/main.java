import acm.program.GraphicsProgram;

import java.awt.*;

public class main extends GraphicsProgram {
    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 800;

    public static final int PADDLE_WIDTH = 60;
    public static final int PADDLE_HEIGHT = 10;

    private static final int NBRICKS_PER_ROW = 10;
    public static final int NBRICKS_ROWS = 15;

    private static final int BRICK_SEP = 10;

    private static final int BRICK_WIDTH =
            ((APPLICATION_WIDTH - 15) - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
    private static final int BRICK_HEIGHT = 8;

    private static final int BRICK_Y_OFFSET = 70;

    private static final int BALL_RADIUS = 10;

    private physics physics = new physics();

    public void run() {
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        this.setBackground(Color.decode("#263238"));
        drawBricks();
    }

    public static void main(String[] args) {
        new main().start(args);
    }

    public void drawBricks() {
        GameObjects gameObjects_bricks = new GameObjects();

        for (int x = 0; x < NBRICKS_PER_ROW; ++x)
            for (int y = 0; y < NBRICKS_ROWS; ++y) {
                int bx = x * (BRICK_WIDTH + BRICK_SEP);
                int by = BRICK_Y_OFFSET + y * (BRICK_HEIGHT + BRICK_SEP);
                add(GameObjects.Bricks.setBrick(bx, by, y));
            }
    }

    public static int getNBRICKS_PER_ROW() {
        return NBRICKS_PER_ROW;
    }

    public static int getNBRICKS_ROWS() {
        return NBRICKS_ROWS;
    }

    public static int getBRICK_SEP() {
        return BRICK_SEP;
    }

    public static int getBRICK_WIDTH() {
        return BRICK_WIDTH;
    }

    public static int getBRICK_HEIGHT() {
        return BRICK_HEIGHT;
    }

    public static int getBRICK_Y_OFFSET() {
        return BRICK_Y_OFFSET;
    }

    public static int getBALL_RADIUS() {
        return BALL_RADIUS;
    }
}