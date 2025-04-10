package dto.register;

public class UsuarioDTO {
    private String id;
    private String nombre;
    private String email;
    private String foto;
    private String fecha_registro;
    private String ip_registro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getIp_registro() {
        return ip_registro;
    }

    public void setIp_registro(String ip_registro) {
        this.ip_registro = ip_registro;
    }
}
