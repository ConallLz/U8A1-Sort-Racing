/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26-X
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller {
    public int length = 50000;
    public int min = -200;
    public int max = 200;

    /**
     * @param m - The model of the GUI (calculations)
     * @param v - The view of the GUI (components)
    */
    public Controller(Model m, View v) {
        v.arrayLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                length = v.arrayLength.getValue();
            }
        });

        v.arrayMinimum.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int minValue = v.arrayMinimum.getValue();
                int maxValue = v.arrayMaximum.getValue();

                if (minValue < maxValue) {
                    min = minValue;
                } else {
                    v.arrayMinimum.setValue(min);
                }
            }
        });

        v.arrayMaximum.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int minValue = v.arrayMinimum.getValue();
                int maxValue = v.arrayMaximum.getValue();

                if (maxValue > minValue) {
                    max = maxValue;
                } else {
                    v.arrayMaximum.setValue(max);
                }
            }
        });

        v.startRace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                v.display.setText("");
                long[] results = m.startRace(length, min, max);
                System.out.println();
                String[] algos = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort"};

                for (int i = 0; i < results.length; i++) {
                    System.out.println(algos[i] + " " + results[i]);
                    v.display.append(algos[i] +": " +  Long.toString(results[i]) + "\n");
                }
            }
        });
    }    
}