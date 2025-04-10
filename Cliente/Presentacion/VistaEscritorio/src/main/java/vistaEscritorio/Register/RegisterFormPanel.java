package vistaEscritorio.Register;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class RegisterFormPanel extends JPanel {

    private final JTextField usernameField;
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;
    private final JButton uploadButton;
    private final JButton noPictureButton;
    private final JButton registerButton;
    private final JButton backButton;
    private byte[] profilePictureData;

    public RegisterFormPanel() {
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Register", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(0, 10, 400, 30);
        add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 60, 100, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 60, 200, 25);
        add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 100, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 100, 200, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 140, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 140, 200, 25);
        add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(20, 180, 130, 25);
        add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(150, 180, 200, 25);
        add(confirmPasswordField);

        uploadButton = new JButton("Upload Picture");
        uploadButton.setBounds(50, 230, 140, 30);
        uploadButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    byte[] imageBytes = Files.readAllBytes(file.toPath());
                    setProfilePictureData(imageBytes);
                    JOptionPane.showMessageDialog(this, "Imagen cargada correctamente.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error al cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(uploadButton);

        noPictureButton = new JButton("No Picture");
        noPictureButton.setBounds(210, 230, 140, 30);
        noPictureButton.addActionListener(e -> removePicture());
        add(noPictureButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(80, 280, 100, 30);
        add(registerButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 280, 100, 30);
        add(backButton);
    }

    private void setProfilePictureData(byte[] imageBytes) {
        this.profilePictureData = imageBytes;
    }

    private void removePicture() {
        profilePictureData = null;
        JOptionPane.showMessageDialog(this, "No se usará imagen de perfil.");
    }

    // Getters
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

    public byte[] getProfilePictureData() {
        return profilePictureData;
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

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getBackToLoginButton() {
        return backButton;
    }

}
