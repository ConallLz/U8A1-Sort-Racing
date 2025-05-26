/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26-X
*/

import java.awt.Component;
import javax.swing.*;

public class View extends JFrame {
    // Make the following components available to be used by the controller
    public JButton convertButton;
    
    public JTextField inputNumberTextField;
    public JTextField outputNumberTextField;

    public ButtonGroup inputButtonGroup;
    public ButtonGroup outputButtonGroup;

    public View() {
        super();

        // Set the layout to a box layout aligned vertically (one column)
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        // Title
        JLabel titleLabel = new JLabel("Base Converter");
        add(titleLabel);

        // [ Input components
        JPanel inputNumber = new JPanel();

        JLabel inputNumberLabel = new JLabel("Input:");
        inputNumber.add(inputNumberLabel);

        inputNumberTextField = new JTextField(10);
        inputNumber.add(inputNumberTextField);

        add(inputNumber);
        // ]

        // [ Output options
        JPanel inputNumberBase = new JPanel();
        inputNumberBase.setBorder(BorderFactory.createTitledBorder("Input Number Base"));

        inputButtonGroup = new ButtonGroup();

        JRadioButton inputBinaryRadioButton = new JRadioButton("Binary");
        // Set action command sets the action attribute on the button
        // The action attribute of the selected button in a button group can be retrieved with .getSelection().getActionCommand()
        inputBinaryRadioButton.setActionCommand("2"); 
        inputButtonGroup.add(inputBinaryRadioButton);
        inputNumberBase.add(inputBinaryRadioButton);

        JRadioButton inputTernaryRadioButton = new JRadioButton("Ternary");
        inputTernaryRadioButton.setActionCommand("3");
        inputButtonGroup.add(inputTernaryRadioButton);
        inputNumberBase.add(inputTernaryRadioButton);

        JRadioButton inputOctalRadioButton = new JRadioButton("Octal");
        inputOctalRadioButton.setActionCommand("8");
        inputButtonGroup.add(inputOctalRadioButton);
        inputNumberBase.add(inputOctalRadioButton);

        JRadioButton inputDecimalRadioButton = new JRadioButton("Decimal");
        inputDecimalRadioButton.setActionCommand("10");
        inputDecimalRadioButton.setSelected(true); // Set decimal to the default input base
        inputButtonGroup.add(inputDecimalRadioButton);
        inputNumberBase.add(inputDecimalRadioButton);

        add(inputNumberBase);
        // ]

        // [ Output components
        JPanel outputNumberBase = new JPanel();
        outputNumberBase.setBorder(BorderFactory.createTitledBorder("Output Number Base"));

        outputButtonGroup = new ButtonGroup();

        JRadioButton outputBinaryRadioButton = new JRadioButton("Binary");
        outputBinaryRadioButton.setActionCommand("2");
        outputBinaryRadioButton.setSelected(true); // Set binary to the default output base
        outputButtonGroup.add(outputBinaryRadioButton);
        outputNumberBase.add(outputBinaryRadioButton);

        JRadioButton outputTernaryRadioButton = new JRadioButton("Ternary");
        outputTernaryRadioButton.setActionCommand("3");
        outputButtonGroup.add(outputTernaryRadioButton);
        outputNumberBase.add(outputTernaryRadioButton);

        JRadioButton outputOctalRadioButton = new JRadioButton("Octal");
        outputOctalRadioButton.setActionCommand("8");
        outputButtonGroup.add(outputOctalRadioButton);
        outputNumberBase.add(outputOctalRadioButton);

        JRadioButton outputDecimalRadioButton = new JRadioButton("Decimal");
        outputDecimalRadioButton.setActionCommand("10");
        
        outputButtonGroup.add(outputDecimalRadioButton);
        outputNumberBase.add(outputDecimalRadioButton);
        add(outputNumberBase);
        // ]

        // [
        convertButton = new JButton("Convert");
        add(convertButton);
        // ]

        // [
        JPanel outputNumber = new JPanel();

        JLabel outputNumberLabel = new JLabel("Output:");
        outputNumber.add(outputNumberLabel);

        outputNumberTextField = new JTextField(10);
        outputNumberTextField.setEditable(false); // Prevent user from editing output
        outputNumber.add(outputNumberTextField);

        add(outputNumber);
        // ]

        // Center all components on the x axis
        Component[] components = getContentPane().getComponents();
        for (Component c : components) {
            if (c instanceof JComponent) {
                ((JComponent) c).setAlignmentX(Component.CENTER_ALIGNMENT);
            }
        }

        pack();
        // Center window
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(getContentPane().getSize());
        setVisible(true);
    }
}