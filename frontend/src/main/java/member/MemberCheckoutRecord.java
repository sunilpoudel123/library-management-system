package member;

import utility.Utility;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberCheckoutRecord extends JPanel {

    private JTextField memberIDTextField;
    private JPanel basePanel;
    private JPanel bodyPanel; // Assuming this holds other components
    private JPanel searchPanel;
    private JPanel resultPanel;

    public MemberCheckoutRecord(int width, int height) {
        setSize(width, height);
        ArrayList<Object> object = new ArrayList<>();
        basePanel.add(searchPanel, BorderLayout.NORTH);
        createTableList(resultPanel, object);
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }

        add(basePanel);
    }

    private void createTableList(JPanel panel, ArrayList<Object> data){
        panel = new JPanel();
        MyTableModel model = new MyTableModel(data);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        resultPanel.add(panel, BorderLayout.CENTER);
    }

    class MyTableModel extends AbstractTableModel {

        private ArrayList<Object> data;
        private String[] columnNames = {"Member Name", "Book Title", "Checkout Date", "Due Date", "Return Date", "Fine"};

        public MyTableModel(ArrayList<Object> data) {
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object person = data.get(rowIndex);
            return null;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        // Getters and setters for name and age
    }
}
