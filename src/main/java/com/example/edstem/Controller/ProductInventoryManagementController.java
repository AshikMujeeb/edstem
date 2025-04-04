package com.example.edstem.Controller;

import com.example.edstem.Dto.ProductDetailsRequestDto;
import com.example.edstem.Dto.ProductDetailsResponseDto;
import com.example.edstem.Service.ProductInventoryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductInventoryManagementController {

    @Autowired
    ProductInventoryManagementService productInventoryManagementService;

    @PostMapping("/price-calculation")
    public ResponseEntity<Object> getProductDetails(@RequestBody ProductDetailsRequestDto productDetailsRequestDto){
        if(productDetailsRequestDto!=null&&productDetailsRequestDto.getQuantity()>0){

            ProductDetailsResponseDto productDetailsResponseDto = productInventoryManagementService.fetchProductDiscountDetails(productDetailsRequestDto);
            if(productDetailsResponseDto!=null)
                return ResponseEntity.ok(productDetailsResponseDto);
            else
                return ResponseEntity.badRequest().body(" NOT FOUND ");
        }else
            return ResponseEntity.badRequest().body(" INVALID PRODUCTID ");
    }
}
