package src.main.java;


import src.main.java.member.CreateNewMember;
import src.main.java.member.EditMemberInfo;

import javax.swing.*;
import java.awt.*;

public class LSM extends JFrame {


    private final String TITLE = "Library Management System";
    private JPanel basePanel;

    private CreateNewMember createNewMember;
    private EditMemberInfo editMemberInfo;

    /*Menu*/
    private JMenu fileMenu = new JMenu("File");
    private JMenu memberMenu = new JMenu("Member");
    private JMenu bookMenu = new JMenu("Book");
    private JMenu checkoutMenu = new JMenu("Checkout");
    private JMenu aboutMenu = new JMenu("About");
    private JMenu[] mainMenus = {fileMenu, memberMenu, bookMenu, checkoutMenu, aboutMenu};

    /*Menu Item*/
    private JMenuItem addMemberItemMenu = new JMenuItem("Add Member");
    private JMenuItem editMemberItemMenu = new JMenuItem("Edit Member");
    private JMenuItem viewMemberItemMenu = new JMenuItem("List All the Member");
    private JMenuItem searchMemberItemMenu = new JMenuItem("Search Member");

    private JMenuItem[] memberMenuItems = {addMemberItemMenu, editMemberItemMenu, viewMemberItemMenu, searchMemberItemMenu};

    private JMenuItem addBookItemMenu = new JMenuItem("Add Book");
    private JMenuItem editBookItemMenu = new JMenuItem("Edit Book");
    private JMenuItem addCopyBookItemMenu = new JMenuItem("Add Copied Book");
    private JMenuItem viewBookItemMenu = new JMenuItem("List All the Book");
    private JMenuItem searchBookItemMenu = new JMenuItem("Search Book");
    private JMenuItem editCopyBookItemMenu = new JMenuItem("Edit Copied Book");

    private JMenuBar mainMenu;
    private JPanel menuPanel;
    private JPanel dynamicView;

    private JMenuItem[] bookMenuItems = {addBookItemMenu, editBookItemMenu, addCopyBookItemMenu, viewBookItemMenu, searchBookItemMenu, editCopyBookItemMenu};


    public LSM(String username) {
        setTitle(TITLE + " (" + username + ")");
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


        addMemberItemMenu.addActionListener(e -> {
            createNewMember = new CreateNewMember(dynamicView.getWidth(), dynamicView.getHeight());
            setDynamicView(createNewMember);
        });
        editMemberItemMenu.addActionListener(e -> {
            editMemberInfo = new EditMemberInfo(dynamicView.getWidth(), dynamicView.getHeight());
            setDynamicView(editMemberInfo);
        });
    }

    private void setDynamicView(JPanel newDynamicView) {
        dynamicView.removeAll();
        System.out.println(newDynamicView.getClass().getName());
        dynamicView.add(newDynamicView, ""); // Add panel with a name for card layout
        CardLayout cardLayout = (CardLayout) (dynamicView.getLayout());
        cardLayout.show(dynamicView, ""); // Show the added panel
        dynamicView.revalidate();
    }

    private void createMenuItem(JMenu menu, JMenuItem[] items) {
        for (JMenuItem item : items) {
            menu.add(item);
        }
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        for (JMenu menuItem : mainMenus) {
            menuBar.add(menuItem);
        }
        return menuBar;
    }
}
