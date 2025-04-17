package greed;
import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class SetMoveCommand extends Command{
    Integer value = null;

    public SetMoveCommand(Model m) {
        super(m);
    }

    public void execute() throws Exception {
        if (value == null) {
            String response = Utilities.ask("Set Move Energy = ");
            value = Integer.valueOf(response);
        }
        GreedSimulation.MOVE_ENERGY = value;
    }
}

