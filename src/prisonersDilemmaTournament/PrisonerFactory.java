package prisonersDilemmaTournament;

import mvc.*;
import simStation.*;

public class PrisonerFactory extends WorldFactory {

    @Override
    public Model makeModel() {
        return new PrisonerSimulation();
    }

    @Override
    public String[] getEditCommands() {
        return new String[] { "Start", "Suspend", "Resume", "Stop", "Stats" };
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == null)
            return null;

        World world = (World) model;
        switch (type) {
            case "Start":
                return new StartCommand(world);
            case "Suspend":
                return new SuspendCommand(world);
            case "Resume":
                return new ResumeCommand(world);
            case "Stop":
                return new StopCommand(world);
            case "Stats":
                return new StatsCommand(world);
            default:
                return null;
        }
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