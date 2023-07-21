package com.example.ShopAhead.controller;

import com.example.ShopAhead.Enum.ProductCategory;
import com.example.ShopAhead.dto.ResponseDto.ProductResponseDto;
import com.example.ShopAhead.dto.requestDto.ProductRequestDto;
import com.example.ShopAhead.model.Product;
import com.example.ShopAhead.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto) {
        try {
            ProductResponseDto productResponseDto = productService.addProduct(productRequestDto);
            return new ResponseEntity(productResponseDto, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-by-category-and-price-greater-than")
    public ResponseEntity getProductByCategoryAndPriceGreaterThan(@RequestParam("price") int price , @RequestParam("category") ProductCategory category){
        List<ProductResponseDto> productResponseDtoList = productService.getProductByCategoryAndPriceGreaterThan(price,category);

        return  new ResponseEntity(productResponseDtoList,HttpStatus.CREATED);
    }
}
