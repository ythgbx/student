package net.bus.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Edifi_000 on 2016-09-07.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VersionResult extends BaseResult{

    private String minimum_version;
    private String current_version;
    private String back_version;
    private List<String> off_versions;
    private List<VersionUrlItem> update_urls;

    public String getMinimum_version() {
        return minimum_version;
    }

    public void setMinimum_version(String minimum_version) {
        this.minimum_version = minimum_version;
    }

    public String getCurrent_version() {
        return current_version;
    }

    public void setCurrent_version(String current_version) {
        this.current_version = current_version;
    }

    public String getBack_version() {
        return back_version;
    }

    public void setBack_version(String back_version) {
        this.back_version = back_version;
    }

    public List<VersionUrlItem> getUpdate_urls() {
        return update_urls;
    }

    public void setUpdate_urls(List<VersionUrlItem> update_urls) {
        this.update_urls = update_urls;
    }

    public List<String> getOff_versions() {
        return off_versions;
    }

    public void setOff_versions(List<String> off_versions) {
        this.off_versions = off_versions;
    }
}
