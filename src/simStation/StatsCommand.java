package simStation;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;
public class StatsCommand extends Command {
    private final World world;

    public StatsCommand(Model model) {
        super(model);
        this.world = (World) model;
    }

    @Override
    public void execute() throws Exception {
        Utilities.inform(world.getStatus());
    }
}