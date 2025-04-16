package mvc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppPanel extends JPanel implements Subscriber, ActionListener  {

    protected Model model;
    protected AppFactory factory;
    protected View view;
    protected JPanel controlPanel;
    private JFrame frame;
    public static int FRAME_WIDTH = 1000;
    public static int FRAME_HEIGHT = 600;

    public AppPanel(AppFactory factory) {

        // initialize fields here
        this.factory = factory;
        this.model = factory.makeModel();
        this.controlPanel = new JPanel();
        this.view = factory.makeView(model);

        this.setLayout(new GridLayout(1, 2));

        this.add(controlPanel);
        this.add(view);

        frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        model.subscribe(this);
    }

    public void display() { frame.setVisible(true); }

    public void update() {  /* override in extensions if needed */ }

    public Model getModel() { return model; }

    // called by file/open and file/new
    public void setModel(Model newModel) {
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);
        // view must also unsubscribe then resubscribe:
        view.setModel(this.model);
        model.changed();
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        // add file, edit, and help menus
        JMenu fileMenu =
                Utilities.makeMenu("File", new String[] {"New",  "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);

        JMenu editMenu =
                Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);

        JMenu helpMenu =
                Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
        result.add(helpMenu);

        return result;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String cmmd = ae.getActionCommand();

            if (cmmd.equals("Save")) {
                Utilities.save(model, false);
            } else if (cmmd.equals("SaveAs")) {
                Utilities.save(model, true);
            } else if (cmmd.equals("Open")) {
                Model newModel = Utilities.open(model);
                if (newModel != null) {
                    setModel(newModel);
                    // needed cuz setModel sets to true:
                    model.setUnsavedChanges(false);
                }
            } else if (cmmd.equals("New")) {
                Utilities.saveChanges(model);
                setModel(factory.makeModel());
                // needed cuz setModel sets to true:
                model.setUnsavedChanges(false);
            } else if (cmmd.equals("Quit")) {
                Utilities.saveChanges(model);
                System.exit(0);
            } else if (cmmd.equals("About")) {
                Utilities.inform(factory.about());
            } else if (cmmd.equals("Help")) {
                Utilities.inform(factory.getHelp());
            } else { // must be from Edit menu
                Command command = factory.makeEditCommand(model, cmmd, null);
                try {
                    command.execute();
                } catch (Exception e) {
                    Utilities.inform(e.getMessage());
                }

            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    protected void handleException(Exception e) {
        Utilities.error(e);
    }
}


// package mvc;

// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import javax.swing.*;

// public class AppPanel extends JPanel implements Subscriber, ActionListener {
//     public static int FRAME_WIDTH = 1000;
//     public static int FRAME_HEIGHT = 600;

//     protected AppFactory factory;
//     protected Model model;
//     protected View view;
//     protected JPanel controlPanel;
//     private final JFrame frame;

//     public AppPanel(AppFactory factory) {
//         this.factory = factory;

//         this.model = factory.makeModel();
//         this.view = factory.makeView(model);
//         this.controlPanel = new JPanel();

//         this.setLayout(new GridLayout(1, 2));
//         this.add(controlPanel);
//         this.add(view);

//         this.frame = new SafeFrame();
//         Container pane = frame.getContentPane();
//         pane.add(this);
//         frame.setJMenuBar(createMenuBar());
//         frame.setTitle(factory.getTitle());
//         frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
//     }

//     private JMenuBar createMenuBar() {
//         JMenuBar menuBar = new JMenuBar();
//         menuBar.add(Utilities.makeMenu("File", new String[] { "New", "Open", "Save", "Save As", "Quit" }, this));
//         menuBar.add(Utilities.makeMenu("Edit", factory.getEditCommands(), this));
//         menuBar.add(Utilities.makeMenu("Help", new String[] { "About", "Help" }, this));
//         return menuBar;
//     }

//     public void display() {
//         frame.setVisible(true);
//     }

//     public Model getModel() {
//         return model;
//     }

//     public void setModel(Model newModel) {
//         model.unsubscribe(this);
//         this.model = newModel;
//         model.subscribe(this);

//         view.setModel(this.model);
//         model.changed();
//     }

//     public void actionPerformed(ActionEvent actionEvent) {
//         try {
//             String command = actionEvent.getActionCommand();
//             switch (command) {
//                 case "New":
//                     if (Utilities.confirmSaveChanges(model)) {
//                         setModel(factory.makeModel());
//                         model.setUnsavedChanges(false);
//                     }
//                     break;
//                 case "Open":
//                     Model newModel = Utilities.open(model);
//                     if (newModel != null) {
//                         setModel(newModel);
//                         model.setUnsavedChanges(false);
//                     }
//                     break;
//                 case "Save":
//                     Utilities.save(model, false);
//                     break;
//                 case "Save As":
//                     Utilities.save(model, true);
//                     break;
//                 case "Quit":
//                     if (Utilities.confirmSaveChanges(model))
//                         System.exit(0);
//                     break;

//                 case "About":
//                     Utilities.inform(factory.about(), "About");
//                     break;
//                 case "Help":
//                     Utilities.inform(factory.getHelp(), "Help");
//                     break;

//                 default:
//                     Command editCommand = factory.makeEditCommand(model, command, actionEvent.getSource());
//                     if (editCommand != null) {
//                         editCommand.execute();
//                     }
//             }
//         } catch (Exception e) {
//             handleException(e);
//         }
//     }

//     protected void handleException(Exception e) {
//         Utilities.error(e);
//     }

//     public void update() {
//         view.repaint();
//     }
// }
