package greed;

import simStation.Agent;
import java.awt.*;

public class Patch extends Agent {
    private int energy = 100;
    private int growBackRate = 1;
    public static int patchSize = 25;

    private boolean positionLocked = false;

    public Patch() {
        super();
    }

    @Override
    public void setX(int x) {
        if (!positionLocked) {
            super.setX(x);
        }
    }

    @Override
    public void setY(int y) {
        if (!positionLocked) {
            super.setY(y);
        }
    }

    public void lockPosition() {
        positionLocked = true;
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


    public void draw(Graphics g) {
        Color color;
        if (energy > 70) color = new Color(144, 238, 144); // forest green
        else if (energy > 40) color = Color.GREEN;
        else if (energy > 10) color = new Color(33, 139, 34); // light green
        else color = Color.BLACK;

        g.setColor(color);
        g.fillRect(getX(), getY(), patchSize, patchSize);
    }


}
