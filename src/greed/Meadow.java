package greed;

import simStation.*;
import java.util.*;

public class Meadow extends World {
    private int waitPenalty = 5;
    private int moveEnergy = 10;
    private int numCows = 50;
    private static final int patchSize = 10;
    private static final int dim = SIZE / patchSize;

    private Patch [][] patches = new Patch[dim][dim];

    public Meadow(int size, int patchSize){
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                patches[i][j] = new Patch();
            }
        }
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

    public void populate() {
        for (int i = 0; i < numCows; i++) {
            Cow cow = new Cow();
            addAgent(cow);
        }
    }

    public void updateStatistics() {
        super.updateStatistics();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                patches[i][j].update();
            }
        }
    }

}
