package com.codewithmosh.store.repositories;

import com.codewithmosh.store.dtos.ProductSummary;
import com.codewithmosh.store.dtos.ProductSummaryDTO;
import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // String
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByNameStartingWith(String name);

    // Numbers
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
    List<Product> findByPriceGreaterThan(BigDecimal price);


    // Null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    // Multiple condition
    List<Product> findByDescriptionNullAndNameNull();

    // Sort
    List<Product> findByNameOrderByPriceDesc(String name);

    // Limit (Top/First)
    List<Product> findFirst5ByNameLikeOrderByPriceDesc(String name);



    @Query("select new com.codewithmosh.store.dtos.ProductSummaryDTO(p.id, p.name) from Product p where p.categories = :category")
    List<ProductSummaryDTO> findByCategories(@Param("category") Category category);
}