package greed;

import simStation.*;

import java.awt.*;

public class GreedView extends WorldView {
    public GreedView(World model) {
        super(model);
    }

    @Override
    protected void drawAgent(Agent a, Graphics gc) {
        if (a instanceof Patch) {
            ((Patch) a).draw(gc);  // use the patch's custom draw method
        } else if (a instanceof Cow) {
            Cow cow = (Cow) a;
            int energy = cow.getEnergy();
            Color color;
            if (energy <= 0) color = Color.WHITE;
            else if (energy < 30) color = Color.ORANGE;
            else color = Color.GREEN;
            gc.setColor(color);
            gc.fillOval(cow.getX(), cow.getY(), 5, 5);
        }
    }

}
