package greed;

import simStation.Agent;

public class Patch extends Agent {
    private int energy = 100;
    private int growBackRate = 1;
    public static int patchSize = 10;

    public Patch() {
        super();
    }

    public synchronized int getEnergy() {
        return energy;
    }

    public synchronized void eatMe(Cow cow, int amt) {
        while (energy < amt) {
            try {
                wait();
                cow.increaseEnergy(-((Meadow) world).waitPenalty);

                if (cow.getEnergy() <= 0) {
                    cow.stop();
                    return;
                }
            } catch (InterruptedException e) {
                return;
            }
        }

        energy -= amt;
        cow.increaseEnergy(amt);
    }

    @Override
    public synchronized void update() {
        energy = Math.min(100, energy + growBackRate);
        notifyAll();
    }

    @Override
    public String toString() {
        return "Patch: energy=" + energy;
    }
}
