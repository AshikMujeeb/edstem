package com.example.edstem.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="quantity_discounts")
public class QuantityDiscounts {

    @Id
    @GeneratedValue()
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="min_quantity", nullable = false)
    private int minQuantity;

    @Column(name="discount_percentage", nullable = false)
    private BigDecimal discountPercentage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
