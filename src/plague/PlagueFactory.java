package plague;

import mvc.*;
import simStation.*;

public class PlagueFactory extends WorldFactory {
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public View makeView(Model model) {
        return new PlagueView(model);
    }

    public String getTitle() {
        return "Plague Simulation";
    }
}
