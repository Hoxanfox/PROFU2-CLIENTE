package fabric;

import controlador.ChannelCreateController;
import controlador.LoginController;
import controlador.RegisterController;
import gestionUsuarios.ChannelService;
import gestionUsuarios.login.LoginService;
import gestionUsuarios.register.RegisterService;
import navegacion.ViewNavigator;
import vistaEscritorio.ChannelCreateWindow.ChannelCreateWindow;
import vistaEscritorio.Register.RegisterView;
import vistaEscritorio.login.LoginView;

public class AppFactory {

    public static void initApp() {
        configureNavigator();  // Asegúrate de llamarlo al inicio
        showLoginView();
    }

    public static void showLoginView() {
        LoginView loginView = new LoginView();
        LoginService loginService = new LoginService();
        new LoginController(loginView, loginService);
        loginView.setVisible(true);
    }

    public static void showRegisterView() {
        RegisterView registerView = new RegisterView();
        RegisterService registerService = new RegisterService();
        new RegisterController(registerView, registerService);
        registerView.setVisible(true);
    }

    public static void showChannelCreateView() {
        // Simular usuarios hasta que lo obtengas de un servicio real
        String[] allUsers = {"alice123", "bob_smith", "mike_t", "sara_l"};

        ChannelCreateWindow window = new ChannelCreateWindow(allUsers);
        ChannelService channelService = new ChannelService(); // o inyectado si ya lo manejas
        new ChannelCreateController(channelService, window.getFormPanel());
    }

    public static void configureNavigator() {
        ViewNavigator.setLoginViewSupplier(AppFactory::showLoginView);
        ViewNavigator.setRegisterViewSupplier(AppFactory::showRegisterView);
        ViewNavigator.setChannelCreateViewSupplier(AppFactory::showChannelCreateView);
    }
}
