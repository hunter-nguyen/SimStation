package prisonersDilemmaTournament;

import mvc.*;
import simStation.*;
import java.util.ArrayList;

public class PrisonerSimulation extends World {
    public PrisonerSimulation() {
        super();
        agents = new ArrayList<>();
    }

    @Override
    public void populate() {
        for (int i = 0; i < 40; i++) {
            int strategyType = i / 10;
            addAgent(createPrisoner(strategyType));
        }
    }

    public Prisoner createPrisoner(int strat) {
        Prisoner p = new Prisoner();
        switch (strat) {
            case 0:
                p.setStrategy(new Cheat());
                break;
            case 1:
                p.setStrategy(new Cooperate());
                break;
            case 2:
                p.setStrategy(new Tit4Tat());
                break;
            case 3:
                p.setStrategy(new RandomlyCooperate());
                break;
        }
        return p;
    }

    public String[] getStats() {
        String[] result = new String[4];
        int cheatCount = 0, cooperateCount = 0, randomCount = 0, tit4tatCount = 0;
        int cheatScore = 0, cooperateScore = 0, randomScore = 0, tit4tatScore = 0;
        for (Agent a : agents) {
            if (a instanceof Prisoner) {
                Prisoner p = (Prisoner) a;

                if (p.getStrategy() instanceof Cheat) {
                    cheatCount++;
                    cheatScore += p.getFitness();
                }
                else if (p.getStrategy() instanceof Cooperate) {
                    cooperateCount++;
                    cooperateScore += p.getFitness();
                }
                else if (p.getStrategy() instanceof RandomlyCooperate) {
                    randomCount++;
                    randomScore += p.getFitness();
                }
                else if (p.getStrategy() instanceof Tit4Tat) {
                    tit4tatCount++;
                    tit4tatScore += p.getFitness();
                }
            }
        }

        result[0] = "Average fitness for always cheat: " + ((double)cheatScore / cheatCount);
        result[1] = "Average fitness for always cooperate: " + ((double)cooperateScore / cooperateCount);
        result[2] = "Average fitness for randomly cooperate: " + ((double)randomScore / randomCount);
        result[3] = "Average fitness for copy opponent (tit-for-tat): " + ((double)tit4tatScore / tit4tatCount);
        return result;
    }

    public static void main(String[] args) {
        AppPanel panel = new AppPanel(new PrisonerFactory());
        panel.display();
    }
}