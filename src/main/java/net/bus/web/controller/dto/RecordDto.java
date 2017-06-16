package net.bus.web.controller.dto;

import java.util.List;

/**
 * Created by yth on 2017/6/16.
 */
public class RecordDto extends BaseResult {
    private int id;
    private String  type;
    private String date;
    private String counselor;
    private String admin;
    private String remark;
    private List<RecordDto> recordDtos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<RecordDto> getRecordDtos() {
        return recordDtos;
    }

    public void setRecordDtos(List<RecordDto> recordDtos) {
        this.recordDtos = recordDtos;
    }
}
