package Entidades;

import java.util.UUID;

public class MensajeArchivo {
    private UUID id;
    private byte[] binario;
    private int tamaño;

    public MensajeArchivo(UUID id, byte[] binario, int tamaño) {
        this.id = id;
        this.binario = binario;
        this.tamaño = tamaño;
    }

    public UUID getId() {
        return id;
    }

    public byte[] getBinario() {
        return binario;
    }

    public int getTamaño() {
        return tamaño;
    }
}
