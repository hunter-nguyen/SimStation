package prisonersDilemmaTournament;

import simStation.Agent;

public class Prisoner extends Agent{
    protected int fitness = 0;
    protected boolean cheated;

    public boolean cooperate(){
        // return cooperate();
        return false;
    }
    public void update(){

    }
    public void updateFitness(int amt){
        fitness += amt;
    }

}

