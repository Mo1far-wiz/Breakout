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

    public GOval getBall()
    {
        return ball.getBallInstance();
    }


    private class ball
    {
        private double posX;
        private double posY;

        private GOval ballInstance;

        private GOval getBallInstance()
        {
            return ballInstance;
        }

        public ball(double posX, double posY)
        {
            this.posX = posX;
            this.posY = posY;
            ballInstance = new GOval(20, 20);
            ballInstance.setFilled(true);
            ballInstance.setColor(Color.RED);
            ballInstance.setLocation(posX, posY);
        }
    }
}
