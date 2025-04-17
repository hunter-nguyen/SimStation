package plague;

import simStation.*;
import mvc.*;

import java.awt.*;

public class Host extends MobileAgent {
    private boolean infected;
    private int infectionStartTime = -1;

    public Host(boolean infected) {
        super();
        this.infected = infected;
    }

    @Override
    public void update() {
        if (!infected) {
            Agent neighbor = world.getNeighbor(this, 10);
            if (neighbor instanceof Host && ((Host) neighbor).isInfected()) {
                int chance = Utilities.rng.nextInt(100);
                if (chance < PlagueSimulation.VIRULENCE) {
                    int resistance = Utilities.rng.nextInt(100);
                    // if (resistance > PlagueSimulation.RESISTANCE) {
                    //     infected = true;
                    // }
                    infectionStartTime = world.clock;
                    infected = true;
                }
            }
        }
        if (infected && infectionStartTime!= -1 && world.clock-infectionStartTime>=PlagueSimulation.RECOVERY_TIME)
        {
            if (PlagueSimulation.isFatal)
            {
                stop();
            }
            else{
                infected = false;
            }
            infectionStartTime = -1;
        }
        move(1);
    }

    public boolean isInfected() {
        return infected;
    }

    @Override
    protected String getStatus() {
        return infected ? "infected" : "healthy";
    }
}
