package net.bus.web.model;

public class User {
    private String username;

    private String password;

    private String name;

    private Integer role;

    private String bindcourse;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getBindcourse() {
        return bindcourse;
    }

    public void setBindcourse(String bindcourse) {
        this.bindcourse = bindcourse;
    }
}