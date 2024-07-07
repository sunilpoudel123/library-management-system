package book;

import com.miu.book.Book;
import com.miu.book.BookInterface;
import utility.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Booklist extends JPanel{

    private JPanel searchPanel;
    private JPanel resultPanel;

    private String[] columnNames = {"ISBN", "Title", "Borrowed Period", "Total Copies"};
    private JPanel basePanel;
    private JPanel bodyPanel;
    private JTextField isbnTextField;



    public Booklist(int width, int height){
        setSize(width, height);
        basePanel.add(searchPanel, BorderLayout.NORTH);
        reload();
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
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
                        Book book = Book.findBook(isbnTextField.getText());
                        Object[] bookArray = {book};
                        ArrayList<Object> objectList = new ArrayList<>(Arrays.asList(bookArray));
                        createTableList(resultPanel, objectList);
                    }
                }
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if(isbnTextField.getText().length() == 0){
                        reload();
                    }
                }
                else{
                    reload();
                }
            }
        });
    }

    private void reload(){
        var objects = Book.findAllBooks();
        Object[] bookArray = objects.toArray();
        ArrayList<Object> objectList = new ArrayList<>(Arrays.asList(bookArray));
        createTableList(resultPanel, objectList);
    }

    private void createTableList(JPanel panel, ArrayList<Object> data){
        resultPanel.removeAll();
        resultPanel.repaint();
        resultPanel.revalidate();

        panel = new JPanel();
        Utility.CustomizeTableModel customize = new Utility.CustomizeTableModel(data, columnNames);
        customize.fireTableDataChanged(); // Notify JTable of changes
        JTable table = new JTable(customize);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        resultPanel.add(panel, BorderLayout.CENTER);
    }
}
