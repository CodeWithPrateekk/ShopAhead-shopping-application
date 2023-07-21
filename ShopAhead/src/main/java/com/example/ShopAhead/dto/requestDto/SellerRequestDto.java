package com.example.ShopAhead.dto.requestDto;

import com.example.ShopAhead.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SellerRequestDto {
    String name;


    String emailId;


    String panNo;


    String mobileNo;


    Gender gender;
}
