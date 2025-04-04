package com.example.edstem.Repository;

import com.example.edstem.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, String> {
}
