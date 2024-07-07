package member;

import com.miu.Address;
import com.miu.person.LibraryMember;
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
    LibraryMember member;

    JComponent[] components;

    public EditMemberInformation(int width, int height) {
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        Utility.comboBoxItemSetter(stateComboBox, Utility.usState);
        Utility.textFieldNumericOnly(memberIDTextField, false);
        Utility.textFieldNumericOnly(phoneNumberTextField, false, 11);
        Utility.textFieldNumericOnly(zipCodeTextField, false, 5);

        components = new JComponent[] {firstNameTextField, lastNameTextField, phoneNumberTextField, stateComboBox, cityTextField, zipCodeTextField, streetTextField, submitButton};
        Utility.enableComponent(components, false);
        Utility.resetComponent(components);
        add(basePanel);
        memberIDTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(memberIDTextField.getText().length() == 0){
                        JOptionPane.showMessageDialog(basePanel, "Please enter a member ID", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    member =  LibraryMember.findMember(Integer.parseInt(memberIDTextField.getText()));
                    if(member!=null){
                        output(member);
                        Utility.enableComponent(components, true);
                    }
                    else{
                        JOptionPane.showMessageDialog(basePanel, "Please enter a valid phone number", "Member not Found", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    Utility.enableComponent(components, false);
                    Utility.resetComponent(components);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utility.resetComponent(components);
                Utility.enableComponent(components, false);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Utility.validationComponentEmpty(components)){
                    Address address = new Address(streetTextField.getText(), cityTextField.getText(), stateComboBox.getSelectedItem().toString(), zipCodeTextField.getText());
                    member.setAddress(address);
                    member.setPhoneNumber(phoneNumberTextField.getText());
                    member.setFirstName(firstNameTextField.getText());
                    member.setLastName(lastNameTextField.getText());
                    update(member);
                }
                else{
                    JOptionPane.showMessageDialog(basePanel, "Please fill all the required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    private void update(LibraryMember member) {
        if(LibraryMember.editMember(member) != null){
            JOptionPane.showMessageDialog(basePanel, "Member updated successfully!", "Member update", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(basePanel, "Member updated unsuccessfully!", "Member update", JOptionPane.ERROR_MESSAGE);
        };

    }
    private void output(LibraryMember member){
        firstNameTextField.setText(member.getFirstName());
        lastNameTextField.setText(member.getLastName());
        phoneNumberTextField.setText(member.getPhoneNumber());
        stateComboBox.setSelectedItem(member.getAddress().getState());
        cityTextField.setText(member.getAddress().getCity());
        zipCodeTextField.setText(member.getAddress().getZip());
        streetTextField.setText(member.getAddress().getStreet());
    }
}
