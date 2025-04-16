package greed;

import mvc.AppPanel;

public class GreedSimulation {
    public static int GREEDINESS = 10;
    public static int MOVE_ENERGY = 2;
    public static int GROW_BACK_RATE = 1;

    public static void main(String[] args) {
        AppPanel panel = new GreedPanel(new GreedFactory());
        panel.display();
    }
}
