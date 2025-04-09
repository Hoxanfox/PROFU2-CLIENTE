package vistaEscritorio.login;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel statusLabel;

    public LoginView() {
        setTitle("CHAT CLIENT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel header = new JLabel("CHAT CLIENT", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBounds(0, 10, 400, 30);
        panel.add(header);

        JButton topLoginButton = new JButton("LOGIN");
        topLoginButton.setBounds(125, 50, 150, 30);
        panel.add(topLoginButton);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 100, 100, 25);
        panel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 100, 200, 25);
        panel.add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 140, 100, 25);
        panel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 140, 200, 25);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(80, 190, 100, 30);
        panel.add(loginButton);

        registerButton = new JButton("Register Now");
        registerButton.setBounds(200, 190, 130, 30);
        panel.add(registerButton);

        statusLabel = new JLabel("Status: Ready to Connect");
        statusLabel.setBounds(100, 250, 250, 25);
        panel.add(statusLabel);

        add(panel);
    }

    // Métodos para acceder desde el controlador
    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void setStatus(String status) {
        statusLabel.setText("Status: " + status);
    }
}
