package simStation;

public class ObserverAgent extends Agent {
    public ObserverAgent() {
        super();
    }

    @Override
    public void update() {
        if (world != null) {
            world.updateStatistics();
        }
    }
}