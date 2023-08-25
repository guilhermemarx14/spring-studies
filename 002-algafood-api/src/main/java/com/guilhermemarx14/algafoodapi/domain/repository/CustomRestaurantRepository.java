package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Restaurant;

import java.math.BigDecimal;
import java.util.List;

public interface CustomRestaurantRepository {
    List<Restaurant> findByNameAndFreight(String name, BigDecimal freightRateBegin, BigDecimal freightRateEnd);

    public List<Restaurant> findCriteria(String name, BigDecimal freightRateBegin, BigDecimal freightRateEnd);

    public List<Restaurant> findByFreightNotZero(String name);

}
