package com.example.ShopAhead.transformer;

import com.example.ShopAhead.dto.ResponseDto.SellerResponseDto;
import com.example.ShopAhead.dto.requestDto.SellerRequestDto;
import com.example.ShopAhead.model.Seller;

public class SellerTransformer {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .panNo(sellerRequestDto.getPanNo())
                .mobileNo(sellerRequestDto.getMobileNo())
                .emailId(sellerRequestDto.getEmailId())
                .gender(sellerRequestDto.getGender())
                .build();
    }

    public static SellerResponseDto SellerToSellerResponseDto(Seller seller){
        return SellerResponseDto.builder()
                .name(seller.getName())
                .emailId(seller.getEmailId())
                .build();
    }
}
