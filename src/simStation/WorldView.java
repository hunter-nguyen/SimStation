package simStation;

import mvc.Model;
import mvc.View;

import java.awt.*;

public class WorldView extends View {
    public WorldView(Model model) {
        super(model);
    }

    protected void drawAgent(Agent a, Graphics gc) {
        var oldColor = gc.getColor();
        gc.setColor(Color.red);
        gc.fillOval(a.xc, a.yc, 5, 5);
        gc.setColor(oldColor);
    }

    @Override
    protected void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        var oldColor = gc.getColor();
        gc.setColor(Color.blue);
        gc.drawRect(0, 0, World.SIZE, World.SIZE);
        gc.setColor(oldColor);

        var world = (World) model;
        for (var a : world.agents) drawAgent(a, gc);
    }
}
