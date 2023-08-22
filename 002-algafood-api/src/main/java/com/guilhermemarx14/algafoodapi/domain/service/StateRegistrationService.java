package com.guilhermemarx14.algafoodapi.domain.service;

import com.guilhermemarx14.algafoodapi.domain.entity.places.State;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityInUseException;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityNotFoundException;
import com.guilhermemarx14.algafoodapi.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class StateRegistrationService {
    @Autowired
    StateRepository stateRepository;

    public State save(State state) {
        return stateRepository.save(state);
    }

    public void delete(Long id) {
        try {
            stateRepository.delete(id);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("The state " + id + " does not exist");
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException("There are cities using the state " + id);
        }
    }
}
