import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.*;
import acm.util.RandomGenerator;

public class physics
{
    public class ball
    {
        private double posX;
        private double posY;

        private GOval ballInstance;

        public ball(double posX, double posY)
        {
            this.posX = posX;
            this.posY = posY;
            ballInstance = new GOval(20, 20, posX, posY);
        }


    }
}
