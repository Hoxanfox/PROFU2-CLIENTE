package gestionUsuarios;

import dto.ChannelDTO;

public class ChannelService {

    public boolean createChannel(ChannelDTO channelDTO) {
        // Aquí podría ir persistencia, validación, etc.
        System.out.println("✔ Canal creado: " + channelDTO.getChannelName());
        System.out.println("👥 Miembros: " + channelDTO.getMembers());
        return true;
    }
}
