package com.example.ShopAhead.transformer;

import com.example.ShopAhead.Enum.ProductStatus;
import com.example.ShopAhead.dto.ResponseDto.ProductResponseDto;
import com.example.ShopAhead.dto.requestDto.ProductRequestDto;
import com.example.ShopAhead.model.Product;

public class ProductTransformer {

    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){
        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .category(productRequestDto.getCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .quantityAvailable(productRequestDto.getQuantityAvailable())
                .build();
    }

    public static ProductResponseDto ProductToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .sellerName(product.getSeller().getName())
                .price(product.getPrice())
                .quantityAvailable(product.getQuantityAvailable())
                .category(product.getCategory())
                .productStatus(product.getProductStatus())
                .build();
    }
}
