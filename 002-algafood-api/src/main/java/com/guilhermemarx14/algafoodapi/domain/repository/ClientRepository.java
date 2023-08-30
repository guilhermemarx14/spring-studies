package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}
