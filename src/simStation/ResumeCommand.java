package simStation;
import mvc.Command;
import mvc.Model;

public class ResumeCommand extends Command{
    Agent agent;
    public ResumeCommand(Model model, Agent a) {
        super(model);
        agent = a;
    }

    @Override
    public void execute() throws Exception {
        agent.resume();
    }
}
