package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-07-12.
 */
public class Login {
    private String userName;
    private String password;
    private String role;//表示用户类型

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
