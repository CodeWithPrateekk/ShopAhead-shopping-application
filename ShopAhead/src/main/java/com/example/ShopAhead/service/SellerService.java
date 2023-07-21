package com.example.ShopAhead.service;

import com.example.ShopAhead.dto.ResponseDto.SellerResponseDto;
import com.example.ShopAhead.dto.requestDto.SellerRequestDto;
import com.example.ShopAhead.model.Seller;
import com.example.ShopAhead.repository.SellerRepository;
import com.example.ShopAhead.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {

        // dto -->> entity

        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);

        // save seller to repository

       Seller savedSeller = sellerRepository.save(seller);

        return SellerTransformer.SellerToSellerResponseDto(savedSeller);


    }
}
