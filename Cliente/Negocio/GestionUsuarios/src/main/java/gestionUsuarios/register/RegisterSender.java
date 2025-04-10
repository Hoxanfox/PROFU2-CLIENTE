package gestionUsuarios.register;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class RegisterSender {

    public void enviar(String jsonStr, Socket socket) {
        try {
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println(jsonStr);

            System.out.println("📤 JSON enviado al servidor:\n" + jsonStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
