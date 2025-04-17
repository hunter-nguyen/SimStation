package plague;

import mvc.*;
import simStation.*;


public class FatalCommand extends Command{
    private final World world;
    public FatalCommand(Model model) {
        super(model);
        this.world = (World) model;
    }

    @Override
    public void execute() throws Exception {
        PlagueSimulation.isFatal = !PlagueSimulation.isFatal;
    }
}
