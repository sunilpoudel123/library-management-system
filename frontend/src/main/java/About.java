import com.miu.person.LibraryMember;
import com.miu.person.Member;
import member.MemberCheckoutRecord;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class About extends JPanel{
    private JTextField memberIDTextField;
    private JPanel basePanel;
    private JPanel bodyPanel; // Assuming this holds other components
    private JPanel searchPanel;
    private JPanel resultPanel;

    private Member[] members = {
            new LibraryMember("Hang Kheang", "Taing", "6412230129", null),
            new LibraryMember("Tegshbayar", "Ganbat", "7029982414", null),
            new LibraryMember("Teo Teo", "Aung", "4512348811", null),
            new LibraryMember( "Sunil", "Poudel", "6414722871", null)
    };
    private ArrayList memberList = new ArrayList(Arrays.asList(members));


    public About(int width, int height){
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
        MyTableModel model = new MyTableModel(memberList);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        resultPanel.add(panel, BorderLayout.CENTER);
    }

    class MyTableModel extends AbstractTableModel {

        ArrayList<LibraryMember> memberList;
        private String[] columnNames = {"First Name", "Last Name", "Phone Number"};

        public MyTableModel(ArrayList<LibraryMember> memberList) {
            this.memberList = memberList;
        }

        @Override
        public int getRowCount() {
            return memberList.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            LibraryMember person = memberList.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return person.getFirstName();
                case 1:
                    return person.getLastName();
                case 2:
                    return person.getPhoneNumber();
                default:
                    return null;
            }
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        // Getters and setters for name and age
    }



}
