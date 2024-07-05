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
    private JComboBox<String> stateComboBox;
    private JTextField cityTextField;

    public ImportBook(int width, int height){
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        Utility.textFieldNumericOnly(borrowedPeriodTextField, false);
        Utility.textFieldNumericOnly(copiedQtyTextField, false);
        Utility.textFieldNumericOnly(availableQtyTextField, false);
        Utility.textFieldNumericOnly(phoneNumberTextField, false, 11);
        Utility.textFieldNumericOnly(zipCodeTextField, false, 5);
        Utility.comboBoxItemSetter(stateComboBox, Utility.usState);
        add(basePanel);
    }
}
