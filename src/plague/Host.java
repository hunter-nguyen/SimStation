package plague;

import simStation.*;
import mvc.*;

import java.awt.*;

public class Host extends MobileAgent {
    private boolean infected;

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
                    if (resistance > PlagueSimulation.RESISTANCE) {
                        infected = true;
                    }
                }
            }
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
