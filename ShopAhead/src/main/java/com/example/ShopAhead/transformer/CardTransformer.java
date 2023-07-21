package com.example.ShopAhead.transformer;

import com.example.ShopAhead.dto.ResponseDto.CardResponseDto;
import com.example.ShopAhead.dto.requestDto.CardRequestDto;
import com.example.ShopAhead.model.Card;

public class CardTransformer {

    public static Card CardRequestDtoToCard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cardType(cardRequestDto.getCardType())
                .cvv(cardRequestDto.getCvv())
                .validTill(cardRequestDto.getValidTill())
                .build();
    }

    public  static CardResponseDto CardToCardResponseDto(Card card){
        return  CardResponseDto.builder()
                .customerName(card.getCustomer().getName())
                .cardType(card.getCardType())
                .validTill(card.getValidTill())
                .build();
    }
}
