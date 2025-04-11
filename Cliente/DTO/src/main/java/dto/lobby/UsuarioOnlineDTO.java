package dto.lobby;

public class UsuarioOnlineDTO {
    private String nombreUsuario;
    private String estado; // Por ejemplo: "online", "away", etc.
    private int id; // Si tienes un identificador único

    public UsuarioOnlineDTO(String nombreUsuario, String estado, int id) {
        this.nombreUsuario = nombreUsuario;
        this.estado = estado;
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "🟢 " + nombreUsuario;
    }
}
