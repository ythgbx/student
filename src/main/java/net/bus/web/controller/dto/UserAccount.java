package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-07-12.
 */
public class UserAccount extends BaseRequest {

    private String phone;
    private String new_phone;
    private String password;
    private String new_password;
    private String code;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNew_phone() {
        return new_phone;
    }

    public void setNew_phone(String new_phone) {
        this.new_phone = new_phone;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
