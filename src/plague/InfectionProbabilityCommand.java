package plague;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class InfectionProbabilityCommand extends Command{
    Integer value = null;

    public InfectionProbabilityCommand(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        if (value == null) {
            String response = Utilities.ask("Infection Probability = ");
            value = Integer.valueOf(response);
        }
        PlagueSimulation.VIRULENCE = value;
    }
}