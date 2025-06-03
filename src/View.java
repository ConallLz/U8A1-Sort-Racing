/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26-X
*/

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class View extends JFrame {
    // Make some of the components accessible to the controller
    public JSlider arrayLength;
    public JSlider arrayMinimum;
    public JSlider arrayMaximum;
    public JButton startRace;
    public JTextArea display;

    public View() {
        super();

        // Vertical spacing between all the components in the main pane
        int spacing = 10;

        // Vertical box layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        setTitle("Sort Racer");

        // Spacer component to separate the components
        add(Box.createRigidArea(new Dimension(0, spacing)));

        // Title component
        JLabel title = new JLabel("Sort Racer");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20f)); // Take the current font then make it bold and larger
        add(title);

        add(Box.createRigidArea(new Dimension(0, spacing)));

        JLabel arrayLengthTitle = new JLabel("Array Length");
        add(arrayLengthTitle);

        // Slider to change the length of the array the algorithms will be sorting
        arrayLength = new JSlider(JSlider.HORIZONTAL, 0, 100000, 50000);
        arrayLength.setMajorTickSpacing(25000); // How often there are large labeled ticks
        arrayLength.setMinorTickSpacing(10000); // How often there are small unlabeled ticks
        arrayLength.setPaintTicks(true); // Make the ticks and labels visible
        arrayLength.setPaintLabels(true);
        add(arrayLength);

        add(Box.createRigidArea(new Dimension(0, spacing)));

        JLabel arrayMinimumTitle = new JLabel("Array Minimum");
        add(arrayMinimumTitle);

        // Slider to change the minimum number generated in the array 
        arrayMinimum = new JSlider(JSlider.HORIZONTAL, -200, 200, -200);
        arrayMinimum.setMajorTickSpacing(100);
        arrayMinimum.setMinorTickSpacing(10);
        arrayMinimum.setPaintTicks(true);
        arrayMinimum.setPaintLabels(true);
        add(arrayMinimum);

        add(Box.createRigidArea(new Dimension(0, spacing)));

        JLabel arrayMaximumTitle = new JLabel("Array Maximum");
        add(arrayMaximumTitle);

        // Slider to change the maximum number generated in the array 
        arrayMaximum = new JSlider(JSlider.HORIZONTAL, -200, 200, 200);
        arrayMaximum.setMajorTickSpacing(100);
        arrayMaximum.setMinorTickSpacing(10);
        arrayMaximum.setPaintTicks(true);
        arrayMaximum.setPaintLabels(true);
        add(arrayMaximum);

        add(Box.createRigidArea(new Dimension(0, spacing)));

        // Button which starts the race between the algorithms
        startRace = new JButton("Start Sort Race");
        add(startRace);

        add(Box.createRigidArea(new Dimension(0, spacing)));

        // Text area to start and display the results of the race
        display = new JTextArea(15, 1);
        display.setEditable(false);
        add(display);

        // Centers all the components on the x axis
        Component[] components = getContentPane().getComponents();
        for (Component c : components) {
            if (c instanceof JComponent) {
                ((JComponent) c).setAlignmentX(Component.CENTER_ALIGNMENT);
            }
        }
        
        pack();
        setResizable(false); // Prevent the user from resizing the window
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, getContentPane().getSize().height)); // Set the minimum size of the window
        setVisible(true);
    }
}