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
        int rows = dim;
        int cols = dim;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Patch patch = new Patch();
                patches[row][col] = patch;
                int x = col * Patch.patchSize;
                int y = row * Patch.patchSize;
                patch.setX(x);
                patch.setY(y);
                patch.lockPosition();
                addAgent(patch);
            }
        }

        // Add cows randomly across the grid
        for (int i = 0; i < 50; i++) {
            addAgent(new Cow());
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
