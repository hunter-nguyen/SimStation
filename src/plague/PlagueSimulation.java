package plague;

import simStation.*;
import mvc.*;

public class PlagueSimulation extends World {
    public static int VIRULENCE = 50;  // % chance to infect
    public static int RESISTANCE = 2;  // % chance of resisting

    @Override
    public void populate() {
        for (int i = 0; i < 100; i++) {
            boolean infected = (i == 0); // only one infected at start
            addAgent(new Host(infected));
        }
    }

    @Override
    public String getStatus() {
        int infectedCount = 0;
        for (Agent a : agents) {
            if (a instanceof Host && ((Host) a).isInfected()) {
                infectedCount++;
            }
        }
        int total = agents.size();
        int percent = (int)(((double) infectedCount / total) * 100);
        return super.getStatus() + "\nInfected: " + percent + "%";
    }


    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new PlagueFactory());
        panel.display();
    }

}
