package simStation;

import mvc.Command;
import mvc.Model;

public class StopCommand extends Command {
    private World world;

    public StopCommand(Model model) {
        super(model);
        this.world = (World) this.model;
    }

    @Override
    public void execute() throws Exception {
        world.stopAgents();
    }
}
