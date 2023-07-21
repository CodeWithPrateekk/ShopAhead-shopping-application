package com.example.ShopAhead.service;

import com.example.ShopAhead.dto.ResponseDto.CardResponseDto;
import com.example.ShopAhead.dto.requestDto.CardRequestDto;
import com.example.ShopAhead.exception.CustomerNotFoundException;
import com.example.ShopAhead.model.Card;
import com.example.ShopAhead.model.Customer;
import com.example.ShopAhead.repository.CustomerRepository;
import com.example.ShopAhead.transformer.CardTransformer;
import com.example.ShopAhead.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CustomerRepository customerRepository;
    public CardResponseDto addCard(CardRequestDto cardRequestDto) {
        Customer customer = customerRepository.findByMobileNo(cardRequestDto.getMobileNo());
        if(customer == null)
            throw new CustomerNotFoundException("Customer doesn't exists");

        // request dto -- >> entity

//        Card card = new Card();
//        card.setCardType(cardRequestDto.getCardType());
//        card.setCardNo(cardRequestDto.getCardNo());
//        card.setCvv(cardRequestDto.getCvv());
//        card.setValidTill(cardRequestDto.getValidTill());
//
         Card card = CardTransformer.CardRequestDtoToCard(cardRequestDto);
         card.setCustomer(customer);

        customer.getCards().add(card);
        Customer savedCustomer = customerRepository.save(customer);

        List<Card> cards = customer.getCards();
        Card latestCard = cards.get(cards.size()-1);



        // entity -- >> response dto

        CardResponseDto cardResponseDto = CardTransformer.CardToCardResponseDto(latestCard);
        cardResponseDto.setCardNo(generateMaskedCard(latestCard.getCardNo()));

        return cardResponseDto;


    }

    public  String generateMaskedCard(String cardNo){
        int cardLength = cardNo.length();
        String maskedCard = "";
        for(int i=0;i<cardLength-4;i++){
            maskedCard += 'X';
        }

        maskedCard += cardNo.substring(cardLength-4);

        return maskedCard;
    }
}
