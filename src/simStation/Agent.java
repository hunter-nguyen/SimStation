package simStation;

import java.io.Serializable;
import java.util.Random;

public abstract class Agent implements Serializable, Runnable {
    protected int xc;
    protected int yc;
    protected boolean suspended;
    protected boolean stopped;
    protected World world;
    transient protected Thread myThread;
    protected String agentName;

    private static final Random RANDOM = new Random();

    public Agent() {
        this.xc = RANDOM.nextInt(World.SIZE);
        this.yc = RANDOM.nextInt(World.SIZE);
        this.suspended = false;
        this.stopped = false;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public int getX() {
        return xc;
    }

    public int getY() {
        return yc;
    }

    public void setX(int xc) {
        this.xc = xc;
    }

    public void setY(int yc) {
        this.yc = yc;
    }

    public void start() {
        myThread = new Thread(this::run);
        myThread.start();
    }

    public void run() {
        onStart();
        while (!stopped) {
            try {
                if (!suspended) {
                    update();
                    Thread.sleep(20); // smooth animation
                } else {
                    Thread.sleep(100); // reduce CPU usage while suspended
                }
            } catch (InterruptedException e) {
                onInterrupted();
            }
        }
        onExit();
    }

    // Empty methods that can be overridden in subclasses
    protected void onStart() {
    }

    protected void onInterrupted() {
    }

    protected void onExit() {
    }

    public abstract void update();

    public void suspend() {
        suspended = true;
    }

    public void pause() { //to be same as implementation
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        stopped = true;
        if (myThread != null) {
            myThread.interrupt();
        }
    }
}
