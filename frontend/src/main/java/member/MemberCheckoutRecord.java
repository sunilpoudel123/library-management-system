package member;

import com.miu.book.Book;
import com.miu.checkout.CheckoutRecord;
import com.miu.checkout.CheckoutRecordEntry;
import utility.Utility;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class MemberCheckoutRecord extends JPanel {

    private JTextField memberIDTextField;
    private JPanel basePanel;
    private JPanel bodyPanel; // Assuming this holds other components
    private JPanel searchPanel;
    private JPanel resultPanel;

    private String[] columnNames = {"Member ID", "Member Name", "Book ISBN", "Book Title", "Checkout Date", "Due Date", "Paid Date", "Fine"};


    public MemberCheckoutRecord(int width, int height) {
        setSize(width, height);
        ArrayList<Object> object = new ArrayList<>();
        basePanel.add(searchPanel, BorderLayout.NORTH);
        reload();
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
                        JOptionPane.showMessageDialog(basePanel, "Please enter a Book ISBN", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    else{
                        CheckoutRecordEntry entry = CheckoutRecordEntry.findCheckoutEntry(Integer.parseInt(memberIDTextField.getText()));
                        Object[] bookArray = {entry};
                        ArrayList<Object> objectList = new ArrayList<>(Arrays.asList(bookArray));
                        createTableList(resultPanel, objectList);

                    }
                }
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if(memberIDTextField.getText().length() == 0){
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
        var objects = CheckoutRecord.checkoutRecordEntryList();
        Object[] entriesArray = objects.toArray();
        ArrayList<Object> objectList = new ArrayList<>(Arrays.asList(entriesArray));
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
