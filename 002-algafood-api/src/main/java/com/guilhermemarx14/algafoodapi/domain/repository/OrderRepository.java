package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
