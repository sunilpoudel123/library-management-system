package book;

import utility.Utility;

import javax.swing.*;

public class ImportBook extends JPanel{
    private JPanel basePanel;
    private JPanel bodyPanel;
    private JPanel actionerPanel;

    private JTextField isbnTextField;
    private JTextField copiedQtyTextField;
    private JTextField titleField;
    private JTextField borrowedPeriodTextField;
    private JTextField availableQtyTextField;

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField phoneNumberTextField;
    private JTextArea bioTextArea;
    private JTextField streetTextField;
    private JTextField zipCodeTextField;


    private JButton cancelButton;
    private JButton submitButton;
    private JComboBox stateComboBox;
    private JComboBox cityComboBox;

    public ImportBook(int width, int height){
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        Utility.textFeildNumericOnly(borrowedPeriodTextField, false);
        Utility.textFeildNumericOnly(copiedQtyTextField, false);
        Utility.textFeildNumericOnly(availableQtyTextField, false);
        Utility.textFeildNumericOnly(phoneNumberTextField, false);
        Utility.textFeildNumericOnly(zipCodeTextField, false);

        add(basePanel);
    }
}
