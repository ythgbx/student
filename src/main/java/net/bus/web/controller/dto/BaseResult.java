package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by sky on 16/11/29.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult implements IResult{
    private String result;
    private Object content;
    private String error;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
