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

    //private physics physics = new physics();
    //private DrawGraphics bricks = new DrawGraphics();
    private RandomGenerator rg = new RandomGenerator();

    public void run()
    {
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

        this.setBackground(Color.decode("#263238"));
        drawBricks();

        //physics.createBall(300, 600);
        ball ball = new ball(300, 600);

        add(ball.getBallInstance());
        add(ball.temp);

        ball.setDirection(rg.nextDouble(0.1,2*Math.PI));

        while(true)
        {
            ball.checkCollision();
            ball.move();
            pause(10);
        }
    }

    public class ball
    {
        private double posX;
        private double posY;

        private double stX;
        private double stY;

        private double size;

        private double direction;

        private double velocity;

        private GOval ballInstance;

        public GOval getBallInstance() { return ballInstance; }

        public void setDirection(double direction) { this.direction = direction; }

        public ball(double posX, double posY)
        {
            this.posX = posX;
            this.posY = posY;
            size = 10;
            direction = 1;
            velocity = 6;
            ballInstance = new GOval(size, size);
            ballInstance.setFilled(true);
            ballInstance.setColor(Color.WHITE);
            ballInstance.setLocation(posX, posY);
            temp.setVisible(false);
            stX = posX;
            stY = posY;
        }

        public void move()
        {
            posX += Math.sin(direction) * velocity;
            posY -= Math.cos(direction) * velocity;
            ballInstance.setLocation(posX, posY);
        }

        public GOval temp = new GOval(10, 10);

        public void checkCollision()
        {
            temp.setLocation(posX + 2*Math.sin(direction) * velocity, posY - 2*Math.cos(direction) * velocity);

            // screen borders
            if(temp.getX() <= 0 || temp.getX() + size >= 590 || temp.getY() <= 0 || temp.getY() + size >= 780)
            {
                direction += Math.PI/4;
            }

            // collision with brick
            GObject elCollided = getElementAt(temp.getX(), temp.getY());
            if(elCollided != null)
            {
                remove(elCollided);
                direction += Math.PI/4;
            }
        }
    }

    public void drawBricks() {

        for (int x = 0; x < NBRICKS_PER_ROW; ++x)
            for (int y = 0; y < NBRICKS_ROWS; ++y) {
                int bx = x * (BRICK_WIDTH + BRICK_SEP);
                int by = BRICK_Y_OFFSET + y * (BRICK_HEIGHT + BRICK_SEP);
                add(setBrick(bx, by, y));
            }
    }

    public GRect setBrick(double x, double y, int nrow){
        GRect brick = new GRect(getBRICK_WIDTH(), getBRICK_HEIGHT());
        nrow /= 2;
        brick.setFilled(true);
        brick.setLocation(x, y);
        if(nrow == 0)
            brick.setColor(Color.decode("#d50000"));
        else if(nrow == 1)
            brick.setColor(Color.decode("#f57f17"));
        else if(nrow == 2)
            brick.setColor(Color.decode("#ffea00"));
        else if(nrow == 3)
            brick.setColor(Color.decode("#558b2f"));
        else if(nrow == 4)
            brick.setColor(Color.decode("#00b8d4"));
        return brick;
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