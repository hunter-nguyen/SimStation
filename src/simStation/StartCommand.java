package simStation;
import mvc.Command;
import mvc.Model;


public class StartCommand extends Command{
    Agent agent;
    public StartCommand(Model model, Agent a) {
        super(model);
        agent = a;
    }

    @Override
    public void execute() throws Exception {
        agent.start();
    }
}