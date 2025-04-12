package simStation;
import mvc.Command;
import mvc.Model;

public class SuspendCommand extends Command{
    Agent agent;
    public SuspendCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        agent.suspend();
    }
}
