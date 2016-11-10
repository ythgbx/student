package net.bus.web.model;

import java.math.BigDecimal;
import java.util.Date;

public class Commodity {
    private Long id;

    private String name;

    private String depict;

    private BigDecimal price;

    private Integer amount;

    private String itemImg;

    private String img;

    private Integer point;

    private Integer couponType;

    private Long typeId;

    private Date activeTime;

    private Integer flag;

    public Commodity() {
    }

    public Commodity(String name, String depict, BigDecimal price, Integer amount, String itemImg, String img, Integer point, Integer couponType, Long typeId,Date activeTime) {
        this.name = name;
        this.depict = depict;
        this.price = price;
        this.amount = amount;
        this.itemImg = itemImg;
        this.img = img;
        this.point = point;
        this.couponType = couponType;
        this.typeId = typeId;
        this.activeTime = activeTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}