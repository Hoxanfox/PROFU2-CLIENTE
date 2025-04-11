package gestionUsuarios.lobby;

import dto.lobby.ChannelDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChannelService {

    // Simulación de canales del usuario actual
    public List<ChannelDTO> getUserChannels(String username) {
        // Ejemplo fijo. Aquí iría una consulta a base de datos o API.
        List<ChannelDTO> channels = new ArrayList<>();
        channels.add(new ChannelDTO("Team Alpha", Arrays.asList("john_doe", "alice123", "bob_smith")));
        channels.add(new ChannelDTO("QA Squad", Arrays.asList("emma_j", "john_doe")));
        return channels;
    }
    public boolean createChannel(ChannelDTO channelDTO) {
        // Aquí pones tu lógica para crear un canal, por ahora algo simple:
        System.out.println("Creando canal: " + channelDTO.getName() + " con miembros: " + channelDTO.getMembers());
        return true; // cambiar por lógica real
    }


    public ChannelDTO getChannelDetails(String name) {
        // Aquí buscarías el canal por nombre (en base de datos por ejemplo)
        if (name.equals("Team Alpha")) {
            return new ChannelDTO("Team Alpha", Arrays.asList("john_doe", "alice123", "bob_smith"));
        } else if (name.equals("QA Squad")) {
            return new ChannelDTO("QA Squad", Arrays.asList("emma_j", "john_doe"));
        }
        return null;
    }

    public String[] getChannelsForUser(String nombreUsuario) {
        List<ChannelDTO> channels = getUserChannels(nombreUsuario);
        List<String> channelNames = new ArrayList<>();

        for (ChannelDTO channel : channels) {
            if (channel.getMembers().contains(nombreUsuario)) {
                channelNames.add(channel.getName());
            }
        }

        return channelNames.toArray(new String[0]);
    }

}
