package gestionUsuarios.register;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.register.RegisterDTO;
import dto.register.RegisterResponseDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class RegisterService {

    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 9000;

    private final RegisterSender sender = new RegisterSender();

    public boolean register(RegisterDTO dto) {
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            System.out.println("❌ Las contraseñas no coinciden.");
            return false;
        }

        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            // Construye el JSON usando JsonBuilder
            String jsonStr = JsonBuilder.construirJsonRegistro(dto);

            // Envía el JSON usando RegisterSender
            sender.enviar(jsonStr, socket);

            // Leer respuesta del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String jsonResponse = reader.readLine();

            ObjectMapper mapper = new ObjectMapper();
            RegisterResponseDTO response = mapper.readValue(jsonResponse, RegisterResponseDTO.class);

            System.out.println("✅ Servidor respondió: " + response.getMensaje());

            return "éxito".equalsIgnoreCase(response.getEstado());

        } catch (Exception e) {
            System.err.println("⚠️ Error durante el registro: " + e.getMessage());
            return false;
        }
    }
}
