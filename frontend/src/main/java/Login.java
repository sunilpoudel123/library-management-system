import com.miu.person.User;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JPanel basePanel;
    private JPanel bodyPanel;
    private JPanel gridPanel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JTextField usernameTextField;
    private final String TITLE = "Login";

    static boolean isSuccess = false;
    private User user;
    public Login(){
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(basePanel);
        setSize(320,180);
        setLocationRelativeTo(null);
        setResizable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(usernameTextField.getText(), new String(passwordField.getPassword()));
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login(usernameTextField.getText(), new String(passwordField.getPassword()));
                }
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if(isSuccess){
                    new LMS(user);
                }
            }
        });
    }

    private void login(String username, String password){
        if(username.length() == 0 || password.length() == 0){
            JOptionPane.showMessageDialog(null, "Username or password is empty", "Empty fields", JOptionPane.WARNING_MESSAGE);
        }
        else{
            user = User.getAuthenticatedUser(username, password);
            if(user==null){
                JOptionPane.showMessageDialog(null, "Username or password is incorrect", "Invalid credential", JOptionPane.WARNING_MESSAGE);
                passwordField.setText("");
            }
            else{
                isSuccess = !isSuccess;
                this.dispose();
            }
        }
    }
}
