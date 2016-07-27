package net.bus.web.controller.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sky on 16/7/27.
 */
public class SignRecordList implements IResult {
    public SignRecordList(){
        this.list = new ArrayList<SignRecordItem>();
    }
    public List<SignRecordItem> getList() {
        return list;
    }

    public void setList(List<SignRecordItem> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    private List<SignRecordItem> list;
    private int page;
    private int total_count;
}
