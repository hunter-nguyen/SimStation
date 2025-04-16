package greed;

import simStation.*;

public class Cow extends MobileAgent {
    private int energy = 100;
    private int greediness = 25;

    public Cow() {
        super();
    }

    public int getEnergy() {
        return energy;
    }

    public void increaseEnergy(int amt) {
        energy = Math.min(100, energy + amt);
    }

    @Override
    public void update() {
        if (energy <= 0) {
            stop();
            return;
        }

        Meadow meadow = (Meadow) world;
        Patch patch = meadow.getPatch(xc, yc);

        if (patch != null && patch.getEnergy() >= greediness) {
            patch.eatMe(this, greediness);
        } else if (energy >= meadow.moveEnergy) {
            energy -= meadow.moveEnergy;
            heading = Heading.random();
            move(1);
        } else {
            energy -= meadow.waitPenalty;
        }

        if (energy <= 0) stop();
    }

    @Override
    protected String getStatus() {
        return "Cow: energy=" + energy;
    }
}
