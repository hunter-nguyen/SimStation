package greed;

import mvc.*;
import simStation.*;

public class GreedFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new Meadow();
    }

    @Override
    public View makeView(Model model) {
        return new GreedView((World) model);
    }

    @Override
    public String getTitle() {
        return "Greed Simulation";
    }
}
