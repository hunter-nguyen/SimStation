package greed;
import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class SetGreedCommand extends Command{
    Integer value = null;

    public SetGreedCommand(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        if (value == null) {
            String response = Utilities.ask("Greed = ");
            value = Integer.valueOf(response);
        }
        GreedSimulation.GREEDINESS = value;
    }
}

