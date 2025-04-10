package Entidades;

import java.util.UUID;

public class MiembroCanal {
    private UUID id;
    private String nombreMiembro;
    private boolean estadoConexion;
    private UUID idCanal;

    public MiembroCanal(UUID id, String nombreMiembro, boolean estadoConexion, UUID idCanal) {
        this.id = id;
        this.nombreMiembro = nombreMiembro;
        this.estadoConexion = estadoConexion;
        this.idCanal = idCanal;
    }

    public UUID getId() {
        return id;
    }

    public String getNombreMiembro() {
        return nombreMiembro;
    }

    public boolean isEstadoConexion() {
        return estadoConexion;
    }

    public UUID getIdCanal() {
        return idCanal;
    }
}
