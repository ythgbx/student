package net.bus.web.controller.dto;

/**
 * Created by sky on 16/12/2.
 */
public class UserAccount extends BaseResult{
    private String id;
    private String password;
    private String new_password;
    private String username;
    private String name;
    private String bindcourse;
    private String idCard;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBindcourse() {
        return bindcourse;
    }

    public void setBindcourse(String bindcourse) {
        this.bindcourse = bindcourse;
    }
}
