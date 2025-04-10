package vistaEscritorio.Register;

import java.net.InetAddress;
import javax.swing.*;

public class RegisterView extends JFrame {

    private final RegisterFormPanel formPanel = new RegisterFormPanel();

    public RegisterView() {
        setTitle("CHAT CLIENT");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(formPanel);
    }

    public void addListeners(RegisterViewListener listener) {
        formPanel.getRegisterButton().addActionListener(e -> listener.onRegisterClicked());
        formPanel.getBackToLoginButton().addActionListener(e -> listener.onBackToLoginClicked());
        formPanel.getUploadButton().addActionListener(e -> listener.onUploadPictureClicked());
        formPanel.getNoPictureButton().addActionListener(e -> listener.onNoPictureClicked());
    }

    public String getUsername() {
        return formPanel.getUsername();
    }

    public String getEmail() {
        return formPanel.getEmail();
    }

    public String getPassword() {
        return formPanel.getPassword();
    }

    public String getConfirmPassword() {
        return formPanel.getConfirmPassword();
    }

    public byte[] getProfilePicture() {
        return formPanel.getProfilePictureData();
    }

    public String getIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "127.0.0.1"; // IP por defecto en caso de error
        }
    }
}
