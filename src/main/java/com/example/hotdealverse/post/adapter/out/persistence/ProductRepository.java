package com.example.hotdealverse.post.adapter.out.persistence;

import com.example.hotdealverse.post.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
