package gestionUsuarios.canal;

import dto.lobby.UsuarioOnlineDTO;

import java.util.List;

public class InviteService {

    public void sendInvites(List<UsuarioOnlineDTO> selectedUsers, String channelName) {
        for (UsuarioOnlineDTO user : selectedUsers) {
            // Aquí podrías agregar lógica real de envío
            System.out.println("Inviting user: " + user.getNombreUsuario() + " to channel: " + channelName);
        }
    }

    // Simula obtener usuarios online disponibles
    public List<UsuarioOnlineDTO> getAvailableUsers() {
        return List.of(
                new UsuarioOnlineDTO("alice123", "online", 1),
                new UsuarioOnlineDTO("john_doe", "online", 2),
                new UsuarioOnlineDTO("emma_j", "away", 3)
        );
    }
}
