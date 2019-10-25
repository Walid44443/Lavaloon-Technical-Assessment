package codes.walid4444.lavaloon.toggl.Remote.Models;

public class LoginDataModel {
    String user;
    String password;
    String Token;

    public LoginDataModel(String user, String password, String token) {
        this.user = user;
        this.password = password;
        Token = token;
    }

    public LoginDataModel(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public LoginDataModel(String token) {
        Token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
