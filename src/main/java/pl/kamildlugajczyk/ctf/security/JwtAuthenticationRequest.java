package pl.kamildlugajczyk.ctf.security;

public class JwtAuthenticationRequest {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JwtAuthenticationRequest() {
    }

    public JwtAuthenticationRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
