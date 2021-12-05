import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.*;
import acm.util.RandomGenerator;

public class main extends GraphicsProgram
{
    private physics physics = new physics();

    public void run()
    {
        this.setSize(600, 800);

        physics.createBall(200, 200);
    }
}