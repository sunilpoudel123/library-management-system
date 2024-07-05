package member;

import utility.Utility;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class EditMemberInformation extends JPanel{
    private JPanel basePanel;
    private JPanel bodyPanel;

    private JTextField phoneNumberTextField;
    private JTextField firstNameTextField;
    private JTextField streetTextField;
    private JTextField lastNameTextField;
    private JTextField zipCodeTextField;
    private JTextField memberIDTextField;

    private JComboBox<String> stateComboBox;

    private JButton cancelButton;
    private JButton submitButton;
    private JPanel actionerPanel;
    private JTextField cityTextField;

    public EditMemberInformation(int width, int height) {
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        Utility.comboBoxItemSetter(stateComboBox, Utility.usState);
        Utility.textFeildNumericOnly(memberIDTextField, false);
        Utility.textFeildNumericOnly(phoneNumberTextField, false);
        Utility.textFeildNumericOnly(zipCodeTextField, false);
        add(basePanel);
    }
}
