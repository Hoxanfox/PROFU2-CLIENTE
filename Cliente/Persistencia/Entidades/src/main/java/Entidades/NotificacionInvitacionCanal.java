package Entidades;

import java.util.UUID;

public class NotificacionInvitacionCanal {
    private UUID id;
    private UUID idCanal;
    private String nombreUsuario;
    private boolean estado;

    public NotificacionInvitacionCanal(UUID id, UUID idCanal, String nombreUsuario, boolean estado) {
        this.id = id;
        this.idCanal = idCanal;
        this.nombreUsuario = nombreUsuario;
        this.estado = estado;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdCanal() {
        return idCanal;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean isEstado() {
        return estado;
    }
}
