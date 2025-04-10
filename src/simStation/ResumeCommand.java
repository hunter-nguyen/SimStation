package simStation;
import mvc.Command;

public class ResumeCommand extends Command{
    static World world;
    public ResumeCommand(World w) {
        super(world);
        world = w;
    }

    @Override
    public void execute() throws Exception {
        world.resumeAgents();
    }
}
