package com.example.ShopAhead.service;

import com.example.ShopAhead.Enum.ProductCategory;
import com.example.ShopAhead.dto.ResponseDto.ProductResponseDto;
import com.example.ShopAhead.dto.requestDto.ProductRequestDto;
import com.example.ShopAhead.exception.SellerNotFoundException;
import com.example.ShopAhead.model.Product;
import com.example.ShopAhead.model.Seller;
import com.example.ShopAhead.repository.ProductRepository;
import com.example.ShopAhead.repository.SellerRepository;
import com.example.ShopAhead.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {

        // first check whether the seller exists or not

       Seller seller = sellerRepository.findByEmailId(productRequestDto.getEmailId());

        if (seller == null)
            throw new SellerNotFoundException("Seller does not exists");


        // request dto -->>  entity

        Product product = ProductTransformer.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProducts().add(product);

       Seller savedSeller =  sellerRepository.save(seller);

        // entity to response entity

        List<Product> products = savedSeller.getProducts();
        Product lastSavedProduct = products.get(products.size()-1);

        return ProductTransformer.ProductToProductResponseDto(lastSavedProduct);
    }

    public List<ProductResponseDto> getProductByCategoryAndPriceGreaterThan(int price, ProductCategory category) {

        List<Product> products = productRepository.getProductByCategoryAndPriceGreaterThan(price,category);

        List<ProductResponseDto> productResponseDto = new ArrayList<>();

        for(Product p : products){
            productResponseDto.add(ProductTransformer.ProductToProductResponseDto(p));
        }

        return productResponseDto;


    }
}
