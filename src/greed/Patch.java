package greed;

import simStation.Agent;

public class Patch extends Agent {
    private int energy = 100;
    private int growBackRate = 1;
    private int patchSize = 10;

    public Patch() {
        super();
    }

    public int getEnergy() {
        return energy;
    }
    
    public void eatMe(Cow cow, int amt){
        if (energy >= amt) {
            energy -= amt;
            cow.gainEnergy(amt);
        }
    }

    @Override
    public void update(){
        energy = Math.min(100, energy + growBackRate);
    }

    @Override
    public String getStatus() {
        return "Patch: energy=" + energy;
    }

}
