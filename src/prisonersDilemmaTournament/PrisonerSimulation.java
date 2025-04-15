package prisonersDilemmaTournament;

import simStation.*;

public class PrisonerSimulation extends World{
    public void populate() {
    for (int i = 0; i < 40; i++){
        Prisoner p = new Prisoner();
        if (i < 10) p.setStrategy(new Cheat());
        else if (i < 20) p.setStrategy(new Cooperate());
        else if (i < 30) p.setStrategy(new RandomlyCooperate());
        else p.setStrategy(new Tit4Tat());
        addAgent(p);
    }
}


    public String getStatus() {
        int cheaterAverage = 0;
        int cooperaterAverage = 0;
        int randomCooperaterAverage = 0;
        int tit4TaterAverage = 0;

        for (Agent a : agents) {
            if (a instanceof Prisoner) {
                Prisoner p = (Prisoner) a;
                if (p.getStrategy() instanceof Cheat) {
                    cheaterAverage += p.getFitness();
                }
                else if (p.getStrategy() instanceof Cooperate) {
                    cooperaterAverage += p.getFitness();
                }
                else if (p.getStrategy() instanceof RandomlyCooperate) {
                    randomCooperaterAverage += p.getFitness();
                }
                else if (p.getStrategy() instanceof Tit4Tat) {
                    tit4TaterAverage += p.getFitness();
                }
            }
        }
        cheaterAverage = cheaterAverage/10;
        cooperaterAverage =  cooperaterAverage/10;
        randomCooperaterAverage = randomCooperaterAverage/10;
        tit4TaterAverage = tit4TaterAverage/10;

        return String.format("Cheater Average Fitness %d\nCooperator Average Fitness %d\nRandom Cooperator Average Fitness %d\nTit4Tater Average Fitness %d", cheaterAverage, cooperaterAverage, randomCooperaterAverage, tit4TaterAverage);
    }
    
    public static void main(String[] args) {
        WorldPanel panel = new WorldPanel(new PrisonerFactory());
        panel.display();

    }
}
