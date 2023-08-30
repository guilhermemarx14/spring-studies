package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
