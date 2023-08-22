package com.guilhermemarx14.algafoodapi.infrastructure.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.places.State;
import com.guilhermemarx14.algafoodapi.domain.repository.StateRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Component
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<State> list() {
        return manager.createQuery("from State", State.class).getResultList();
    }

    @Transactional
    @Override
    public State save(State state) {
        return manager.merge(state);
    }

    @Override
    public State findById(Long id) {
        return manager.find(State.class, id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        var state = findById(id);

        if (Objects.isNull(state)) throw new EmptyResultDataAccessException(1);

        manager.remove(findById(state.getId()));
    }
}
