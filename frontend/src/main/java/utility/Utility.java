package utility;

import com.miu.person.LibraryMember;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility extends JFrame {

    final static String allowedCharsForDouble = "\\d+(\\.\\d*)?";

    public static ArrayList<String> usState = new ArrayList<>();
    static{
        // Add all US states with 2-letter abbreviations
        usState.add("AL"); // Alabama
        usState.add("AK"); // Alaska
        usState.add("AZ"); // Arizona
        usState.add("AR"); // Arkansas
        usState.add("CA"); // California
        usState.add("CO"); // Colorado
        usState.add("CT"); // Connecticut
        usState.add("DE"); // Delaware
        usState.add("FL"); // Florida
        usState.add("GA"); // Georgia
        usState.add("HI"); // Hawaii
        usState.add("ID"); // Idaho
        usState.add("IL"); // Illinois
        usState.add("IN"); // Indiana
        usState.add("IA"); // Iowa
        usState.add("KS"); // Kansas
        usState.add("KY"); // Kentucky
        usState.add("LA"); // Louisiana
        usState.add("ME"); // Maine
        usState.add("MD"); // Maryland
        usState.add("MA"); // Massachusetts
        usState.add("MI"); // Michigan
        usState.add("MN"); // Minnesota
        usState.add("MS"); // Mississippi
        usState.add("MO"); // Missouri
        usState.add("MT"); // Montana
        usState.add("NE"); // Nebraska
        usState.add("NV"); // Nevada
        usState.add("NH"); // New Hampshire
        usState.add("NJ"); // New Jersey
        usState.add("NM"); // New Mexico
        usState.add("NY"); // New York
        usState.add("NC"); // North Carolina
        usState.add("ND"); // North Dakota
        usState.add("OH"); // Ohio
        usState.add("OK"); // Oklahoma
        usState.add("OR"); // Oregon
        usState.add("PA"); // Pennsylvania
        usState.add("RI"); // Rhode Island
        usState.add("SC"); // South Carolina
        usState.add("SD"); // South Dakota
        usState.add("TN"); // Tennessee
        usState.add("TX"); // Texas
        usState.add("UT"); // Utah
        usState.add("VT"); // Vermont
        usState.add("VA"); // Virginia
        usState.add("WA"); // Washington
        usState.add("WV"); // West Virginia
        usState.add("WI"); // Wisconsin
        usState.add("WY"); // Wyoming
    }
    // Add state names and shortcuts to the ArrayList


    public static void comboBoxItemSetter(JComboBox comboBox, List listItem){
        comboBox.setSelectedIndex(-1);
        listItem.forEach(o ->
                comboBox.addItem(o.toString())
        );
        comboBox.setSelectedIndex(-1);
    }

    public static void textFieldNumericOnly(JTextComponent jTextField, boolean isDouble){
        if(isDouble){
            jTextField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    String currentText = jTextField.getText();
                    Pattern pattern = Pattern.compile(allowedCharsForDouble);
                    Matcher matcher = pattern.matcher(currentText + c); // Include the typed character in the match
                    if (!matcher.matches()) {
                        e.consume();
                    }
                }
            });
        }
        else{
            jTextField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c)) {
                        e.consume(); // Consume the event to prevent character insertion
                    }
                    else{

                    }
                }
            });
        }
    }

    public static void textFieldNumericOnly(JTextComponent jTextField, boolean isDouble, int length){
        if(isDouble){
            jTextField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if(jTextField.getText().length() == length){
                        e.consume();
                    }
                    char c = e.getKeyChar();
                    String currentText = jTextField.getText();
                    Pattern pattern = Pattern.compile(allowedCharsForDouble);
                    Matcher matcher = pattern.matcher(currentText + c); // Include the typed character in the match
                    if (!matcher.matches()) {
                        e.consume();
                    }
                }
            });
        }
        else{
            jTextField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if(jTextField.getText().length() == length){
                        e.consume();
                    }
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c)) {
                        e.consume(); // Consume the event to prevent character insertion
                    }
                }
            });
        }
    }

    public static void enableComponent(Component component, boolean enable){
        component.setEnabled(enable);
    }
    public static void enableComponent(Component[] components, boolean enable){
        for(Component component : components){
            component.setEnabled(enable);
        }
    }
    public static void resetComponent(Component[] components){
        for(Component component : components){
            if(component instanceof JTextComponent){
                JTextComponent jTextComponent = (JTextComponent)component;
                jTextComponent.setText(null);
            }
            else if (component instanceof JComboBox<?>) {
                JComboBox<?> jTextComponent = (JComboBox<?>)component;
                jTextComponent.setSelectedIndex(-1);

            }
        }
    }
    public static boolean validationComponentEmpty(Component[] components){
        for(Component component : components){
            if(component instanceof JTextComponent){
                JTextComponent jTextComponent = (JTextComponent)component;
                if(jTextComponent.getText() == null || jTextComponent.getText().length() == 0){
                    return true;
                };
            }
            else if (component instanceof JComboBox<?>) {
                JComboBox<?> jTextComponent = (JComboBox<?>)component;
                if(jTextComponent.getSelectedIndex() == -1){
                    return true;
                }
            }
        }
        return false;
    }

    public static class CustomizeTableModel extends AbstractTableModel {

        ArrayList<Object> memberList;
        private String[] columnName;

        public CustomizeTableModel(ArrayList<Object> memberList, String[] columnName) {
            this.memberList = memberList;
            this.columnName = columnName;
        }

        @Override
        public int getRowCount() {
            return memberList.size();
        }

        @Override
        public int getColumnCount() {
            return columnName.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object object = memberList.get(rowIndex);
            if(object instanceof LibraryMember){
                LibraryMember member = (LibraryMember)object;
                switch (columnIndex) {
                case 0:
                    return member.getFirstName();
                case 1:
                    return member.getLastName();
                case 2:
                    return member.getPhoneNumber();
                default:
                    return null;
                }
            }

            return null;
        }

        @Override
        public String getColumnName(int col) {
            return columnName[col];
        }

        // Getters and setters for name and age
    }
}
