package com.example.ShopAhead.service;

import com.example.ShopAhead.dto.ResponseDto.CustomerResponseDto;
import com.example.ShopAhead.dto.requestDto.CustomerRequestDto;
import com.example.ShopAhead.model.Cart;
import com.example.ShopAhead.model.Customer;
import com.example.ShopAhead.repository.CustomerRepository;
import com.example.ShopAhead.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
        // dto --->> entity

        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);

        // creating builders and setting entity values

        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer); // saves both cart and customer

        // entity -- >> response dto    using builder class



        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);

    }
}
