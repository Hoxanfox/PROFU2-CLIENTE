package Entidades;

import java.util.UUID;

public class Usuario {
    private UUID id;
    private String nombreUsuario;

    public Usuario(UUID id, String nombreUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
    }

    public UUID getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
