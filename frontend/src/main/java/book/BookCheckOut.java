package book;


import com.miu.book.Book;
import com.miu.book.BookCopy;
import com.miu.checkout.CheckoutRecord;
import com.miu.checkout.CheckoutRecordEntry;
import com.miu.person.LibraryMember;
import utility.Utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class BookCheckOut extends JPanel{
    private JPanel basePanel;
    private JTextField isbnTextField;
    private JTextField memberIDTextField;
    private JPanel actionerPanel;
    private JButton cancelButton;
    private JButton submitButton;
    private JTextField titleTextField;
    private JTextField customerNameTextField;
    private JTextField dueDateTimeTextField;

    private Book book = null;
    private BookCopy bookCopy = null;
    private LibraryMember member;
    private Date dueDate = new Date();

    public BookCheckOut(int width, int height){
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
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
                        customerNameTextField.setText(STR."\{member.getLastName()} \{member.getFirstName()}");
                        if(bookCopy!=null){
                            Utility.enableComponent(submitButton, true);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(basePanel, "Please enter a valid phone number", "Member not Found", JOptionPane.WARNING_MESSAGE);
                        Utility.enableComponent(submitButton, false);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_CONTROL){

                }
                else{
                    member = null;
                    Utility.enableComponent(submitButton, false);
                }
            }
        });

        isbnTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(isbnTextField.getText().length() == 0){
                        JOptionPane.showMessageDialog(basePanel, "Please enter a Book ISBN", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    else{
                        checkBookExist(isbnTextField.getText());
                        if(member!=null){
                            Utility.enableComponent(submitButton, true);
                        }
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_CONTROL){

                }
                else{
                    book = null;
                    bookCopy = null;
                    Utility.enableComponent(submitButton, false);
                }
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(member == null || bookCopy==null){
                    JOptionPane.showMessageDialog(basePanel, "Checkout Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                CheckoutRecordEntry checkoutRecordEntry = new CheckoutRecordEntry(member, bookCopy, dueDate);
                CheckoutRecordEntry.addCheckoutRecordEntry(checkoutRecordEntry);

                if(CheckoutRecordEntry.addCheckoutRecordEntry(checkoutRecordEntry) !=null){
                    JOptionPane.showMessageDialog(basePanel, "Checkout Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(basePanel, "Checkout Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void checkBookExist(String isbn){
        book = Book.findBook(isbn);
        if(book!=null){
            bookCopy = book.checkAvailableCopy();
            if(bookCopy!=null){
                titleTextField.setText(book.getTitle());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dueDate);
                calendar.add(Calendar.DATE, book.getBorrowedPeriod());  // Increase date by 5 days

                dueDate = calendar.getTime();
                dueDateTimeTextField.setText(dueDate.toString());
            }
            else{
                JOptionPane.showMessageDialog(basePanel, "Book Not Book Available", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(basePanel, "Book does not exist", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
