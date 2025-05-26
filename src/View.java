/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26-X
*/

import java.awt.Component;
import javax.swing.*;

public class View extends JFrame {
    public View() {
        super();

        setTitle("Sort Racer");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel titleLabel = new JLabel("Sort Racer");
        add(titleLabel);

        Component[] components = getContentPane().getComponents();
        for (Component c : components) {
            if (c instanceof JComponent) {
                ((JComponent) c).setAlignmentX(Component.CENTER_ALIGNMENT);
            }
        }

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(getContentPane().getSize());
        setVisible(true);
    }
}