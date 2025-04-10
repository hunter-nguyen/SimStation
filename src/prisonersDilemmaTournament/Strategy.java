package prisonersDilemmaTournament;

import java.io.Serializable;

public abstract class Strategy implements Serializable {
    protected Prisoner myPrisoner;
    public abstract boolean cooperate();

    protected void setPrisoner(Prisoner p){
        myPrisoner = p;
    }
}
