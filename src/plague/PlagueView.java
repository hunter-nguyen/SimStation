package plague;

import simStation.*;
import java.awt.*;
import mvc.Model;

public class PlagueView extends WorldView {
    public PlagueView(Model model) {
        super(model);
    }

    @Override
    protected void drawAgent(Agent a, Graphics gc) {
        Color old = gc.getColor();

        if (a instanceof Host) {
            if (((Host) a).isInfected()) {
                gc.setColor(Color.RED);
            } else {
                gc.setColor(Color.GREEN);
            }
        } else {
            gc.setColor(Color.GRAY);
        }

        gc.fillOval(a.getX(), a.getY(), 5, 5);
        gc.setColor(old);
    }
}
