package member;

import com.miu.Address;
import utility.Utility;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    private String memberId;

    private boolean isFound;

    public EditMemberInformation(int width, int height) {
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        Utility.comboBoxItemSetter(stateComboBox, Utility.usState);
        Utility.textFieldNumericOnly(memberIDTextField, false);
        Utility.textFieldNumericOnly(phoneNumberTextField, false, 11);
        Utility.textFieldNumericOnly(zipCodeTextField, false, 5);

        JComponent[] components = {firstNameTextField, lastNameTextField, phoneNumberTextField, stateComboBox, cityTextField, zipCodeTextField, streetTextField, submitButton};

        Utility.enableComponent(components, false);

        Utility.resetComponent(components);

        add(basePanel);

        memberIDTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(isFound){
                        output();
                        Utility.enableComponent(components, isFound);
                        isFound=!isFound;
                    }
                    else{
                        JOptionPane.showMessageDialog(basePanel, "Please enter a valid phone number");
                        isFound=!isFound;
                    }
                }
                else if(memberId != null){
                    memberId = null;
                    Utility.enableComponent(components, isFound);
                    Utility.resetComponent(components);
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utility.resetComponent(components);
                Utility.enableComponent(components, false);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utility.resetComponent(components);
            }
        });
    }
//    private LibraryMember getMember() {
//        return new LibraryMember("1", "Hang Kheang", "Taing", "6412330129", new Address("1","FairField","AL", "16855"), "Member");
//    }
    private void output(){
//        firstNameTextField.setText(member.getFirstName());
//        lastNameTextField.setText(member.getLastName());
//        phoneNumberTextField.setText(member.getPhoneNumber());
//
//        stateComboBox.setSelectedItem(member.getAddress().getState());
//        cityTextField.setText(member.getAddress().getCity());
//        zipCodeTextField.setText(member.getAddress().getZip());
//        streetTextField.setText(member.getAddress().getStreet());
//        memberId = member.getMemberId();
    }
}
