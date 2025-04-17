package plague;

import mvc.*;
import simStation.*;

public class PlagueSimulation extends World {
    public static int VIRULENCE = 50;  // % chance to infect
    // public static int RESISTANCE = 2;  // % chance of resisting
    public static int INITIAL_INFECTED = 1;  // Initial percentage of individuals infected 

    public static int INITIAL_POPULATION_SIZE = 100;
    public static int RECOVERY_TIME = 200;

    public static boolean isFatal = true;

    @Override
    public void populate() {
        for (int i = 0; i < INITIAL_POPULATION_SIZE; i++) {
            boolean infected = (i < ((INITIAL_INFECTED*100)/INITIAL_POPULATION_SIZE)); // only one infected at start
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
        double percent = (double)((int)(((double) infectedCount / total) * 10001)/100);
        String toRet = "#agents = "+ (total-1)+"\nclock = "+clock+"\n% infected = "+percent;
        return toRet;
        // return super.getStatus() + "\nInfected: " + percent + "%";
    }


    public static void main(String[] args) {
        // AppPanel panel = new WorldPanel(new PlagueFactory());
        AppPanel panel = new PlaguePanel(new PlagueFactory());
        panel.display();
    }

}
