package dto.register;

public class RegisterDTO {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private byte[] profilePicture;
    private String ip;

    public RegisterDTO(String username, String email, String password, String confirmPassword, byte[] profilePicture, String ip) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.profilePicture = profilePicture;
        this.ip = ip;
    }

    // Getters y setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getIp() {
    this.ip = ip;
        return "";
    }
}
