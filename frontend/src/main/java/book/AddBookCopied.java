package book;

import utility.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

    private boolean isFound = false;
    private final boolean isSuccess = false;

    public AddBookCopied(int width, int height){
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        Utility.textFeildNumericOnly(increaseCopiedQtyTextField, false);
        add(basePanel);
        isbnTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    isBookExist(isbnTextField.getText());
                }
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(increaseCopiedQtyTextField.getText()) > 0)
                    JOptionPane.showMessageDialog(null, STR."The Copied of Book \{isbnTextField.getText()} Qty Increase by \{increaseCopiedQtyTextField.getText()} Copies", "Add Copied Successfully", JOptionPane.INFORMATION_MESSAGE);
                else if(Integer.parseInt(increaseCopiedQtyTextField.getText()) == 0)
                    JOptionPane.showMessageDialog(null, "Make no difference by increase 0 Quantity!", "Add Copied by 0?", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    private void isBookExist(String isbn){
        if(!isFound){
            titleTextField.setForeground(Color.RED);
            titleTextField.setText("N/A");
        }
        else{
            titleTextField.setForeground(Color.GREEN);
            titleTextField.setText("Object-Oriented-Programming");
            copiedQtyTextField.setText("10");
            copiedAvailableQtyTextFeild.setText("2");
            increaseCopiedQtyTextField.setEditable(true);
        }
        submitButton.setEnabled(isFound);
        isFound = !isFound;
    }
}
