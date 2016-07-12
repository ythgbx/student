package net.bus.web.controller.dto;

/**
 * Created by sky on 16/7/9.
 */
public class LoginResult {

    private String session_id;
    private String result;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
