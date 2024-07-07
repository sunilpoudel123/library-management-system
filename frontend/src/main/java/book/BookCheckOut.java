package book;


import javax.swing.*;

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
