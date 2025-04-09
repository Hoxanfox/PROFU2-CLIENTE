package fabric;

import controlador.LoginController;
import gestionUsuarios.LoginService;
import vistaEscritorio.login.LoginView;

import javax.swing.*;

public class LoginFactory {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginService service = new LoginService();
            LoginView view = new LoginView();
            LoginController controller = new LoginController(view, service);
            view.setVisible(true);
        });
    }
}
