package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.places.City;

import java.util.List;

public interface CityRepository {

    List<City> list();

    City save(City city);

    City findById(Long id);

    void delete(City city);
}
