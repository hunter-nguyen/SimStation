package prisonersDilemmaTournament;
import mvc.*;

public class RandomlyCooperate extends Strategy {

    public boolean cooperate(){
        int rand = Utilities.rng.nextInt(2);
        return rand == 0;
    }
}