import book.AddBookCopied;
import book.BookCheckOut;
import book.ImportBook;
import member.EditMemberInformation;
import member.MemberCheckoutRecord;
import member.MemberRegistration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

import static java.lang.StringTemplate.STR;

public class LMS extends JFrame {

    private final String TITLE = "Library Management System";
    private JPanel basePanel;


    /*Menu*/
    private final JMenu homeMenu = new JMenu("Home");
    private final JMenu memberMenu = new JMenu("Member");
    private final JMenu bookMenu = new JMenu("Book");
    private final JMenu aboutMenu = new JMenu("About");
    private final JMenu[] mainMenus = {homeMenu, memberMenu, bookMenu, aboutMenu};

    /*Menu Item*/
    private final JMenuItem addMemberItemMenu = new JMenuItem("Add Member");
    private final JMenuItem editMemberItemMenu = new JMenuItem("Edit Member");
    private final JMenuItem viewCheckoutRecordItemMenu = new JMenuItem("View Checkout Record");

    private final JMenuItem[] memberMenuItems = {addMemberItemMenu, editMemberItemMenu, viewCheckoutRecordItemMenu};

    private final JMenuItem addBookItemMenu = new JMenuItem("Add Book");
    private final JMenuItem addCopyBookItemMenu = new JMenuItem("Add Copied Book");
    private final JMenuItem checkoutBookItemMenu = new JMenuItem("Checkout Book");
    private final JMenuItem viewBookItemMenu = new JMenuItem("List All the Book");
    private final JMenuItem searchBookItemMenu = new JMenuItem("Search Book");

    private JMenuBar mainMenu;
    private JPanel menuPanel;
    private JPanel dynamicView;

    private final JMenuItem[] bookMenuItems = {addBookItemMenu, addCopyBookItemMenu, checkoutBookItemMenu, viewBookItemMenu, searchBookItemMenu};

    public LMS(String username){

        setTitle(STR."\{TITLE} \{username}");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        createMenuItem(memberMenu, memberMenuItems);
        createMenuItem(bookMenu, bookMenuItems);

        dynamicView.setLayout(new CardLayout());

        mainMenu = createMenuBar();
        setJMenuBar(mainMenu);
        setContentPane(basePanel);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        homeMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dynamicView.removeAll();
                dynamicView.repaint();
                dynamicView.revalidate();

            }
        });

        addMemberItemMenu.addActionListener(e ->{
            MemberRegistration memberRegistration = new MemberRegistration(dynamicView.getWidth(), dynamicView.getHeight());
            setDynamicView(memberRegistration);
        });

        editMemberItemMenu.addActionListener(e ->{
            EditMemberInformation editMemberInformation = new EditMemberInformation(dynamicView.getWidth(), dynamicView.getHeight());
            setDynamicView(editMemberInformation);
        });

        viewCheckoutRecordItemMenu.addActionListener(e->{
            MemberCheckoutRecord memberCheckoutRecord = new MemberCheckoutRecord(dynamicView.getWidth(), dynamicView.getHeight());
            setDynamicView(memberCheckoutRecord);
        });

        /*Start Book function*/

        addBookItemMenu.addActionListener(e ->{
            ImportBook importBook = new ImportBook(dynamicView.getWidth(), dynamicView.getHeight());
            setDynamicView(importBook);
        });

        addCopyBookItemMenu.addActionListener(e ->{
            AddBookCopied addBookCopied = new AddBookCopied(dynamicView.getWidth(), dynamicView.getHeight());
            setDynamicView(addBookCopied);
        });

        checkoutBookItemMenu.addActionListener(e->{
            BookCheckOut bookCheckOut = new BookCheckOut(dynamicView.getWidth(), dynamicView.getHeight());
            setDynamicView(bookCheckOut);
        });

        /*End Book function*/

    }

    private void setDynamicView(JPanel newDynamicView){
        dynamicView.removeAll();
        dynamicView.repaint();
        dynamicView.add(newDynamicView, ""); // Add panel with a name for card layout
        CardLayout cardLayout = (CardLayout) (dynamicView.getLayout());
        cardLayout.show(dynamicView, ""); // Show the added panel
        dynamicView.revalidate();
    }

    private void createMenuItem(JMenu menu, JMenuItem[] items){
        for(JMenuItem item : items){
            menu.add(item);
        }
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        for(JMenu menuItem : mainMenus){
            menuBar.add(menuItem);
        }
        return menuBar;
    }
}
