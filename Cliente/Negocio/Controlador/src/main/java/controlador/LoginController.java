package controlador;
import java.time.ZonedDateTime; // Asegúrate de importar esto

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import navegacion.ViewNavigator;
import vistaEscritorio.login.LoginView;
import gestionUsuarios.login.LoginService;
import gestionUsuarios.register.JsonBuilder;
import dto.login.LoginDTO;

import javax.swing.*;

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
        String email = view.getUsername();
        String password = view.getPassword();
        String ip = "192.168.1.100";
        String fechaActual = ZonedDateTime.now().toString(); // <<==== AQUÍ

        LoginDTO dto = new LoginDTO(email, password, fechaActual, ip);

        try {
            String responseJson = service.sendLoginRequest(dto);
            if (responseJson != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode responseNode = mapper.readTree(responseJson);

                String estado = responseNode.get("estado").asText();
                if ("éxito".equalsIgnoreCase(estado)) {
                    String nombre = responseNode.has("nombre") ? responseNode.get("nombre").asText() : "";
                    String rol = responseNode.has("rol") ? responseNode.get("rol").asText() : "";
                    String fotoBase64 = responseNode.has("foto") ? responseNode.get("foto").asText() : "";

                    view.setStatus("Bienvenido, " + nombre + " (" + rol + ")");
                    view.dispose();
                    ViewNavigator.showMainChatView(nombre);
                } else {
                    view.setStatus("Credenciales incorrectas.");
                }

            } else {
                view.setStatus("Fallo al iniciar sesión.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error de conexión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void register() {
        view.setStatus("Redirigiendo al registro...");
        view.dispose();
        ViewNavigator.showRegisterView(); // Ir al registro
    }
}
