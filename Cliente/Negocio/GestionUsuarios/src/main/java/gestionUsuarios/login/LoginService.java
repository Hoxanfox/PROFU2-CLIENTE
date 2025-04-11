package gestionUsuarios.login;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.login.LoginDTO;
import gestionUsuarios.register.JsonBuilder;

import java.io.*;
import java.net.Socket;

public class LoginService {

    private final String servidorIp = "192.168.1.200"; // Cambia según tu entorno
    private final int puerto = 5000;

    public boolean authenticate(LoginDTO loginData) {
        try (Socket socket = new Socket(servidorIp, puerto)) {
            String jsonEnvio = JsonBuilder.construirJsonLogin(loginData);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(output), true);
            writer.println(jsonEnvio);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String respuestaJson = reader.readLine();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode responseNode = mapper.readTree(respuestaJson);

            String estado = responseNode.get("estado").asText();
            return "éxito".equalsIgnoreCase(estado);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String sendLoginRequest(LoginDTO dto) {
        try (Socket socket = new Socket(servidorIp, puerto)) {
            String jsonEnvio = JsonBuilder.construirJsonLogin(dto);
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(output), true);
            writer.println(jsonEnvio);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String respuestaJson = reader.readLine();

            return respuestaJson;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
