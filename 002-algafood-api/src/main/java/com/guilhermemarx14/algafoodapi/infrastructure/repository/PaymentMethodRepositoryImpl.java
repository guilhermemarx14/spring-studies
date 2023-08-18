package com.guilhermemarx14.algafoodapi.infrastructure.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.PaymentMethod;
import com.guilhermemarx14.algafoodapi.domain.repository.PaymentMethodRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<PaymentMethod> list() {
        return manager.createQuery("from PaymentMethod", PaymentMethod.class).getResultList();
    }

    @Transactional
    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return manager.merge(paymentMethod);
    }

    @Override
    public PaymentMethod findById(Long id) {
        return manager.find(PaymentMethod.class, id);
    }

    @Transactional
    @Override
    public void delete(PaymentMethod paymentMethod) {
        manager.remove(findById(paymentMethod.getId()));
    }
}
