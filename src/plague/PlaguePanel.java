package plague;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import simStation.*;

public class PlaguePanel extends WorldPanel implements ChangeListener{ 
    JPanel sliderPanel = new JPanel();
    JSlider slider1, slider2, slider3, slider4;

    JButton fatalityButton;

    public PlaguePanel(PlagueFactory factory) {
        super(factory);

        sliderPanel.setLayout(new GridLayout(6, 1));
        sliderPanel.setOpaque(false);

        slider1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);
        slider1.setMinorTickSpacing(1);
        slider1.setMajorTickSpacing(3);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setLabelTable(slider1.createStandardLabels(10));


        slider2 = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider2.setMinorTickSpacing(1);
        slider2.setMajorTickSpacing(3);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.setLabelTable(slider2.createStandardLabels(10));

        slider3 = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
        slider3.setMinorTickSpacing(1);
        slider3.setMajorTickSpacing(3);
        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);
        slider3.setLabelTable(slider3.createStandardLabels(20));

        slider4 = new JSlider(JSlider.HORIZONTAL, 0, 500, 200);
        slider4.setMinorTickSpacing(10);
        slider4.setMajorTickSpacing(50);
        slider4.setPaintTicks(true);
        slider4.setPaintLabels(true);
        slider4.setLabelTable(slider4.createStandardLabels(50));

        slider1.addChangeListener(this);
        slider2.addChangeListener(this);
        slider3.addChangeListener(this);
        slider4.addChangeListener(this);
       /*
        slider1.addChangeListener(e -> {
            Tournament.numRebels = slider1.getValue();
        });

        slider2.addChangeListener(e -> {
            Tournament.swerveTendency = slider2.getValue();
        });
*/

        //slider 1
        JPanel pp = new JPanel();
        pp.setLayout(new BorderLayout());
        pp.setOpaque(false);

        JPanel ppp = new JPanel();
        ppp.setOpaque(false);
        ppp.add(new JLabel("Initial % Infected:"));
        pp.add(ppp, BorderLayout.NORTH);

        ppp = new JPanel();
        ppp.setOpaque(false);
        ppp.add(slider1);
        pp.add(ppp, BorderLayout.CENTER);

        sliderPanel.add(pp);

        //slider 2
        pp = new JPanel();
        pp.setLayout(new BorderLayout());
        pp.setOpaque(false);
        ppp = new JPanel();
        ppp.setOpaque(false);
        ppp.add(new JLabel("Infection Probability"));
        pp.add(ppp, BorderLayout.NORTH);

        ppp = new JPanel();
        ppp.setOpaque(false);
        ppp.add(slider2);
        pp.add(ppp, BorderLayout.CENTER);
        sliderPanel.add(pp);

        //slider 3
        pp = new JPanel();
        pp.setLayout(new BorderLayout());
        pp.setOpaque(false);
        ppp = new JPanel();
        ppp.setOpaque(false);
        ppp.add(new JLabel("Initial Population Size:"));
        pp.add(ppp, BorderLayout.NORTH);

        ppp = new JPanel();
        ppp.setOpaque(false);
        ppp.setLayout(new BorderLayout());
        ppp.add(slider3, BorderLayout.CENTER);
        pp.add(ppp, BorderLayout.CENTER);
        sliderPanel.add(pp);

        //slider 4
        pp = new JPanel();
        pp.setLayout(new BorderLayout());
        pp.setOpaque(false);
        ppp = new JPanel();
        ppp.setOpaque(false);
        ppp.add(new JLabel("Fatality/Recovery Time:"));
        pp.add(ppp, BorderLayout.NORTH);

        ppp = new JPanel();
        ppp.setOpaque(false);
        ppp.setLayout(new BorderLayout());
        ppp.add(slider4, BorderLayout.CENTER);
        pp.add(ppp, BorderLayout.CENTER);
        sliderPanel.add(pp);
        controlPanel.add(sliderPanel, BorderLayout.CENTER);

        // fatalityButton = new JButton("Not Fatal");
        // fatalityButton.addActionListener(this);
        // pp = new JPanel();
        // pp.add(fatalityButton);
        // controlPanel.add(pp, BorderLayout.CENTER);
    }

    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == slider1) {
            PlagueSimulation.INITIAL_INFECTED = slider1.getValue();
        }
        if (e.getSource() == slider2) {
            PlagueSimulation.VIRULENCE = slider2.getValue();
            // ((PlagueSimulation)model).setSwerveTendency(slider2.getValue());
        }
        if (e.getSource() == slider3) {
            PlagueSimulation.INITIAL_POPULATION_SIZE = slider3.getValue();
        }
        if (e.getSource() == slider4) {
            PlagueSimulation.RECOVERY_TIME = slider4.getValue();
        }
        model.changed();
    }

    public void update() {
        slider1.setValue(((PlagueSimulation)model).INITIAL_INFECTED);
        slider2.setValue(((PlagueSimulation)model).VIRULENCE);
        slider3.setValue(((PlagueSimulation)model).INITIAL_POPULATION_SIZE);
        slider4.setValue(((PlagueSimulation)model).RECOVERY_TIME);
        repaint();
    }
}
