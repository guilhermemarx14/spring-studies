package com.guilhermemarx14.algafoodapi.api.controller;

import com.guilhermemarx14.algafoodapi.domain.entity.Restaurant;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityNotFoundException;
import com.guilhermemarx14.algafoodapi.domain.repository.RestaurantRepository;
import com.guilhermemarx14.algafoodapi.domain.service.RestaurantRegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantRegistrationService restaurantRegistrationService;

    @GetMapping
    public List<Restaurant> list() {
        return restaurantRepository.list();
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> findById(@PathVariable Long restaurantId) {
        var restaurant = restaurantRepository.findById(restaurantId);

        return !Objects.isNull(restaurant) ? ResponseEntity.ok(restaurant) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Restaurant restaurant) {

        try {
            restaurant = restaurantRegistrationService.save(restaurant);

            return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<Object> update(@PathVariable Long restaurantId, @RequestBody Restaurant restaurant) {
        var existingRestaurant = restaurantRepository.findById(restaurantId);

        if (Objects.isNull(existingRestaurant)) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(restaurant, existingRestaurant, "id");
        try {
            existingRestaurant = restaurantRegistrationService.save(existingRestaurant);

            return ResponseEntity.ok(existingRestaurant);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
