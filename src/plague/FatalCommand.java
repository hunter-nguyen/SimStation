package plague;

import simStation.*;
import mvc.*;


public class FatalCommand extends Command{
    private final World world;
    public FatalCommand(World w) {
        super(w);
        this.world = w;
    }

    @Override
    public void execute() throws Exception {
        ((PlagueSimulation)model).isFatal = !((PlagueSimulation)model).isFatal;
    }
}
