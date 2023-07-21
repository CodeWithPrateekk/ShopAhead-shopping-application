package com.example.ShopAhead.repository;

import com.example.ShopAhead.Enum.ProductCategory;
import com.example.ShopAhead.model.Product;
import com.example.ShopAhead.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where p.price >= :price and p.category = :productCategory")
    public List<Product> getProductByCategoryAndPriceGreaterThan(int price, ProductCategory productCategory);


}
