package prisonersDilemmaTournament;

public class Tit4Tat extends Strategy {

    @Override
    public boolean cooperate() {
        return !myPrisoner.getPartnerCheated();
    }
}