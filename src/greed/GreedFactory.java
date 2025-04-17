package greed;

import javax.swing.JSlider;
import mvc.*;
import simStation.*;

public class GreedFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new Meadow();
    }

    @Override
    public View makeView(Model model) {
        return new GreedView((World) model);
    }

    @Override
    public String getTitle() {
        return "Greed Simulation";
    }

    public String[] getEditCommands() {
        return new String[] { "Start", "Pause", "Resume", "Stop", "Stats", "Greed", "Grow Back Rate", "Move Energy"};
    }

    public Command makeEditCommand(Model model, String type,  Object source) {
        Command cmmd = super.makeEditCommand(model, type, source);
        if (cmmd == null) {
            if (type.equals("Greed")) {
                cmmd = new SetGrowRateCommand(model);
                if (source instanceof JSlider) {
                    ((SetGrowRateCommand)cmmd).value = ((JSlider)source).getValue();
                }
            }

            else if (type.equals("Grow Back Rate")) {
                cmmd = new SetGrowRateCommand(model);
                if (source instanceof JSlider) {
                    ((SetGrowRateCommand)cmmd).value = ((JSlider)source).getValue();
                }
            }

            else if (type.equals("Move Energy")) {
                cmmd = new SetMoveCommand(model);
                if (source instanceof JSlider) {
                    ((SetMoveCommand)cmmd).value = ((JSlider)source).getValue();
                }
            } 
        }
        return cmmd;
    }
}
