package gestionUsuarios.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.login.LoginDTO;
import dto.register.RegisterDTO;

import java.time.ZonedDateTime;
import java.util.Base64;

public class JsonBuilderLogin {

    public static String construirJsonLogin(LoginDTO dto) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode root = mapper.createObjectNode();
        root.put("tipo_ruta", "POST");
        root.put("nombre_ruta", "LOGIN_USER");

        ObjectNode datos = root.putObject("datos");
        datos.put("email", dto.getEmail());
        datos.put("password", dto.getPassword());
        datos.put("fecha_actual", dto.getFechaActual()); // ya debe venir formateada
        datos.put("ip", dto.getIp());

        return mapper.writeValueAsString(root);
    }

}
