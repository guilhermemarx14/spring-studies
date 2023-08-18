package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Kitchen;

import java.util.List;

public interface KitchenRepository {

    List<Kitchen> list();

    Kitchen save(Kitchen kitchen);

    Kitchen findById(Long id);

    void delete(Kitchen kitchen);
}
