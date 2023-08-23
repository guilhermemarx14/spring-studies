package com.guilhermemarx14.algafoodapi.domain.service;

import com.guilhermemarx14.algafoodapi.domain.entity.Restaurant;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityInUseException;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityNotFoundException;
import com.guilhermemarx14.algafoodapi.domain.repository.KitchenRepository;
import com.guilhermemarx14.algafoodapi.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantRegistrationService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    KitchenRepository kitchenRepository;

    public Restaurant save(Restaurant restaurant) {
        var kitchenId = restaurant.getKitchen().getId();

        var kitchen = kitchenRepository.findById(kitchenId).orElseThrow(()-> new EntityNotFoundException("The kitchen " + kitchenId + " does not exist"));

        restaurant.setKitchen(kitchen);

        return restaurantRepository.save(restaurant);
    }
    public void delete(Long id) {
        try {
            restaurantRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("The kitchen " + id + " does not exist");

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException("There are restaurants using the kitchen " + id);
        }
    }
}
