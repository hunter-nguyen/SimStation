package plague;

import javax.swing.JSlider;
import mvc.*;
import simStation.*;

public class PlagueFactory extends WorldFactory {
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public View makeView(Model model) {
        return new PlagueView(model);
    }

    public String getTitle() {
        return "Plague Simulation";
    }
    
    public String[] getEditCommands() {
        return new String[] { "Start", "Pause", "Resume", "Stop", "Stats", "Initial % Infected", "Infection Probability","Initial Population Size", "Fatality/Recovery Time", "Not Fatal"};
    }

    public Command makeEditCommand(Model model, String type,  Object source) {
        Command cmmd = super.makeEditCommand(model, type, source);
        if (cmmd == null) {
            if (type.equals("Initial % Infected")) {
                cmmd = new InitialInfectedCommand(model);
                if (source instanceof JSlider) {
                    ((InitialInfectedCommand)cmmd).value = ((JSlider)source).getValue();
                }
            }

            else if (type.equals("Infection Probability")) {
                cmmd = new InfectionProbabilityCommand(model);
                if (source instanceof JSlider) {
                    ((InfectionProbabilityCommand)cmmd).value = ((JSlider)source).getValue();
                }
            }

            else if (type.equals("Initial Population Size")) {
                cmmd = new SetInitialPopCommand(model);
                if (source instanceof JSlider) {
                    ((SetInitialPopCommand)cmmd).value = ((JSlider)source).getValue();
                }
            } else if (type.equals("Fatality/Recovery Time")) {
                cmmd = new SetFatalityTime(model);
                if (source instanceof JSlider) {
                   ((SetFatalityTime)cmmd).value = ((JSlider)source).getValue();
                }
            }
            else if (type.equals("Not Fatal"))
                return new FatalCommand(model);
        }
        return cmmd;
    }
}
