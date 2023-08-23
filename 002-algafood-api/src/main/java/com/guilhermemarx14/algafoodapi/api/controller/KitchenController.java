package com.guilhermemarx14.algafoodapi.api.controller;

import com.guilhermemarx14.algafoodapi.domain.entity.Kitchen;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityInUseException;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityNotFoundException;
import com.guilhermemarx14.algafoodapi.domain.repository.KitchenRepository;
import com.guilhermemarx14.algafoodapi.domain.service.KitchenRegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {

    @Autowired
    KitchenRepository kitchenRepository;

    @Autowired
    KitchenRegistrationService kitchenRegistrationService;

    @GetMapping
    public List<Kitchen> list() {
        return kitchenRepository.findAll();
    }

    @GetMapping("/{kitchenId}")
    public ResponseEntity<Kitchen> findById(@PathVariable Long kitchenId) {
        var kitchenOptional = kitchenRepository.findById(kitchenId);

        return kitchenOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Kitchen> save(@RequestBody Kitchen kitchen) {
        return ResponseEntity.status(HttpStatus.CREATED).body(kitchenRegistrationService.save(kitchen));
    }

    @PutMapping("/{kitchenId}")
    public ResponseEntity<Kitchen> update(@PathVariable Long kitchenId, @RequestBody Kitchen kitchen) {
        var existingKitchenOptional = kitchenRepository.findById(kitchenId);

        if (existingKitchenOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(kitchen, existingKitchenOptional.get(), "id");

        return ResponseEntity.ok(kitchenRegistrationService.save(existingKitchenOptional.get()));
    }

    @DeleteMapping("/{kitchenId}")
    public ResponseEntity<Kitchen> delete(@PathVariable Long kitchenId) {

        try {
            kitchenRegistrationService.delete(kitchenId);

            return ResponseEntity.noContent().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();

        }


    }
}
