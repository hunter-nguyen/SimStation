package plague;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class SetInitialPopCommand extends Command{
    Integer value = null;

    public SetInitialPopCommand(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        if (value == null) {
            String response = Utilities.ask("Initial population size = ");
            value = Integer.valueOf(response);
        }
        PlagueSimulation.INITIAL_POPULATION_SIZE = value;
    }
}
