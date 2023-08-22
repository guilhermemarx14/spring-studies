package com.guilhermemarx14.algafoodapi.api.controller;

import com.guilhermemarx14.algafoodapi.domain.entity.places.State;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityInUseException;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityNotFoundException;
import com.guilhermemarx14.algafoodapi.domain.repository.StateRepository;
import com.guilhermemarx14.algafoodapi.domain.service.StateRegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    StateRegistrationService stateRegistrationService;

    @GetMapping
    public List<State> list() {
        return stateRepository.list();
    }

    @GetMapping("/{stateId}")
    public ResponseEntity<State> findById(@PathVariable Long stateId) {
        var state = stateRepository.findById(stateId);

        if (Objects.isNull(state)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(stateRepository.findById(stateId));
    }

    @PutMapping("/{stateId}")
    public ResponseEntity<State> update(@PathVariable Long stateId, @RequestBody State state) {
        var existingState = stateRepository.findById(stateId);

        if (Objects.isNull(existingState)) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(state, existingState, "id");
        existingState = stateRegistrationService.save(existingState);
        return ResponseEntity.ok(existingState);
    }

    @PostMapping
    public ResponseEntity<State> save(@RequestBody State state) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stateRegistrationService.save(state));
    }

    @DeleteMapping("/{stateId}")
    public ResponseEntity<State> delete(@PathVariable Long stateId) {
        try {
            stateRegistrationService.delete(stateId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
