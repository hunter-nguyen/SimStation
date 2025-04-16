package simStation;

import mvc.Command;
import mvc.Model;

public class SuspendCommand extends Command {
    private final World world;

    public SuspendCommand(Model model) {
        super(model);
        this.world = (World) model;
    }

    @Override
    public void execute() throws Exception {
        world.pauseAgents();
    }
}
