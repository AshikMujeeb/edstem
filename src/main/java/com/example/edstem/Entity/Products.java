package com.example.edstem.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue()
    @Column(name="id", nullable = false)
    private String id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="base_price", nullable = false)
    private BigDecimal baseprice;

    @Column(name="category", nullable = false)
    private String category;

    @Column(name="available_quantity", nullable = false)
    private int availableCategory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBaseprice() {
        return baseprice;
    }

    public void setBaseprice(BigDecimal baseprice) {
        this.baseprice = baseprice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAvailableCategory() {
        return availableCategory;
    }

    public void setAvailableCategory(int availableCategory) {
        this.availableCategory = availableCategory;
    }
}
