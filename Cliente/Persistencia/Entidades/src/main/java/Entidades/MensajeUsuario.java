package Entidades;

import java.util.Date;
import java.util.UUID;

public class MensajeUsuario {
    private UUID id;
    private MensajeTexto mensajeTexto;
    private MensajeArchivo mensajeArchivo;
    private Usuario remitente;
    private Usuario destinatario;
    private Date timestamp;

    public MensajeUsuario(UUID id, MensajeTexto mensajeTexto, MensajeArchivo mensajeArchivo,
                          Usuario remitente, Usuario destinatario, Date timestamp) {
        this.id = id;
        this.mensajeTexto = mensajeTexto;
        this.mensajeArchivo = mensajeArchivo;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return id;
    }

    public MensajeTexto getMensajeTexto() {
        return mensajeTexto;
    }

    public MensajeArchivo getMensajeArchivo() {
        return mensajeArchivo;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
