import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.*;
import acm.util.RandomGenerator;


/*
public class physics extends GraphicsProgram
{
    private ball ball;

    private RandomGenerator rg = new RandomGenerator();

    public void createBall(double posX, double posY)
    {
        this.ball = new ball(posX, posY);
    }

    public ball getBall()
    {
        return ball;
    }


    public class ball
    {
        private double posX;

        private double posY;

        private double size;

        private double direction;

        private double velocity;

        private GOval ballInstance;

        public GOval getBallInstance() { return ballInstance; }

        public void setDirection(double direction) { this.direction = direction; }

        public GRect r;

        public ball(double posX, double posY)
        {
            this.posX = posX;
            this.posY = posY;
            size = 10;
            ballInstance = new GOval(size, size);
            ballInstance.setFilled(true);
            ballInstance.setColor(Color.WHITE);
            ballInstance.setLocation(posX, posY);
            temp.setColor(Color.YELLOW);
            direction = 1;
            velocity = 6;

            r = new GRect(0, 0, 200, 200);
            r.setFilled(true);
            r.setColor(Color.ORANGE);


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
            // screen borders
            if(posX <= 0 || posX + size >= 590 || posY <= 0 || posY + size >= 780)
            {
                direction += Math.PI/4;
            }

            //
            GObject elCollided = getElementAt(posX + 3*Math.sin(direction) * velocity, posY - 3*Math.cos(direction) * velocity);
            temp.setLocation(posX + 3*Math.sin(direction) * velocity, posY - 3*Math.cos(direction) * velocity);

            if(elCollided != null)
                remove(elCollided);
                //direction += Math.PI/4;
        }
    }
}
*/
