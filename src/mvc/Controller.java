package mvc;

public class Controller {
    protected Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public Command makeCommand(String type) {
        return null;
    }
}