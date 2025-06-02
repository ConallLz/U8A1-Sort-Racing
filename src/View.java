/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26-X
*/

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class View extends JFrame {
    public JSlider arrayLength;
    public JSlider arrayMinimum;
    public JSlider arrayMaximum;
    public JButton startRace;
    public JTextArea display;

    public View() {
        super();

        int spacing = 10;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        setTitle("Sort Racer");

        add(Box.createRigidArea(new Dimension(0, spacing)));

        JLabel title = new JLabel("Sort Racer");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20f));
        add(title);

        add(Box.createRigidArea(new Dimension(0, spacing)));

        JLabel arrayLengthTitle = new JLabel("Array Length");
        add(arrayLengthTitle);

        arrayLength = new JSlider(JSlider.HORIZONTAL, 0, 100000, 50000);
        arrayLength.setMajorTickSpacing(25000);
        arrayLength.setMinorTickSpacing(10000);
        arrayLength.setPaintTicks(true);
        arrayLength.setPaintLabels(true);
        add(arrayLength);

        add(Box.createRigidArea(new Dimension(0, spacing)));

        JLabel arrayMinimumTitle = new JLabel("Array Minimum");
        add(arrayMinimumTitle);

        arrayMinimum = new JSlider(JSlider.HORIZONTAL, -200, 200, -200);
        arrayMinimum.setMajorTickSpacing(100);
        arrayMinimum.setMinorTickSpacing(10);
        arrayMinimum.setPaintTicks(true);
        arrayMinimum.setPaintLabels(true);
        add(arrayMinimum);

        add(Box.createRigidArea(new Dimension(0, spacing)));

        JLabel arrayMaximumTitle = new JLabel("Array Maximum");
        add(arrayMaximumTitle);

        arrayMaximum = new JSlider(JSlider.HORIZONTAL, -200, 200, 200);
        arrayMaximum.setMajorTickSpacing(100);
        arrayMaximum.setMinorTickSpacing(10);
        arrayMaximum.setPaintTicks(true);
        arrayMaximum.setPaintLabels(true);
        add(arrayMaximum);

        add(Box.createRigidArea(new Dimension(0, spacing)));

        startRace = new JButton("Start Sort Race");
        add(startRace);

        add(Box.createRigidArea(new Dimension(0, spacing)));

        display = new JTextArea(15, 1);
        display.setEditable(false);
        add(display);

        Component[] components = getContentPane().getComponents();
        for (Component c : components) {
            if (c instanceof JComponent) {
                ((JComponent) c).setAlignmentX(Component.CENTER_ALIGNMENT);
            }
        }
        
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, getContentPane().getSize().height));
        setVisible(true);
    }
}