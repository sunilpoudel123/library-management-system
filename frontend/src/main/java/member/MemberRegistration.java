package member;

import com.miu.Address;
import com.miu.person.LibraryMember;
import com.miu.person.Member;
import com.miu.person.MemberFactory;
import utility.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

    Component[] components;

    public MemberRegistration(int width, int height) {
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        components = new Component[] {streetTextField, cityTextField, stateComboBox, zipCodeTextField, firstNameTextField, lastNameTextField, phoneNumberTextField};
        Utility.comboBoxItemSetter(stateComboBox, Utility.usState);
        Utility.textFieldNumericOnly(phoneNumberTextField, false, 11);
        Utility.textFieldNumericOnly(zipCodeTextField, false, 5);
        add(basePanel);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Utility.validationComponentEmpty(components))
                    addMember();
                else{
                    JOptionPane.showMessageDialog(basePanel, "Please fill all the required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clean(components);
            }
        });
    }
    private void addMember(){
        Address address = new Address(streetTextField.getText(), cityTextField.getText(), stateComboBox.getSelectedItem().toString(), zipCodeTextField.getText());
        Member member =  MemberFactory.addLibraryMember(firstNameTextField.getText(), lastNameTextField.getText(), phoneNumberTextField.getText(), address);
        if(LibraryMember.addLibraryMember((LibraryMember) member) != null){
            JOptionPane.showMessageDialog(null, "Something Went!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, STR."Member ID:\{((LibraryMember)member).getMemberId()} is created!", "Add Member Successfully", JOptionPane.INFORMATION_MESSAGE);
            clean(components);
        }
    }
    private void clean(Component[] components){
        Utility.resetComponent(components);
    }
}
