package net.bus.web.controller.dto;

import net.bus.web.model.User;

/**
 * Created by Edifi_000 on 2016-07-12.
 */
public class UserBase extends BaseResult {

    private Long id;
    private String name;
    private String photo;
    private Double lat;
    private Double lng;
    private Integer points;
    private String phone;
    private String vip_type;
    private Long expiry_date;
    private Boolean isCertification;
    private Boolean isWxBind;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }


    public String getVip_type() {
        return vip_type;
    }

    public void setVip_type(String vip_type) {
        this.vip_type = vip_type;
    }

    public Long getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Long expiry_date) {
        this.expiry_date = expiry_date;
    }

    public Boolean getCertification() {
        return isCertification;
    }

    public void setCertification(User user,String realName,String id_card) {
        if (user!=null&&realName.equals("")||id_card.equals("")){
            isCertification = false;
        }
        else {
            isCertification = true;
        }

    }

    public Boolean getWxBind() {
        return isWxBind;
    }


   

    public void setWxBind(User user,Object WxUnionId) {

        if (user!=null&&WxUnionId==null&&WxUnionId.equals("")){
            isWxBind = false;

        }
        else {
            isWxBind = false;
        }
    }

}
