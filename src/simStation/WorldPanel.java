package simStation;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Model;

import javax.swing.*;
import java.awt.*;

public class WorldPanel extends AppPanel {
    protected JPanel threadPanel = new JPanel();

    public WorldPanel(AppFactory factory) {
        super(factory);

        threadPanel.setLayout(new GridLayout(1, 5));
        threadPanel.setOpaque(false);

        JPanel p = new JPanel();
        p.setOpaque(false);
        JButton button = new JButton("Start");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Pause");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Resume");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Stop");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Stats");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        controlPanel.setLayout(new BorderLayout());

        p = new JPanel();
        p.setOpaque(false);
        p.add(threadPanel);

        controlPanel.setBackground(Color.PINK);
        controlPanel.add(p, BorderLayout.NORTH);
    }

    @Override
    public void setModel(Model newModel) {
        super.setModel(newModel);

        var world = (World) newModel;
        for (var a : world.agents) {
            a.start();
            a.pause();
        }
    }
}
