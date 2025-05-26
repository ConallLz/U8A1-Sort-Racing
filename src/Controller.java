/*
 * Progammer: Conall Lorentz
 * Dates: May 16-21
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    /**
     * @param m - The model of the GUI (calculations)
     * @param v - The view of the GUI (components)
    */
    public Controller(Model m, View v) {
        v.convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // When the convert button is clicked
                v.outputNumberTextField.setText(// Set the text of the output to the output of toBase
                    m.toBase( // Convert the input (which was converted to base 10) to the given base
                        m.toCommonBase( // Convert the input to the common base (10)
                            v.inputNumberTextField.getText(),
                            Integer.parseInt(v.inputButtonGroup.getSelection().getActionCommand()) // Convert the input base action attribute string to an integer
                        ), 
                        Integer.parseInt(v.outputButtonGroup.getSelection().getActionCommand()) // Convert the output base action attribute string to an integer
                    )
                );
            }
        });
    }    
}