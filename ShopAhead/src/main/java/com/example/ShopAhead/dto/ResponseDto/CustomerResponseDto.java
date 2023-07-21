package com.example.ShopAhead.dto.ResponseDto;

import com.example.ShopAhead.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerResponseDto {
    String name;


    String emailId;


    String mobileNo;

    Gender gender;
}
