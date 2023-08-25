package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends CustomJpaRepository<Restaurant, Long>, CustomRestaurantRepository,
                                              JpaSpecificationExecutor<Restaurant> {

    List<Restaurant> findByFreightRateBetween(BigDecimal start, BigDecimal end);

    List<Restaurant> findByNameAndKitchen(String name, Long kitchenId);

    List<Restaurant> findByNameContainingAndKitchenId(String name, Long kitchenId);

    Optional<Restaurant> findFirstByNameContaining(String name);

    List<Restaurant> findTop2ByNameContaining(String name);

    Integer countByKitchenId(Long kitchenId);

}
