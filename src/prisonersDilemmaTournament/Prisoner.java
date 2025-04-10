package prisonersDilemmaTournament;

import simStation.Agent;

public class Prisoner extends Agent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    private Strategy strategy;

    public Prisoner(Strategy strategy) {
        super();
        this.strategy = strategy;
        strategy.setPrisoner(this);
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    public void update() {
        Prisoner partner = (Prisoner)world.getNeighbor(this);
        if (partner != null) {
            boolean iCooperate = cooperate();
            boolean partnerCooperates = partner.cooperate();

            // Update partner's knowledge about my behavior
            partner.setPartnerCheated(!iCooperate);
            // Update my knowledge about partner's behavior
            this.partnerCheated = !partnerCooperates;

            // Update fitness based on the game outcome
            if (iCooperate && partnerCooperates) {
                // Both cooperate: 3, 3
                updateFitness(3);
                partner.updateFitness(3);
            } else if (iCooperate && !partnerCooperates) {
                // I cooperate, partner cheats: 0, 5
                updateFitness(0);
                partner.updateFitness(5);
            } else if (!iCooperate && partnerCooperates) {
                // I cheat, partner cooperates: 5, 0
                updateFitness(5);
                partner.updateFitness(0);
            } else {
                // Both cheat: 1, 1
                updateFitness(1);
                partner.updateFitness(1);
            }
        }
    }

    public void updateFitness(int amt) {
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
}
