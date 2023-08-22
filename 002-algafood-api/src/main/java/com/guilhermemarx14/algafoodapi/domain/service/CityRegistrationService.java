package com.guilhermemarx14.algafoodapi.domain.service;

import com.guilhermemarx14.algafoodapi.domain.entity.places.City;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityNotFoundException;
import com.guilhermemarx14.algafoodapi.domain.repository.CityRepository;
import com.guilhermemarx14.algafoodapi.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CityRegistrationService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateRepository stateRepository;

    public City save(City city) {
        var stateId = city.getState().getId();

        var stateFound = stateRepository.findById(stateId);

        if (Objects.isNull(stateFound)) {
            throw new EntityNotFoundException("The State " + stateId + " does not exist");
        }

        city.setState(stateFound);
        return cityRepository.save(city);
    }

    public void delete(Long id) {
        var city = cityRepository.findById(id);

        if (Objects.isNull(city)) {
            throw new EntityNotFoundException("The city " + id + " does not exist");
        }

        cityRepository.delete(id);

    }


}
