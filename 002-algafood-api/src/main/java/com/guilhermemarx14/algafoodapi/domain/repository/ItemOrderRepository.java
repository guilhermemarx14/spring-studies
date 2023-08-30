package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {}
