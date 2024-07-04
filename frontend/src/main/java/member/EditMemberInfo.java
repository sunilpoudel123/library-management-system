package src.main.java.member;

import javax.swing.*;

public class EditMemberInfo extends JPanel {
    private JPanel basePanel;
    public EditMemberInfo(int width, int height) {
        System.out.println("I got a called Edit Member");
        setSize(width, height);
        if (getParent() != null && getParent().isVisible()) { // Check if parent is visible
            setVisible(true);
        }
        add(basePanel);
    }
}
