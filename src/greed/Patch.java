package greed;

import simStation.Agent;

public class Patch extends Agent {
    private int energy = 100;
    private int growBackRate = 1;
    private int patchSize = 10;


    public void eatMe (Cow cow, int amt){

    }

    public void update(){

    }

    public int getGrowBackRate() {
        return growBackRate;
    }

    public void setGrowBackRate(int growBackRate) {
        this.growBackRate = growBackRate;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getPatchSize() {
        return patchSize;
    }

    public void setPatchSize(int patchSize) {
        this.patchSize = patchSize;
    }

    
}
