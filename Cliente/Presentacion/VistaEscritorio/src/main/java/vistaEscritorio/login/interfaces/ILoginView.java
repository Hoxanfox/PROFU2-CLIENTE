package vistaEscritorio.login.interfaces;

import javax.swing.JButton;

public interface ILoginView {
    String getUsername();
    String getPassword();
    JButton getLoginButton();
    JButton getRegisterButton();
    void setStatus(String status);
}
