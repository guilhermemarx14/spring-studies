package com.guilhermemarx14.algafoodapi.api.controller;

import com.guilhermemarx14.algafoodapi.domain.entity.places.City;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityNotFoundException;
import com.guilhermemarx14.algafoodapi.domain.repository.CityRepository;
import com.guilhermemarx14.algafoodapi.domain.service.CityRegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityRegistrationService cityRegistrationService;

    @GetMapping
    public List<City> list() {
        return cityRepository.list();
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<City> findById(@PathVariable Long cityId) {
        var city = cityRepository.findById(cityId);

        return !Objects.isNull(city) ? ResponseEntity.ok(city) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<Object> update(@PathVariable Long cityId, @RequestBody City city) {
        var existingCity = cityRepository.findById(cityId);

        if (Objects.isNull(existingCity)) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(city, existingCity, "id");

        try {
            existingCity = cityRegistrationService.save(existingCity);

            return ResponseEntity.ok(existingCity);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody City city) {
        try {
            city = cityRegistrationService.save(city);

            return ResponseEntity.status(HttpStatus.CREATED).body(city);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<City> delete(@PathVariable Long cityId) {
        try {
            cityRegistrationService.delete(cityId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
