package dto.login;


public class LoginDTO {
    private String email;
    private String password;
    private String fechaActual;
    private String ip;

    public LoginDTO(String email, String password, String fechaActual, String ip) {
        this.email = email;
        this.password = password;
        this.fechaActual = fechaActual;
        this.ip = ip;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFechaActual() { return fechaActual; }
    public String getIp() { return ip; }
}
