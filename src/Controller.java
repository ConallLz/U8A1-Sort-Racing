/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26 - June 3
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller {
    // Default array length, min value, and max value
    public int length = 50000; 
    public int min = -200;
    public int max = 200;

    /**
     * @param m - The model of the GUI (calculations)
     * @param v - The view of the GUI (components)
    */
    public Controller(Model m, View v) {
        // Length slider
        v.arrayLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) { // When the slider is moved
                length = v.arrayLength.getValue(); // Set the length variable to the slider value
            }
        });


        // Minimum slider
        v.arrayMinimum.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) { // When the slider is moved
                // Set the minimum variable to the slider value
                // Only if the value is less than the current max value

                int minValue = v.arrayMinimum.getValue();
                int maxValue = v.arrayMaximum.getValue();

                if (minValue < maxValue) {
                    min = minValue;
                } else {
                    v.arrayMinimum.setValue(min);
                }
            }
        });

        // Maximum slider
        v.arrayMaximum.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) { // When the slider is moved
                // Set the maximum variable to the slider value
                // Only if the value is more than the current min value

                int minValue = v.arrayMinimum.getValue();
                int maxValue = v.arrayMaximum.getValue();

                if (maxValue > minValue) {
                    max = maxValue;
                } else {
                    v.arrayMaximum.setValue(max);
                }
            }
        });

        // Start race button
        v.startRace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // When clicked
                // Clear the text, display that the algorithms will start, and then display the parameters that the race will start with
                v.display.setText("");
                v.display.append("Racing algorithms...\n");
                v.display.append("Parameters: " + Long.toString(length) + ", " + Long.toString(min) + ", " + Long.toString(max) + "\n\n");

                // Create a new thread for the logic to run
                // This prevents the ui from yeilding while the race is on
                new Thread(() -> {
                    long[] results = m.startRace(length, min, max); // Call the method which races the algorithms in model and set results to what it returns
                    String[] algos = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort"}; // An array of the names of the racing algorithms

                    for (int i = 0; i < results.length; i++) { // For each racing algorithm
                        v.display.append(algos[i] +": " +  String.valueOf((double) results[i] / 1000000) + " ms\n"); // Add the time it took  in milliseconds to the display
                    }
                }).start(); // Start the thread
            }
        });
    }    
}