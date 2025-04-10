package simStation;
import mvc.Command;

public class PauseCommand extends Command{
    static World world;
    public PauseCommand(World w) {
        super(world);
        world = w;
    }

    @Override
    public void execute() throws Exception {
        world.pauseAgents();
    }
}
