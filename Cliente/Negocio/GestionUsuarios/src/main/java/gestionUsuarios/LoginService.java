package gestionUsuarios;

import dto.LoginDTO;

public class LoginService {

    // Aquí podrías simular una validación contra una base de datos
    public boolean authenticate(LoginDTO loginData) {
        String username = loginData.getUsername();
        String password = loginData.getPassword();

        // Simulación: usuario "admin", contraseña "1234"
        return "admin".equals(username) && "1234".equals(password);
    }
}
