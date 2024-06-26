package com.example.store_backend.repositories;

import com.example.store_backend.domain.Product;
import com.example.store_backend.dto.ProductDto;
import com.example.store_backend.enums.CategoryEnum;
import com.example.store_backend.enums.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select new com.example.store_backend.dto.ProductDto(p.productName,p.manufacturer,p.price,p.quantity) "
            + "from Product p where p.category=:categoryEnum")
    public List<ProductDto> getAllProductsInACategory(@Param("categoryEnum") CategoryEnum categoryEnum);


    @Query("select new com.example.store_backend.dto.ProductDto(p.productName,p.manufacturer,p.price,p.quantity) "
            + "from Product p where p.status=:status")
    public List<ProductDto> getProductsWithStatus(@Param("status") ProductStatus status);

    @Query("select new com.example.store_backend.dto.ProductDto(p.productName,p.manufacturer,p.price,p.quantity) "
            + "from Product p where p.seller.sellerId=:id")
    public List<ProductDto> getProductsOfASeller(@Param("id") Integer id);

}
