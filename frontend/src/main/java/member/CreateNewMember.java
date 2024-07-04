package src.main.java.member;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class CreateNewMember extends JPanel {
    private JPanel basePanel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField phoneNumberTextField;
    private final List<Gender> GENDERS = Arrays.asList(Gender.MALE, Gender.FEMALE);
    private JComboBox<String> genderComboBox;
    private JButton submitButton;

    public CreateNewMember(int width, int height) {
        System.out.println("I got a called CreateNewMember");
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        comboBoxItemSetter(genderComboBox, GENDERS);
        add(basePanel);
    }

    private void comboBoxItemSetter(JComboBox comboBox, List listItem){
        comboBox.setSelectedIndex(-1);
        listItem.forEach(o ->
                comboBox.addItem(o.toString())
        );
    }
}
