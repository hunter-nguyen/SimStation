package simStation;
import mvc.Command;


public class StartCommand extends Command{
    static World world;
    public StartCommand(World w) {
        super(world);
        world = w;
    }

    @Override
    public void execute() throws Exception {
        world.startAgents();
    }
}