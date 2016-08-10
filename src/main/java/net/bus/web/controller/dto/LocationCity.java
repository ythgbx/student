package net.bus.web.controller.dto;

/**
 * Created by Edifi_000 on 2016-08-10.
 */
public class LocationCity extends BaseResult {

    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
