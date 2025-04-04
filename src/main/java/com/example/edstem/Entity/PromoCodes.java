package com.example.edstem.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.util.Date;

@Entity
@Table(name="promo_codes")
public class PromoCodes {

    @Id
    @GeneratedValue()
    @Column(name="code", nullable = false)
    private String code;

    @Column(name="discount_percentage", nullable = false)
    private BigDecimal discountPercentage;

    @Column(name="active", nullable = false)
    private boolean active;

    @Column(name="valid_until", nullable = false)
    private Date validUntil;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }
}
