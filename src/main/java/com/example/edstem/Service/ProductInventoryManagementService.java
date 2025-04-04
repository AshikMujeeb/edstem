package com.example.edstem.Service;

import com.example.edstem.Dto.ProductDetailsRequestDto;
import com.example.edstem.Dto.ProductDetailsResponseDto;

public interface ProductInventoryManagementService {

    ProductDetailsResponseDto fetchProductDiscountDetails(ProductDetailsRequestDto productDetailsRequestDto);
}
