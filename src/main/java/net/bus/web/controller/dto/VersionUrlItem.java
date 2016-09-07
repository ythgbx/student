package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-09-07.
 */
public class VersionUrlItem {
    private String version;
    private String full_url;
    private String increment_url;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFull_url() {
        return full_url;
    }

    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

    public String getIncrement_url() {
        return increment_url;
    }

    public void setIncrement_url(String increment_url) {
        this.increment_url = increment_url;
    }
}
