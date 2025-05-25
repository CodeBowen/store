package com.codewithmosh.store.services;

import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.repositories.CategoryRepository;
import com.codewithmosh.store.repositories.ProductRepository;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public void addCategory() {
        var category = new Category("Electronics");

        var product = Product.builder()
                .name("Apple TV")
                .description("TV from Apple")
                .price(BigDecimal.valueOf(1000.0))
                .categories(category)
                .build();

        product.setCategories(category);
        productRepository.save(product);

    }

    @Transactional
    public void addToExistingCategory() {
        var category = categoryRepository.findById((byte) 1).orElseThrow();
        var product = Product.builder()
                .name("Samsung TV")
                .description("TV from Samsung")
                .price(BigDecimal.valueOf(1500.0))
                .categories(category)
                .build();

        productRepository.save(product);

    }

    @Transactional
    public void addToUserWishList() {
        var user = userRepository.findById(3L).orElseThrow();
        var products = productRepository.findAll();
        products.forEach(user::addToWishList);

        userRepository.save(user);
    }

    public void deleteProductById() {
        productRepository.deleteById(3L);
    }
}

