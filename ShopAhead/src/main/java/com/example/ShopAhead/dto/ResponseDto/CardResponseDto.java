package com.example.ShopAhead.dto.ResponseDto;

import com.example.ShopAhead.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CardResponseDto {

    String customerName;

    CardType cardType;

    String cardNo;

    Date validTill;

}
