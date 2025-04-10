package simStation;
import mvc.Command;
import mvc.Model;

public class PauseCommand extends Command{
    Agent agent;
    public PauseCommand(Model model, Agent a) {
        super(model);
        agent = a;
    }

    @Override
    public void execute() throws Exception {
        agent.pause();
    }
}
