package controlador;

import dto.register.RegisterDTO;
import gestionUsuarios.register.RegisterService;
import navegacion.ViewNavigator;
import vistaEscritorio.Register.RegisterView;
import vistaEscritorio.Register.RegisterViewListener;

import javax.swing.*;

public class RegisterController implements RegisterViewListener {

    private final RegisterView view;
    private final RegisterService service;

    public RegisterController(RegisterView view, RegisterService service) {
        this.view = view;
        this.service = service;
        this.view.addListeners(this);
    }

    @Override
    public void onRegisterClicked() {
        RegisterDTO dto = new RegisterDTO(
                view.getUsername(),
                view.getEmail(),
                view.getPassword(),
                view.getConfirmPassword(),
                view.getProfilePicture(),
                view.getIp()
        );

        if (service.register(dto)) {
            JOptionPane.showMessageDialog(view, "Registro exitoso", "Info", JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
            ViewNavigator.showLoginView();
        } else {
            JOptionPane.showMessageDialog(view, "Error en el registro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @Override
    public void onBackToLoginClicked() {
        view.dispose();
        ViewNavigator.showLoginView();
    }

    @Override
    public void onUploadPictureClicked() {
        System.out.println("Subir imagen no implementado");
    }

    @Override
    public void onNoPictureClicked() {
        System.out.println("Usuario eligió no subir imagen");
    }
}
