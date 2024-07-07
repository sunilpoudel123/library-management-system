package book;

import com.miu.Address;
import com.miu.book.Book;
import com.miu.book.BookCopy;
import com.miu.book.BookFactory;
import com.miu.book.BookInterface;
import com.miu.person.Author;
import com.miu.person.LibraryMember;
import utility.Utility;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ImportBook extends JPanel{
    private JPanel basePanel;
    private JPanel bodyPanel;
    private JPanel actionerPanel;

    private JTextField isbnTextField;
    private JTextField copiedQtyTextField;
    private JTextField titleField;
    private JTextField borrowedPeriodTextField;

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
    private JTextField credentialTextField;

    private JComponent[] components = new JComponent[]{
            isbnTextField,
            copiedQtyTextField,
            titleField,
            borrowedPeriodTextField,
            firstNameTextField,
            lastNameTextField,
            phoneNumberTextField,
            bioTextArea,
            streetTextField,
            zipCodeTextField,
            stateComboBox,
            cityTextField,
            credentialTextField
    };

    public ImportBook(int width, int height){
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        Utility.textFieldNumericOnly(borrowedPeriodTextField, false);
        Utility.textFieldNumericOnly(copiedQtyTextField, false);
        Utility.textFieldNumericOnly(phoneNumberTextField, false, 11);
        Utility.textFieldNumericOnly(zipCodeTextField, false, 5);
        Utility.comboBoxItemSetter(stateComboBox, Utility.usState);
        add(basePanel);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Utility.validationComponentEmpty(components)){
                    addBook();
                }
                else{
                    JOptionPane.showMessageDialog(basePanel, "Please fill all the required fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utility.resetComponent(components);
            }
        });
    }

    public void addBook(){
        BookInterface book = null;
        Address address = new Address(streetTextField.getText(), cityTextField.getText(), stateComboBox.getSelectedItem().toString(), zipCodeTextField.getText());
        Author author = new Author(firstNameTextField.getText(), lastNameTextField.getText(), phoneNumberTextField.getText(), credentialTextField.getText(), bioTextArea.getText(), address);
        int copiedQty = Integer.parseInt(copiedQtyTextField.getText());
        if(copiedQty==1){
            BookCopy bookCopy = new BookCopy();
            book = BookFactory.createBook(titleField.getText(), isbnTextField.getText(), Integer.parseInt(borrowedPeriodTextField.getText()), author, bookCopy);
        }
        else if(copiedQty >1) {
            List<BookCopy> bookCopyList = new ArrayList<>();
            for(int i = 1; i <= copiedQty; i++){
                bookCopyList.add(new BookCopy());
            }
            book = BookFactory.createBook("", "", Integer.parseInt(borrowedPeriodTextField.getText()), author, bookCopyList);
        }
        else{
            JOptionPane.showMessageDialog(null, "Copied Qty must be at least one","Invalid copied Qty", JOptionPane.ERROR_MESSAGE);
        }
        if(BookCopy.saveBook((Book) book)!=null){
            JOptionPane.showMessageDialog(null, "Save Successfully!","Saved!", JOptionPane.INFORMATION_MESSAGE);
            Utility.resetComponent(components);
        }
        else{
            JOptionPane.showMessageDialog(null, "Save failed","Save failed", JOptionPane.ERROR_MESSAGE);
        }
    }

}
