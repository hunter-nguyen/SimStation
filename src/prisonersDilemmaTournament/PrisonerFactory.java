package prisonersDilemmaTournament;

import mvc.*;
import simStation.*;

public class PrisonerFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new PrisonerSimulation();
    }


    @Override
    public View makeView(Model model) {
        return new WorldView((World)model);
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        Command cmmd = null;
        if (cmmd == null) {
            switch (type) {
                case "Start":
                    cmmd = new StartCommand((World) model);
                    break;
                case "Suspend":
                    cmmd = new SuspendCommand((World) model);
                    break;
                case "Resume":
                    cmmd = new ResumeCommand((World) model);
                    break;
                case "Stop":
                    cmmd = new StopCommand((World) model);
                    break;
                case "Stats":
                    cmmd = new StatsCommand((World) model);
                    break;
                default:
                    break;
                }
            }
            return cmmd;
        }

        @Override
        public String getTitle() {
            return "Prisoner's Dilemma Simulation";
        }

        @Override
        public String[] getHelp() {
            return new String[] {
                "Start: Begin the simulation",
                "Suspend: Suspend the simulation",
                "Resume: Resume the simulation",
                "Stop: Stop the simulation",
                "Stats: Display statistics about prisoner strategies"
            };
        }

        @Override
        public String about() {
            return "Prisoner's Dilemma Simulation. CS 151 Spring 2025";
        }

}