package com.example.repeat_mustache.repository;

import com.example.repeat_mustache.domain.entity.Article;
import com.example.repeat_mustache.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
