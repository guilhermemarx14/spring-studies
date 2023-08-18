package com.guilhermemarx14.algafoodapi.infrastructure.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.places.City;
import com.guilhermemarx14.algafoodapi.domain.repository.CityRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<City> list() {
        return manager.createQuery("from City", City.class).getResultList();
    }

    @Transactional
    @Override
    public City save(City city) {
        return manager.merge(city);
    }

    @Override
    public City findById(Long id) {
        return manager.find(City.class, id);
    }

    @Transactional
    @Override
    public void delete(City city) {
        manager.remove(findById(city.getId()));
    }
}
