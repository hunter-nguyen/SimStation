package plague;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class SetFatalityTime extends Command{
    Integer value = null;

    public SetFatalityTime(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        if (value == null) {
            String response = Utilities.ask("Set Fatality/Recovery Time = ");
            value = Integer.valueOf(response);
        }
        PlagueSimulation.RECOVERY_TIME = value;
    }
}
