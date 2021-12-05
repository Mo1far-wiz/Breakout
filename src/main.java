import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.*;
import acm.util.RandomGenerator;

public class main extends GraphicsProgram
{
    private physics physics = new physics();
    private RandomGenerator rg = new RandomGenerator();

    public void run()
    {
        this.setSize(600, 800);

        physics.createBall(200, 200);
        physics.ball ball = physics.getBall();

        add(ball.getBallInstance());
        add(ball.dir);

        ball.setDirection(rg.nextDouble(0.1,2*Math.PI));

        while(true)
        {
            ball.move();
            pause(5);
        }
    }
}