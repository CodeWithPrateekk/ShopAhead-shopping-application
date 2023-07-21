package com.example.ShopAhead.dto.requestDto;

import com.example.ShopAhead.Enum.CardType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardRequestDto {


    String mobileNo;

    int cvv;

    Date validTill;


    CardType cardType;

    String cardNo;

}
