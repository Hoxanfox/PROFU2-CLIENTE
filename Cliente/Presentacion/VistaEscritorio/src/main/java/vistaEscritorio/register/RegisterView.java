package vistaEscritorio.register;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {

    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton uploadButton;
    private JButton noPictureButton;
    private JButton registerButton;
    private JButton backToLoginButton;

    public RegisterView() {
        setTitle("CHAT CLIENT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel header = new JLabel("CHAT CLIENT", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBounds(0, 10, 450, 30);
        panel.add(header);

        JButton topRegisterButton = new JButton("REGISTRATION");
        topRegisterButton.setBounds(125, 50, 200, 30);
        panel.add(topRegisterButton);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 100, 100, 25);
        panel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(160, 100, 200, 25);
        panel.add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 140, 100, 25);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(160, 140, 200, 25);
        panel.add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 180, 100, 25);
        panel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(160, 180, 200, 25);
        panel.add(passwordField);

        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        confirmPassLabel.setBounds(50, 220, 120, 25);
        panel.add(confirmPassLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(160, 220, 200, 25);
        panel.add(confirmPasswordField);

        JLabel pictureLabel = new JLabel("Profile Picture:");
        pictureLabel.setBounds(50, 260, 100, 25);
        panel.add(pictureLabel);

        uploadButton = new JButton("Upload");
        uploadButton.setBounds(160, 260, 90, 25);
        panel.add(uploadButton);

        noPictureButton = new JButton("No Picture");
        noPictureButton.setBounds(270, 260, 90, 25);
        panel.add(noPictureButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(100, 320, 100, 30);
        panel.add(registerButton);

        backToLoginButton = new JButton("Back to Login");
        backToLoginButton.setBounds(230, 320, 130, 30);
        panel.add(backToLoginButton);

        add(panel);
    }

    // Getters para el controlador
    public String getUsername() {
        return usernameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getConfirmPassword() {
        return new String(confirmPasswordField.getPassword());
    }

    public JButton getUploadButton() {
        return uploadButton;
    }

    public JButton getNoPictureButton() {
        return noPictureButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getBackToLoginButton() {
        return backToLoginButton;
    }
}
