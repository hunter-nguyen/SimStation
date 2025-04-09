package simStation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class WorldFactory implements AppFactory {

    @Override
    public Model makeModel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeModel'");
    }

    @Override
    public View makeView(Model model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeView'");
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Start", "Pause", "Resume","Stop","Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        Command cmmd = null; //super.makeEditCommand(model, type, source);
        if (cmmd == null) {
            switch (type) {
            // cmmd = new StartCommand(model, null);
                case "Start":
                    break;
                case "Pause":
                    break;
                case "Resume":
                    break;
                case "Stop":
                    break;
                case "Stats":
                    break;
                default:
                    break;
            }
        }
        return cmmd;
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitle'");
    }

    @Override
    public String[] getHelp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHelp'");
    }

    @Override
    public String about() {
        return "SimStation version 1.0. Copyright 2025 by ASH";
    }

}
