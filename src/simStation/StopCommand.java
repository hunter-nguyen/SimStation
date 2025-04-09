package simStation;
import mvc.Command;
import mvc.Model;

public class StopCommand extends Command {
    Agent agent;
    public StopCommand(Model model, Agent a) {
        super(model);
        agent = a;
    }

    @Override
    public void execute() throws Exception {
        agent.stop();
    }
}