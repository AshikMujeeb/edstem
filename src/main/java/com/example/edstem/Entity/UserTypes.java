package com.example.edstem.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="user_types")
public class UserTypes {

    @Id
    @Column(name="type", nullable = false)
    private String type;

    @Column(name="discount_percentage", nullable = false)
    private BigDecimal discountPercentage;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
