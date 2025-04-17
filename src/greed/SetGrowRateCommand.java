package greed;
import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class SetGrowRateCommand extends Command{
    Integer value = null;

    public SetGrowRateCommand(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        if (value == null) {
            String response = Utilities.ask("Grow Rate = ");
            value = Integer.valueOf(response);
        }
        GreedSimulation.GROW_BACK_RATE = value;
    }
}

