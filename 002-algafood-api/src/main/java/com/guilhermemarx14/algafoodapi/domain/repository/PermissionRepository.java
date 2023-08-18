package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Permission;

import java.util.List;

public interface PermissionRepository {
    List<Permission> list();

    Permission save(Permission permission);

    Permission findById(Long id);

    void delete(Permission permission);
}
