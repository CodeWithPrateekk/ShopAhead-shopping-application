package com.example.ShopAhead.dto.requestDto;

import com.example.ShopAhead.Enum.ProductCategory;
import com.example.ShopAhead.Enum.ProductStatus;
import com.example.ShopAhead.model.Seller;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequestDto {

    String emailId;

    String productName;

    int price;

    int quantityAvailable;

    ProductCategory category;


}
