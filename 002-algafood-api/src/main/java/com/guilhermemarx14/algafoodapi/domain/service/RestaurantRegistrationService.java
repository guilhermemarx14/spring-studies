package com.guilhermemarx14.algafoodapi.domain.service;

import com.guilhermemarx14.algafoodapi.domain.entity.Restaurant;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityNotFoundException;
import com.guilhermemarx14.algafoodapi.domain.repository.KitchenRepository;
import com.guilhermemarx14.algafoodapi.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RestaurantRegistrationService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    KitchenRepository kitchenRepository;

    public Restaurant save(Restaurant restaurant) {
        var kitchenId = restaurant.getKitchen().getId();

        var kitchen = kitchenRepository.findById(kitchenId);

        if (Objects.isNull(kitchen)) {
            throw new EntityNotFoundException("The kitchen " + kitchenId + " does not exist");
        }

        restaurant.setKitchen(kitchen);

        return restaurantRepository.save(restaurant);
    }

}
