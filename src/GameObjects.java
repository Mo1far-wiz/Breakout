import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GRoundRect;

import java.awt.*;

public class GameObjects
{
    public static class ball
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

        public void setDirection(double direction)
        {
            this.direction = direction;
        }

        public ball(double posX, double posY, double size)
        {
            this.posX = posX;
            this.posY = posY;
            this.size = size;
            ballInstance = new GOval(size, size);
            ballInstance.setFilled(true);
            ballInstance.setColor(Color.WHITE);
            ballInstance.setLocation(posX, posY);
            direction = 1;
            velocity = 3;
        }

        public void move()
        {
            checkCollisions();
            posX += Math.sin(direction) * velocity;
            posY -= Math.cos(direction) * velocity;
            ballInstance.setLocation(posX, posY);
        }

        public void checkCollisions()
        {
            if (posX <= 0 || posX + size >= Vars.APPLICATION_WIDTH || posY <= 0 || posY + size >= Vars.APPLICATION_HEIGHT)
            {
                direction += Math.PI / 4;
            }
            // -------------------------------------
        }
    }

    public static class Bricks {
        public static GRoundRect setBrick(double x, double y, int nrow) {
            GRoundRect brick = new GRoundRect(Vars.BRICK_WIDTH, Vars.BRICK_HEIGHT);
            brick.setFilled(true);
            brick.setLocation(x, y);

            int color_rows = Vars.NBRICKS_ROWS / 5;
            nrow /= color_rows;

            if (nrow > 4)
                nrow -= 5;

            if (nrow == 0)
                brick.setColor(Color.decode("#d50000"));
            else if (nrow == 1)
                brick.setColor(Color.decode("#f57f17"));
            else if (nrow == 2)
                brick.setColor(Color.decode("#ffea00"));
            else if (nrow == 3)
                brick.setColor(Color.decode("#558b2f"));
            else if (nrow == 4)
                brick.setColor(Color.decode("#00b8d4"));
            return brick;
        }
    }

    public static class Platform{
        private GRect platformInstance;

        private double posX;
        private double posY;
        private double width;
        private double height;

        public GRect getPlatformInstance()
        {
            return platformInstance;
        }

        public Platform(double posX, double posY, double width, double height)
        {
            this.posX = posX;
            this.posY = posY;
            this.width = width;
            this.height = height;

            platformInstance = new GRect(posX, posY, width, height);

            platformInstance.setFilled(true);
            platformInstance.setColor(Color.WHITE);
        }

        public void move()
        {
            //checkCollisions();
            double trgX = Vars.MouseX - width/2;
            double angle = Math.atan((70) / (trgX - this.posX));

            if(trgX >= posX)
                posX += Math.cos(angle) * 3;
            else
                posX -= Math.cos(angle) * 3;

            platformInstance.setLocation(posX, posY);
        }
    }
}
