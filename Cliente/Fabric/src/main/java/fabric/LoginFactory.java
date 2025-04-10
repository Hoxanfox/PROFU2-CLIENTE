package fabric;

import controlador.LoginController;
import gestionUsuarios.login.LoginService;
import vistaEscritorio.login.LoginView;

public class LoginFactory {

    public static LoginView createLogin() {
        LoginService service = new LoginService();
        LoginView view = new LoginView();
        new LoginController(view, service);
        return view;
    }
}
