package simStation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import mvc.*;

abstract class World extends Model {

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
        a.setX((int)(Math.random() * SIZE));
        a.setY((int)(Math.random() * SIZE));
        a.setWorld(this);
        agents.add(a);
    }

    public void startAgents() throws Exception {
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

    abstract void populate();

    public String[] getStatus() {
        // TODO: to be implemented
        String [] status = new String [agents.size()];
        int statusCounter = 0;
        for (Agent a: agents){
            status[statusCounter] = a.getStatus();
            statusCounter++;
        }
        return status;
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
        ArrayList<Agent> neighbors = new ArrayList<>();
        for (Agent agent : agents) {
            if (agent != caller && !(agent instanceof ObserverAgent)) {
                int dx = agent.getX() - caller.getX();
                int dy = agent.getY() - caller.getY();
                double distance = Math.sqrt(dx * dx + dy * dy);
                if (distance <= radius) {
                    neighbors.add(agent);
                }
            }
        }
        if (neighbors.size() == 0) return null;
        Random rand = new Random();
        return neighbors.get(rand.nextInt(neighbors.size()));
    }
}
