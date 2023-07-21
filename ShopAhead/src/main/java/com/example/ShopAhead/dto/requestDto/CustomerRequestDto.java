package com.example.ShopAhead.dto.requestDto;

import com.example.ShopAhead.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerRequestDto {

    String name;


    String emailId;


    String mobileNo;

    Gender gender;
}
