package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Kitchen;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KitchenRepository extends CustomJpaRepository<Kitchen, Long> {
    List<Kitchen> findByName(String name);

    Optional<Kitchen> findById(Long id);

    List<Kitchen> findByNameContaining(String name);

    boolean existsByName(String name);


}
