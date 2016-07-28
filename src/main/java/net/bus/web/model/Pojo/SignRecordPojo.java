package net.bus.web.model.Pojo;

import java.util.Date;

/**
 * Created by sky on 16/7/28.
 */
public class SignRecordPojo {
    private long userId;
    private String type;
    private String source;
    private String remark;
    private int account;
    private Date record_time;
    private int succession;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public Date getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Date record_time) {
        this.record_time = record_time;
    }

    public int getSuccession() {
        return succession;
    }

    public void setSuccession(int succession) {
        this.succession = succession;
    }
}
