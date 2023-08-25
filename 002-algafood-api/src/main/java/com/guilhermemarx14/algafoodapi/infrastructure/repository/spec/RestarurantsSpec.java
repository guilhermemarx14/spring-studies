package com.guilhermemarx14.algafoodapi.infrastructure.repository.spec;

import com.guilhermemarx14.algafoodapi.domain.entity.Restaurant;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class RestarurantsSpec {
    public static Specification<Restaurant> freightRateNonZero() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("freightRate"), BigDecimal.ZERO);
    }

    public static Specification<Restaurant> nameContaining(String name) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }
}
