package net.bus.web.model.Pojo;

import java.math.BigDecimal;

/**
 * Created by Edifi_000 on 2016-11-04.
 */
public class AsyncCallBack {

    private String failed;

    public String getFailed() {
        return failed;
    }

    public void setFailed(String failed) {
        this.failed = failed;
    }

    public String getSelfTradeNo(){
        throw new RuntimeException("function not impl");
    }

    public String getPayTradeNo(){
        throw new RuntimeException("function not impl");
    }

    public BigDecimal getPay(){
        throw new RuntimeException("function not impl");
    }
}
