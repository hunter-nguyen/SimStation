package simStation;
import mvc.Command;

public class StopCommand extends Command {
    static World world;
    public StopCommand(World w) {
        super(world);
        world = w;
    }

    @Override
    public void execute() throws Exception {
        world.stopAgents();
    }
}