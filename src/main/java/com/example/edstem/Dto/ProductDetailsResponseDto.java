package com.example.edstem.Dto;

import java.awt.desktop.AppForegroundListener;
import java.math.BigDecimal;
import java.util.List;

public class ProductDetailsResponseDto {
    private String producttId;
    private BigDecimal originalPrice;
    private BigDecimal finalPrice;
    private List<AppliedDiscountsDto> appliedDiscountsDtoList;
    private BigDecimal totalSavings;
    private String status;

    public String getProducttId() {
        return producttId;
    }

    public void setProducttId(String producttId) {
        this.producttId = producttId;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public List<AppliedDiscountsDto> getAppliedDiscountsDtoList() {
        return appliedDiscountsDtoList;
    }

    public void setAppliedDiscountsDtoList(List<AppliedDiscountsDto> appliedDiscountsDtoList) {
        this.appliedDiscountsDtoList = appliedDiscountsDtoList;
    }

    public BigDecimal getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(BigDecimal totalSavings) {
        this.totalSavings = totalSavings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
