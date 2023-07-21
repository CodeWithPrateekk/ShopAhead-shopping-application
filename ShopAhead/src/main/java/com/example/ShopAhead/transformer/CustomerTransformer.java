package com.example.ShopAhead.transformer;

import com.example.ShopAhead.dto.ResponseDto.CustomerResponseDto;
import com.example.ShopAhead.dto.requestDto.CustomerRequestDto;
import com.example.ShopAhead.model.Customer;
import lombok.experimental.UtilityClass;


// @UtilityClass    //  this class can never be instantiated nut not a standard practise to write
public class CustomerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .gender(customerRequestDto.getGender())
                .emailId(customerRequestDto.getEmailId())
                .mobileNo(customerRequestDto.getMobileNo()).build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer savedCustomer){

        return CustomerResponseDto.builder()
                .name(savedCustomer.getName())
                .emailId(savedCustomer.getEmailId())
                .gender(savedCustomer.getGender())
                .mobileNo(savedCustomer.getMobileNo())
                .build();
    }
}
