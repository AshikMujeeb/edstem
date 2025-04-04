package com.example.edstem.Repository;

import com.example.edstem.Entity.Products;
import com.example.edstem.Entity.PromoCodes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoCodeRepository  extends JpaRepository<PromoCodes, String> {
}
