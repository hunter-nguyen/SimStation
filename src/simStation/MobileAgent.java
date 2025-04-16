package simStation;

public abstract class MobileAgent extends Agent {
    public Heading heading;

    public MobileAgent() {
        super();
        this.heading = Heading.random();
    }

    public Heading getHeading() {
        return heading;
    }

    public void move(int steps) {
        for (int i = 0; i < steps; i++) {
            switch (heading) {
                case NORTH:
                    yc--;
                    break;
                case SOUTH:
                    yc++;
                    break;
                case EAST:
                    xc++;
                    break;
                case WEST:
                    xc--;
                    break;
            }

            // Wrap around world borders
            if (xc < 0)
                xc = World.SIZE - 1;
            if (xc >= World.SIZE)
                xc = 0;
            if (yc < 0)
                yc = World.SIZE - 1;
            if (yc >= World.SIZE)
                yc = 0;

            // Notify world of change after each step
            if (world != null) {
                world.changed();
            }
        }
    }

    public void turn(Heading newHeading) {
        this.heading = newHeading;
    }
}