package simStation;
import mvc.Command;

public class ResumeCommand extends Command{
    private final World world;
    public ResumeCommand(World w) {
        super(w);
        this.world = w;
    }

    @Override
    public void execute() throws Exception {
        world.resumeAgents();
    }
}
