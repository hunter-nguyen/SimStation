package simStation;
import mvc.Command;


public class StartCommand extends Command{
    Agent agent;
    public StartCommand(World world, Agent a) {
        super(world);
        agent = a;
    }

    @Override
    public void execute() throws Exception {
        agent.start();
    }
}