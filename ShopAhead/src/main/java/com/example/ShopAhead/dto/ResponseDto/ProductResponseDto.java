package com.example.ShopAhead.dto.ResponseDto;

import com.example.ShopAhead.Enum.ProductCategory;
import com.example.ShopAhead.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponseDto {

    String productName;

    String sellerName;

    int price;

    int quantityAvailable;

    ProductCategory category;

    ProductStatus productStatus;
}
