package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.places.State;

import java.util.List;

public interface StateRepository {

    List<State> list();

    State save(State state);

    State findById(Long id);

    void delete(Long id);
}
