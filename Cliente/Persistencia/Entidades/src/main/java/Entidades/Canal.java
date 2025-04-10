package Entidades;

import java.util.Date;
import java.util.UUID;

public class Canal {
    private UUID id;
    private boolean privado;
    private String nombre;
    private Date fechaCreacion;
    private UUID creador;

    public Canal(UUID id, boolean privado, String nombre, Date fechaCreacion, UUID creador) {
        this.id = id;
        this.privado = privado;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.creador = creador;
    }

    public UUID getId() {
        return id;
    }

    public boolean isPrivado() {
        return privado;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public UUID getCreador() {
        return creador;
    }
}
