import acm.program.GraphicsProgram;

import java.awt.*;

public class main extends GraphicsProgram {

    private physics physics = new physics();

    public void run() {
        this.setSize(Vars.APPLICATION_WIDTH, Vars.APPLICATION_HEIGHT);
        this.setBackground(Color.decode("#263238"));
        drawBricks();
    }

    public static void main(String[] args) {
        new main().start(args);
    }

    public void drawBricks() {
        for (int x = 0; x < Vars.NBRICKS_PER_ROW; ++x)
            for (int y = 0; y < Vars.NBRICKS_ROWS; ++y) {
                int bx = x * (Vars.BRICK_WIDTH + Vars.BRICK_SEP);
                int by = Vars.BRICK_Y_OFFSET + y * (Vars.BRICK_HEIGHT + Vars.BRICK_SEP);
                add(GameObjects.Bricks.setBrick(bx, by, y));
            }
    }
}