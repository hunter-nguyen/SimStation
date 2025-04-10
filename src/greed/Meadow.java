package greed;

public class Meadow {
    private int waitPenalty = 5;
    private int moveEnergy = 10;
    private int numCows = 50;
    private int dim = 20;

    Patch [][] patches;

    public Meadow(int size, int patchSize){
        dim = size/patchSize;
        patches = new Patch[dim][dim];
    }

    public Patch getPatch(int xc, int yc){
        return patches[xc/dim][yc/dim];
    }

    public int getWaitPenalty() {
        return waitPenalty;
    }

    public void setWaitPenalty(int waitPenalty) {
        this.waitPenalty = waitPenalty;
    }

    public int getMoveEnergy() {
        return moveEnergy;
    }

    public void setMoveEnergy(int moveEnergy) {
        this.moveEnergy = moveEnergy;
    }

    public int getNumCows() {
        return numCows;
    }

    public void setNumCows(int numCows) {
        this.numCows = numCows;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

}
