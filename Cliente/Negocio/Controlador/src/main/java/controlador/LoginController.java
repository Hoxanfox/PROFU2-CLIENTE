package controlador;

import navegacion.ViewNavigator;
import vistaEscritorio.login.LoginView;
import gestionUsuarios.login.LoginService;
import dto.login.LoginDTO;

public class LoginController {

    private final LoginView view;
    private final LoginService service;

    public LoginController(LoginView view, LoginService service) {
        this.view = view;
        this.service = service;

        initController();
    }

    private void initController() {
        view.getLoginButton().addActionListener(e -> login());
        view.getRegisterButton().addActionListener(e -> register());
    }

    private void login() {
        String username = view.getUsername();
        String password = view.getPassword();
        LoginDTO dto = new LoginDTO(username, password);

        boolean success = service.authenticate(dto);

        if (success) {
            view.setStatus("Login successful!");
            view.dispose(); // Cerramos la vista de login
            ViewNavigator.showMainChatView(username);
        } else {
            view.setStatus("Login failed!");
        }
    }

    private void register() {
        view.setStatus("Redirecting to registration...");
        view.dispose();
        ViewNavigator.showRegisterView(); // Sin ciclo
    }
}
