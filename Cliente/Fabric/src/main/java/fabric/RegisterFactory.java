package fabric;

import controlador.RegisterController;
import gestionUsuarios.register.RegisterService;
import vistaEscritorio.Register.RegisterView;

public class RegisterFactory {

    public static RegisterView createRegister() {
        RegisterView registerView = new RegisterView();
        RegisterService registerService = new RegisterService();

        // Crea el controlador que conecta la vista con el servicio
        new RegisterController(registerView, registerService);

        return registerView;
    }
}
