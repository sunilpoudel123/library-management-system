import com.miu.person.LibraryMember;
import com.miu.person.Member;
import member.MemberCheckoutRecord;
import utility.Utility;

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
    private String[] columnNames = {"First Name", "Last Name", "Phone Number", "Address"};


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

        Utility.CustomizeTableModel customize = new Utility.CustomizeTableModel(memberList, columnNames);
        JTable table = new JTable(customize);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);
        resultPanel.add(panel, BorderLayout.CENTER);
    }

}
