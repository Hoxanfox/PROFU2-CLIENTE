package Entidades;

import java.util.UUID;

public class MensajeCanal {
    private UUID id;
    private MensajeTexto mensajeTexto;
    private MensajeArchivo mensajeArchivo;
    private UUID idCanal;
    private UUID idMiembroCanal;
    private String nombreMiembro;

    public MensajeCanal(UUID id, MensajeTexto mensajeTexto, UUID idCanal,
                        MensajeArchivo mensajeArchivo, UUID idMiembroCanal, String nombreMiembro) {
        this.id = id;
        this.mensajeTexto = mensajeTexto;
        this.idCanal = idCanal;
        this.mensajeArchivo = mensajeArchivo;
        this.idMiembroCanal = idMiembroCanal;
        this.nombreMiembro = nombreMiembro;
    }

    public UUID getId() {
        return id;
    }

    public MensajeTexto getMensajeTexto() {
        return mensajeTexto;
    }

    public UUID getIdCanal() {
        return idCanal;
    }

    public MensajeArchivo getMensajeArchivo() {
        return mensajeArchivo;
    }

    public UUID getIdMiembroCanal() {
        return idMiembroCanal;
    }

    public String getNombreMiembro() {
        return nombreMiembro;
    }
}
