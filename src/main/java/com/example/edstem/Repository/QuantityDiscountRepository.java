package com.example.edstem.Repository;

import com.example.edstem.Entity.Products;
import com.example.edstem.Entity.QuantityDiscounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuantityDiscountRepository  extends JpaRepository<QuantityDiscounts, Integer> {

    @Query(value = " select discount_percentage from quantity_discounts where min_quantity < 4 order by discount_percentage desc limit 1", nativeQuery = true)
    List<Object[]> findMaxPossibleDiscountAvailable(int quantity);
}
