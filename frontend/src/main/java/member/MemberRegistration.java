package member;

import com.miu.Address;
import com.miu.factory.MemberFactory;
import com.miu.person.LibraryMember;
import com.miu.util.HelperUtil;
import utility.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField cityTextField;

    public MemberRegistration(int width, int height) {
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        Utility.comboBoxItemSetter(stateComboBox, Utility.usState);
        Utility.textFieldNumericOnly(phoneNumberTextField, false, 11);
        Utility.textFieldNumericOnly(zipCodeTextField, false, 5);
        add(basePanel);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMember();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clean();
            }
        });
    }
    private void addMember(){
        Address address = new Address(streetTextField.getText(), cityTextField.getText(), stateComboBox.getSelectedItem().toString(), zipCodeTextField.getText());
        LibraryMember member =  MemberFactory.addLibrarianMember(firstNameTextField.getText(), lastNameTextField.getText(), phoneNumberTextField.getText(), address);
        if(LibraryMember.addLibraryMember(member) != null){
            JOptionPane.showMessageDialog(null, "Something Went!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, STR."Member ID:\{member.getMemberId()} is created!", "Add Member Successfully", JOptionPane.INFORMATION_MESSAGE);
            clean();
        }
    }
    private void clean(){
        Component[] components = {streetTextField, cityTextField, stateComboBox, zipCodeTextField, firstNameTextField, lastNameTextField, phoneNumberTextField};
        Utility.resetComponent(components);
    }
}
