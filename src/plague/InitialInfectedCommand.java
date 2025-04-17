package plague;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class InitialInfectedCommand extends Command{
    Integer value = null;

    public InitialInfectedCommand(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        if (value == null) {
            String response = Utilities.ask("Initial % Infected = ");
            value = Integer.valueOf(response);
        }
        PlagueSimulation.INITIAL_INFECTED = value;
    }
}
