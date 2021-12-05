import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.*;
import acm.util.RandomGenerator;

public class physics extends GraphicsProgram
{
    private ball ball;

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

        public GOval getBallInstance()
        {
            return ballInstance;
        }

        public GLine dir;

        //public double getDirection() { return direction; }

        public void setDirection(double direction) { this.direction = direction; }

        public ball(double posX, double posY)
        {
            this.posX = posX;
            this.posY = posY;
            size = 20;
            ballInstance = new GOval(size, size);
            ballInstance.setFilled(true);
            ballInstance.setColor(Color.RED);
            ballInstance.setLocation(posX, posY);
            direction = 1;
            velocity = 5;

            dir = new GLine(posX, posY, 15*Math.cos(direction), 15*Math.sin(direction));
            dir.setColor(Color.BLACK);
        }

        public void move()
        {
            checkCollision();
            posX += Math.sin(direction * velocity);
            posY += Math.cos(direction * velocity);
            ballInstance.setLocation(posX, posY);
        }

        public void checkCollision()
        {
            if(posX <= 0 || posX + size >= 590 || posY <= 0 || posY + size >= 780)
            {
                direction += Math.PI/2;
            }
            drawDirection();
        }

        public void drawDirection()
        {
            dir.setStartPoint(posX, posY);

            double endY = posY + 25*Math.sin(direction);

            double endX = posX +  (endY < posY ? 25*Math.cos(-direction) : 25*Math.cos(direction));

            dir.setEndPoint(endX, endY);
        }

    }
}
