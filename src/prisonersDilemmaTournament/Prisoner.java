package prisonersDilemmaTournament;

import simStation.*;
import mvc.*;

public class Prisoner extends MobileAgent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    private Strategy strategy;
    private static final double NEIGHBOR_RADIUS = 10.0;
    private int heading = 0;

    public Prisoner() {
        super();
        heading = Utilities.rng.nextInt(4) * 90;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
        strategy.setPrisoner(this);
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    @Override
    public void update() {
        heading = Utilities.rng.nextInt(4) * 90;

        int steps = Utilities.rng.nextInt(10) + 1;
        int dx = (int) (steps * Math.cos(Math.toRadians(heading)));
        int dy = (int) (steps * Math.sin(Math.toRadians(heading)));

        int newX = Math.min(Math.max(0, xc + dx), World.SIZE - 1);
        int newY = Math.min(Math.max(0, yc + dy), World.SIZE - 1);
        xc = newX;
        yc = newY;

        Agent neighbor = world.getNeighbor(this, NEIGHBOR_RADIUS);
        if (neighbor instanceof Prisoner) {
            Prisoner partner = (Prisoner) neighbor;
            boolean iCooperate = cooperate();
            boolean partnerCooperates = partner.cooperate();

            partner.setPartnerCheated(!iCooperate);
            this.partnerCheated = !partnerCooperates;

            if (iCooperate && partnerCooperates) {
                updateFitness(3);
                partner.updateFitness(3);
            } else if (iCooperate && !partnerCooperates) {
                updateFitness(0);
                partner.updateFitness(5);
            } else if (!iCooperate && partnerCooperates) {
                updateFitness(5);
                partner.updateFitness(0);
            } else {
                updateFitness(1);
                partner.updateFitness(1);
            }
        }
    }

    private void updateFitness(int amt) {
        fitness += amt;
    }

    public int getFitness() {
        return fitness;
    }

    public boolean getPartnerCheated() {
        return partnerCheated;
    }

    public void setPartnerCheated(boolean cheated) {
        this.partnerCheated = cheated;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public String getStatus() {
        if (strategy != null) {
            String strategyName = strategy.getClass().getSimpleName();
            return String.format("%s: fitness=%d, position=(%d,%d)",
                    strategyName, fitness, xc, yc);
        }
        return "No strategy assigned";
    }
}