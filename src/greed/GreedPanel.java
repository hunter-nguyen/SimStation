package greed;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import simStation.*;

public class GreedPanel extends WorldPanel implements ChangeListener {
    JPanel sliderPanel = new JPanel();
    JSlider slider1, slider2, slider3;


    public GreedPanel(GreedFactory factory) {
        super(factory);

        sliderPanel.setLayout(new GridLayout(6, 1));
        sliderPanel.setOpaque(false);

        slider1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
        slider1.setMinorTickSpacing(2);
        slider1.setMajorTickSpacing(10);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setLabelTable(slider1.createStandardLabels(10));


        slider2 = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
        // slider2.setMinorTickSpacing(1);
        slider2.setMajorTickSpacing(2);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.setLabelTable(slider2.createStandardLabels(10));

        slider3 = new JSlider(JSlider.HORIZONTAL, 0, 50, 2);
        slider3.setMinorTickSpacing(5);
        slider3.setMajorTickSpacing(10);
        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);
        slider3.setLabelTable(slider3.createStandardLabels(20));

        slider1.addChangeListener(this);
        slider2.addChangeListener(this);
        slider3.addChangeListener(this);

        //slider 1
        JPanel pp = new JPanel();
        pp.setLayout(new BorderLayout());
        pp.setOpaque(false);

        JPanel ppp = new JPanel();
        ppp.setOpaque(false);
        ppp.add(new JLabel("Greed: "));
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
        ppp.add(new JLabel("Grow back rate"));
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
        ppp.add(new JLabel("Move Energy: "));
        pp.add(ppp, BorderLayout.NORTH);

        ppp = new JPanel();
        ppp.setOpaque(false);
        ppp.setLayout(new BorderLayout());
        ppp.add(slider3, BorderLayout.CENTER);
        pp.add(ppp, BorderLayout.CENTER);
        sliderPanel.add(pp);

        sliderPanel.add(ppp);
        controlPanel.add(sliderPanel, BorderLayout.CENTER);
    }

    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == slider1) {
            GreedSimulation.GREEDINESS = slider1.getValue();
        }
        if (e.getSource() == slider2) {
            GreedSimulation.GROW_BACK_RATE = slider2.getValue();
        }
        if (e.getSource() == slider3) {
            GreedSimulation.MOVE_ENERGY = slider3.getValue();
        }
        model.changed();
    }

    public void update() {
        slider1.setValue(GreedSimulation.GREEDINESS);
        slider2.setValue(GreedSimulation.GROW_BACK_RATE);
        slider3.setValue(GreedSimulation.MOVE_ENERGY);
        repaint();
    }
}
