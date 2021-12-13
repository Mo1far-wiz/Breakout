import acm.util.RandomGenerator;

public class Vars {
    public static RandomGenerator rg = new RandomGenerator();
    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 800;

    public static final int PADDLE_WIDTH = 100;
    public static final int PADDLE_HEIGHT = 10;

    public static final int NBRICKS_PER_ROW = 5;
    public static final int NBRICKS_ROWS = 5;

    public static final int BRICK_SEP = 10;

    public static final int BRICK_WIDTH =
            ((APPLICATION_WIDTH - 15) - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
    public static final int BRICK_HEIGHT = 8;

    public static final int BRICK_Y_OFFSET = 70;

    public static final int BALL_RADIUS = 10;

    public static double MouseX;
    public static double MouseY;

    public static boolean GameIsOver = false;
    public static boolean HasWon = true;
}
