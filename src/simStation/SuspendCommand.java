package simStation;
import mvc.Command;
import mvc.Model;

public class SuspendCommand extends Command{
    Agent agent;
    public SuspendCommand(Model model, Agent a) {
        super(model);
        agent = a;
    }

    @Override
    public void execute() throws Exception {
        agent.suspend();
    }
}
