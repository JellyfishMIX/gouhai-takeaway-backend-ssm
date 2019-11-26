package com.jellyfishmix.gouhaitakeaway.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Commodity {
    // 使用引用类型的原因：避免基础类型导致的被赋默认值
    private Long id;
    private String name;
    private Integer originalPrice;
    private Integer currentPrice;
    private Boolean enable;
    private String describe;
    private Integer sum;
    private Boolean isUnderRevision;
    private Boolean isSeeMore;
    private String imgURL;
    private String imgRelativePath;

    // Getter & Setter

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

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Integer currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @JsonProperty(value = "isUnderRevision")
    public Boolean getUnderRevision() {
        return isUnderRevision;
    }

    @JsonProperty(value = "isUnderRevision")
    public void setUnderRevision(Boolean underRevision) {
        isUnderRevision = underRevision;
    }

    @JsonProperty(value = "isSeeMore")
    public Boolean getSeeMore() {
        return isSeeMore;
    }

    @JsonProperty(value = "isSeeMore")
    public void setSeeMore(Boolean seeMore) {
        isSeeMore = seeMore;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getImgRelativePath() {
        return imgRelativePath;
    }

    public void setImgRelativePath(String imgRelativePath) {
        this.imgRelativePath = imgRelativePath;
    }
}
