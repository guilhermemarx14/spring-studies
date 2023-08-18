package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> list();

    Restaurant save(Restaurant restaurant);

    Restaurant findById(Long id);

    void delete(Restaurant restaurant);

}
