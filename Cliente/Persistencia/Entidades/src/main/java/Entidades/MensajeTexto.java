package Entidades;

import java.util.UUID;

public class MensajeTexto {
    private UUID id;
    private String contenido;

    public MensajeTexto(UUID id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public UUID getId() {
        return id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
