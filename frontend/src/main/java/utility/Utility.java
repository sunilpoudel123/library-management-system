package utility;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility extends JFrame {

    final static String allowedCharsForDouble = "\\d+(\\.\\d*)?";

    public static void comboBoxItemSetter(JComboBox comboBox, List listItem){
        comboBox.setSelectedIndex(-1);
        listItem.forEach(o ->
                comboBox.addItem(o.toString())
        );
        comboBox.setSelectedIndex(-1);
    }

    public static void textFeildNumericOnly(JTextComponent jTextField, boolean isDouble){
        if(!isDouble){
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
                        JOptionPane.showMessageDialog(null, "Number only", "Non-Numeric!", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
        }
    }
}
