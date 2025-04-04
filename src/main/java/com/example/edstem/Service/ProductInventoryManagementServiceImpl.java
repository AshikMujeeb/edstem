package com.example.edstem.Service;

import com.example.edstem.Dto.AppliedDiscountsDto;
import com.example.edstem.Dto.ProductDetailsRequestDto;
import com.example.edstem.Dto.ProductDetailsResponseDto;
import com.example.edstem.Entity.Products;
import com.example.edstem.Entity.PromoCodes;
import com.example.edstem.Entity.QuantityDiscounts;
import com.example.edstem.Entity.UserTypes;
import com.example.edstem.Repository.ProductRepository;
import com.example.edstem.Repository.PromoCodeRepository;
import com.example.edstem.Repository.QuantityDiscountRepository;
import com.example.edstem.Repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductInventoryManagementServiceImpl implements  ProductInventoryManagementService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PromoCodeRepository promoCodeRepository;

    @Autowired
    private QuantityDiscountRepository quantityDiscountRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public ProductDetailsResponseDto fetchProductDiscountDetails(ProductDetailsRequestDto productDetailsRequestDto) {
        Optional<Products> products = null;
        Optional<UserTypes> userTypes = null;
        Optional<PromoCodes> promoCodes = null;
        QuantityDiscounts quantityDiscounts = null;
        String promoCode = productDetailsRequestDto.getPromoCode();
        String userType = productDetailsRequestDto.getUserType();
        String productId = productDetailsRequestDto.getProductId();
        int quantity = productDetailsRequestDto.getQuantity();
        ProductDetailsResponseDto productDetailsResponseDto = new ProductDetailsResponseDto();
        List<AppliedDiscountsDto> discount = new ArrayList<>();
        if(StringNullCheck(productId)){
            products = productRepository.findById(productId);
            if(products.isPresent()){
                Products products1 = products.get();
                BigDecimal originalPrice = products1.getBaseprice()!=null ? products1.getBaseprice() : new BigDecimal("0.0");
                productDetailsResponseDto.setOriginalPrice(originalPrice);
            }
        }
        if(StringNullCheck(promoCode)){
            promoCodes = promoCodeRepository.findById(promoCode);
            if(promoCodes.isPresent()){
                PromoCodes promoCodes11 = promoCodes.get();
                BigDecimal discountPercentage = promoCodes11.getDiscountPercentage()!=null ? promoCodes11.getDiscountPercentage() : new BigDecimal("0.0");
                BigDecimal finalPrice = applyDiscount(productDetailsResponseDto.getOriginalPrice(), productDetailsResponseDto.getFinalPrice(), discountPercentage);
                if(discountPercentage.compareTo(BigDecimal.ZERO)>0){
                    String type = userType+"_USER";
                    AppliedDiscountsDto appliedDiscountsDto = new AppliedDiscountsDto();
                    appliedDiscountsDto.setPercentage(discountPercentage);
                    appliedDiscountsDto.setType(type);
                    discount.add(appliedDiscountsDto);
                }
                productDetailsResponseDto.setFinalPrice(finalPrice);
            }
            BigDecimal finalPrice = productDetailsResponseDto.getFinalPrice()!=null&& (productDetailsResponseDto.getFinalPrice().compareTo(new BigDecimal("0.0")) > 0) ? productDetailsResponseDto.getFinalPrice() : productDetailsResponseDto.getOriginalPrice();
        }
        if(StringNullCheck(userType)){
            userTypes = userTypeRepository.findById(userType);
            if(userTypes.isPresent()){
                UserTypes userTypes1 = userTypes.get();
                BigDecimal discountPercentage = userTypes1.getDiscountPercentage()!=null ? userTypes1.getDiscountPercentage() : new BigDecimal("0.0");
                BigDecimal finalPrice = applyDiscount(productDetailsResponseDto.getOriginalPrice(), productDetailsResponseDto.getFinalPrice(), discountPercentage);
                if(discountPercentage.compareTo(BigDecimal.ZERO)>0){
                    String type = userType+"_USER";
                    AppliedDiscountsDto appliedDiscountsDto = new AppliedDiscountsDto();
                    appliedDiscountsDto.setPercentage(discountPercentage);
                    appliedDiscountsDto.setType(type);
                    discount.add(appliedDiscountsDto);
                }
                productDetailsResponseDto.setFinalPrice(finalPrice);
            }
        }
        if(quantity>0){
            List<Object[]> quantityDiscount = quantityDiscountRepository.findMaxPossibleDiscountAvailable(quantity);
            if(quantityDiscount!=null && !quantityDiscount.isEmpty()){
                Object[] discounts = quantityDiscount.get(0);
                BigDecimal discountPercentage = discounts.length>0?(BigDecimal) discounts[0] : new BigDecimal("0.0");
                BigDecimal finalPrice = applyDiscount(productDetailsResponseDto.getOriginalPrice(), productDetailsResponseDto.getFinalPrice(), discountPercentage);
                if(discountPercentage.compareTo(BigDecimal.ZERO)>0){
                    String type = "QUANTITY_DISCOUNT";
                    AppliedDiscountsDto appliedDiscountsDto = new AppliedDiscountsDto();
                    appliedDiscountsDto.setPercentage(discountPercentage);
                    appliedDiscountsDto.setType(type);
                    discount.add(appliedDiscountsDto);
                }
                productDetailsResponseDto.setFinalPrice(finalPrice);

            }
        }
        BigDecimal totalSaving = productDetailsResponseDto.getOriginalPrice().subtract(productDetailsResponseDto.getFinalPrice(), new MathContext(2));
        productDetailsResponseDto.setTotalSavings(totalSaving);
        productDetailsResponseDto.setAppliedDiscountsDtoList(discount);
        productDetailsResponseDto.setProducttId(productId);
        return productDetailsResponseDto;
    }

    public BigDecimal applyDiscount(BigDecimal basePrice, BigDecimal finalPrice, BigDecimal discountPercentage){
        finalPrice = (finalPrice != null && finalPrice.compareTo(BigDecimal.ZERO) > 0)
                ? finalPrice
                : basePrice;

        BigDecimal discountFraction = discountPercentage.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);
        BigDecimal discountMultiplier = BigDecimal.ONE.subtract(discountFraction); // 1 - (discount / 100)

        return finalPrice.multiply(discountMultiplier).setScale(2, RoundingMode.HALF_UP);
    }

    boolean StringNullCheck(String str){
        return str!=null && !str.isBlank();
    }
}
