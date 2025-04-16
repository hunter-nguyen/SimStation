package plague;


import mvc.*;
import simStation.*;

public class PlagueSimulation extends World {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    
    public void populate() {
        for(int i = 0; i < 50; i++)
            addAgent(new Person());
    }
        
    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new PlagueFactory());
        panel.display();
    }
}

class Person extends MobileAgent {

    public Person() {
        super();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);
    }

}


class PlagueFactory extends WorldFactory {
    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague";}
}

// public class RandomWalkSimulation extends World {

//     public void populate() {
//         for(int i = 0; i < 50; i++)
//             addAgent(new Drunk());
//     }

//     public static void main(String[] args) {
//         AppPanel panel = new WorldPanel(new RandomWalkFactory());
//         panel.display();
//     }

// }
