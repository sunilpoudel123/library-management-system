package book;

import com.miu.book.Book;
import com.miu.book.BookCopy;
import utility.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddBookCopied extends JPanel{
    private JPanel basePanel;
    private JPanel actionerPanel;

    private JButton cancelButton;
    private JButton submitButton;

    private JTextField isbnTextField;
    private JTextField copiedQtyTextField;
    private JTextField copiedAvailableQtyTextFeild;
    private JTextField increaseCopiedQtyTextField;
    private JTextField titleTextField;

    private JComponent[] components = {submitButton, copiedQtyTextField, copiedAvailableQtyTextFeild, titleTextField, submitButton};

    private Book book = null;
    private BookCopy bookCopy = null;
    private LocalDate dueDate;

    public AddBookCopied(int width, int height){
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        Utility.textFieldNumericOnly(increaseCopiedQtyTextField, false);
        add(basePanel);
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
                        Utility.enableComponent(increaseCopiedQtyTextField, true);
                        Utility.enableComponent(submitButton, true);
                    }
                }
                else{
                    Utility.enableComponent(components, false);
                    Utility.resetComponent(components);
                    Utility.enableComponent(increaseCopiedQtyTextField, false);
                    Utility.enableComponent(submitButton, false);
                }
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int copiedQty = Integer.parseInt(increaseCopiedQtyTextField.getText());
                if(copiedQty > 0){
                    for(int i=1; i<=copiedQty; i++){
                        BookCopy bookCopy = new BookCopy();
                        bookCopy.setBook(book);

                        book.addBookCopy(bookCopy);
                    }
                    Book.addBook(book);
                    JOptionPane.showMessageDialog(null, STR."The Copied of Book \{isbnTextField.getText()} Qty Increase by \{increaseCopiedQtyTextField.getText()} Copies", "Add Copied Successfully", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(copiedQty == 0)
                    JOptionPane.showMessageDialog(null, "Make no difference by increase 0 Quantity!", "Add Copied by 0?", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    private void checkBookExist(String isbn){
        book = Book.findBook(isbn);
        if(book!=null){
            titleTextField.setText(book.getTitle());
            copiedQtyTextField.setText(STR."\{book.getBookCopyList().size()}");
            copiedAvailableQtyTextFeild.setText(STR."\{book.checkAvailableCopyQty()}");
        }
        else{
            JOptionPane.showMessageDialog(basePanel, "Book does not exist", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
