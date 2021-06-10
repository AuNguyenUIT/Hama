package com.hama.Hama.repository;


import com.hama.Hama.entities.CategoryEntity;
import com.hama.Hama.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}

