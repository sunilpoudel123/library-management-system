package book;


import com.miu.book.Book;
import com.miu.book.BookCopy;
import utility.Utility;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;

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


    public BookCheckOut(int width, int height){
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        add(basePanel);
    }

}
