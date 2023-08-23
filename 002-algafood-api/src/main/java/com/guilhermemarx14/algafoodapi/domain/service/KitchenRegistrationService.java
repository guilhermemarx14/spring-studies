package com.guilhermemarx14.algafoodapi.domain.service;

import com.guilhermemarx14.algafoodapi.domain.entity.Kitchen;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityInUseException;
import com.guilhermemarx14.algafoodapi.domain.exception.EntityNotFoundException;
import com.guilhermemarx14.algafoodapi.domain.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class KitchenRegistrationService {

    @Autowired
    KitchenRepository kitchenRepository;

    public Kitchen save(Kitchen kitchen) {
        return kitchenRepository.save(kitchen);
    }

    public void delete(Long id) {
        try {
            kitchenRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("The kitchen " + id + " does not exist");

        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException("There are restaurants using the kitchen " + id);
        }
    }

}
