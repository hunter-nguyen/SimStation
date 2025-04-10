package simStation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class WorldFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new World();
    }

    @Override
    public View makeView(Model model) {
        return new WorldView((World)w);
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
                    cmmd = new StartCommand((World) model, (Agent) source);
                    break;
                case "Pause":
                    cmmd = new PauseCommand((World) model, (Agent) source);
                    break;
                case "Resume":
                    cmmd = new ResumeCommand((World) model, (Agent) source);
                    break;
                case "Stop":
                    cmmd = new StopCommand((World) model, (Agent) source);
                    break;
                case "Stats":
                    cmmd = new StatsCommand((World) model, (Agent) source);
                    break;
                default:
                    break;
            }
        }
        return cmmd;
    }

    @Override
    public String getTitle() {
        return "SimStation";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Click Start to start all agents", "Click Pause to pause all agents",
        "Click Resume to resume all agents", "Click Stop to stop all agents",
        "Click Stats to see statistics on agents", "click SW to move South-West", };
    }

    @Override
    public String about() {
        return "SimStation version 1.0. Copyright 2025 by ASH";
    }

}
