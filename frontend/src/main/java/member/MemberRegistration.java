package member;

import utility.Utility;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;


public class MemberRegistration extends JPanel{

    private JTextField firstNameTextField;
    private JTextField phoneNumberTextField;
    private JTextField streetTextField;
    private JTextField lastNameTextField;
    private JTextField zipCodeTextField;

    private JPanel bodyPanel;
    private JPanel basePanel;


    private JButton cancelButton;
    private JButton submitButton;

    private JComboBox<String> stateComboBox;
    private JComboBox<String> cityComboBox;

    private final List<String> DEFAULT = List.of("Default");

    public MemberRegistration(int width, int height) {
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        Utility.comboBoxItemSetter(stateComboBox, DEFAULT);
        Utility.comboBoxItemSetter(cityComboBox, DEFAULT);
        Utility.textFeildNumericOnly(phoneNumberTextField, false);
        Utility.textFeildNumericOnly(zipCodeTextField, false);
        add(basePanel);
    }


}
