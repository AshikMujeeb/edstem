package com.example.edstem.Dto;

import java.math.BigDecimal;

public class AppliedDiscountsDto {
    private String type;
    private BigDecimal percentage;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}