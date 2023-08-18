package com.guilhermemarx14.algafoodapi.infrastructure.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Kitchen;
import com.guilhermemarx14.algafoodapi.domain.repository.KitchenRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Kitchen> list() {
         return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
    }

    @Transactional
    @Override
    public Kitchen save(Kitchen kitchen) {
        return manager.merge(kitchen);
    }


    @Override
    public Kitchen findById(Long id) {
        return manager.find(Kitchen.class, id);
    }

    @Transactional
    @Override
    public void delete(Kitchen kitchen) {
        manager.remove(findById(kitchen.getId()));
    }
}
