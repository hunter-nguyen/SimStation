package greed;

import simStation.*;

public class Meadow extends World {
    public int waitPenalty = 5;
    public int moveEnergy = 10;
    public int numCows = 50;
    public int dim = SIZE / Patch.patchSize;

    private Patch [][] patches = new Patch[dim][dim];

    @Override
    public void populate() {
        // Create grid of patches
        for (int x = 0; x < dim; x++) {
            for (int y = 0; y < dim; y++) {
                Patch patch = new Patch();
                patch.setX(x * Patch.patchSize);
                patch.setY(y * Patch.patchSize);
                patches[x][y] = patch;
                addAgent(patch);
            }
        }

        // Add cows
        for (int i = 0; i < numCows; i++) {
            Cow cow = new Cow();
            addAgent(cow);
        }
    }

    public Patch getPatch(int xc, int yc) {
        int x = xc / Patch.patchSize;
        int y = yc / Patch.patchSize;
        if (x >= 0 && x < dim && y >= 0 && y < dim)
            return patches[x][y];
        return null;
    }

    @Override
    public String getStatus() {
        alive = 0;
        for (Agent a : agents) if (a instanceof Cow cow && cow.getEnergy() > 0) alive++;

        return String.format("#cows = %d\n#living = %d\n#clock = %d", numCows, alive, clock);
    }

}
