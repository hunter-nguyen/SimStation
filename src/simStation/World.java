package simStation;

import java.util.ArrayList;
import java.util.Iterator;
import mvc.*;

public class World extends Model {

    public static final int SIZE = 500;
    private int clock;
    private int alive;
    private ArrayList<Agent> agents;
    private ObserverAgent observer;

    public World() {
        this.clock = 0;
        this.alive = 0;
        this.agents = new ArrayList<>();
        this.observer = new ObserverAgent();
        addAgent(observer);
    }

    public void addAgent(Agent a) {
        // to be implemented
    }

    public void startAgents() {
        populate();
        for (Agent agent : agents) {
            agent.start();
        }
        changed();
    }

    public void stopAgents() {
        for (Agent agent : agents) {
            agent.stop();
        }
        changed();
    }

    public void pauseAgents() {
        for (Agent agent : agents) {
            agent.suspend();
        }
        changed();
    }

    public void resumeAgents() {
        for (Agent agent : agents) {
            agent.resume();
        }
        changed();
    }

    public void populate() {
        // To be implemented by subclasses
    }

    public String[] getStatus() {
        // to be implemented
    }

    public void updateStatistics() {
        clock++;
        alive = 0;
        // Count agents that aren't the observer and aren't stopped
        for (Agent agent : agents) {
            if (!(agent instanceof ObserverAgent)) {
                alive++;
            }
        }
        changed();
    }

    public Agent getNeighbor(Agent caller, int radius) {
        // to be implemented
    }
}
