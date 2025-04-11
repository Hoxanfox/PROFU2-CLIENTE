package gestionUsuarios;

import dto.lobby.UsuarioOnlineDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ServicioUsuariosOnline {

    public interface UsuarioOnlineListener {
        void onNuevoUsuario(UsuarioOnlineDTO usuario);
    }

    private final List<UsuarioOnlineDTO> usuariosConectados = new ArrayList<>();
    private final List<UsuarioOnlineListener> listeners = new ArrayList<>();

    public void agregarListener(UsuarioOnlineListener listener) {
        listeners.add(listener);
    }

    public void simularUsuarios() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int contador = 1;

            @Override
            public void run() {
                if (contador > 5) {
                    timer.cancel(); // Para después de 5 usuarios simulados
                    return;
                }

                UsuarioOnlineDTO usuarioSimulado = new UsuarioOnlineDTO("Usuario" + contador, "online", contador);
                usuariosConectados.add(usuarioSimulado);

                for (UsuarioOnlineListener listener : listeners) {
                    listener.onNuevoUsuario(usuarioSimulado);
                }

                contador++;
            }
        }, 1000, 2000); // Empieza al segundo 1, y agrega uno cada 2 segundos
    }
}
