package gestionUsuarios.register;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.login.LoginDTO;
import dto.register.RegisterDTO;

import java.time.ZonedDateTime;
import java.util.Base64;

public class JsonBuilder {

    public static String construirJsonRegistro(RegisterDTO dto) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String fotoBase64 = dto.getProfilePicture() != null
                ? Base64.getEncoder().encodeToString(dto.getProfilePicture())
                : "";

        ObjectNode root = mapper.createObjectNode();
        root.put("tipo_ruta", "POST");
        root.put("nombre_ruta", "REGISTER_USER");

        ObjectNode datos = root.putObject("datos");
        datos.put("nombre", dto.getUsername());
        datos.put("email", dto.getEmail());
        datos.put("password", dto.getPassword());
        datos.put("foto", fotoBase64);
        datos.put("fecha_actual", ZonedDateTime.now().toString());
        datos.put("ip", dto.getIp());

        return mapper.writeValueAsString(root);
    }

    public static String construirJsonLogin(LoginDTO loginData) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode root = mapper.createObjectNode();
        root.put("tipo_ruta", "POST");
        root.put("nombre_ruta", "LOGIN_USER");

        ObjectNode datos = root.putObject("datos");
        datos.put("email", loginData.getEmail());
        datos.put("password", loginData.getPassword());
        datos.put("fecha_actual", ZonedDateTime.now().toString());
        datos.put("ip", loginData.getIp());

        return mapper.writeValueAsString(root);
    }
}
