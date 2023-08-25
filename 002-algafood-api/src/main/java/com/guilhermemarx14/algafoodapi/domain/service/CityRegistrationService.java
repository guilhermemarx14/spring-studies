package com.guilhermemarx14.algafoodapi.domain.service;

import com.guilhermemarx14.algafoodapi.domain.entity.places.City;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityNotFoundException;
import com.guilhermemarx14.algafoodapi.domain.repository.CityRepository;
import com.guilhermemarx14.algafoodapi.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CityRegistrationService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateRepository stateRepository;

    public City save(City city) {
        var stateId = city
                .getState()
                .getId();

        var stateFoundOptional = stateRepository.findById(stateId);

        if (stateFoundOptional.isEmpty()) {
            throw new EntityNotFoundException("The State " + stateId + " does not exist");
        }

        city.setState(stateFoundOptional.get());
        return cityRepository.save(city);
    }

    public void delete(Long id) {

        try {
            cityRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("The kitchen " + id + " does not exist");

        }
    }


}
