package greed;

import simStation.*;
import java.awt.*;

public class Cow extends MobileAgent {
    private int energy = 100;
    private int greediness = 25;

    @Override
    public void update(){
        if (energy <= 0) {
            setColor(Color.WHITE);
            stop();
            return;
        }

        Meadow meadow = (Meadow) getWorld();
        Patch patch = meadow.getPatch(getX(), getY());

        if (patch.getEnergy() >= greediness) {
            patch.eatMe(this, greediness);
        } else if (energy >= Meadow.moveEnergy) {
            move();
            energy -= Meadow.moveEnergy;
        } else {
            starve();
        }
    }

    public void gainEnergy(int amount) {
        energy = Math.min(100, energy + amount);
    }

    public void starve() {
        energy -= Meadow.waitPenalty;
    }
}
