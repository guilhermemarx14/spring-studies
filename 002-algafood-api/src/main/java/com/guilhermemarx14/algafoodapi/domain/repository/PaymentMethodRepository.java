package com.guilhermemarx14.algafoodapi.domain.repository;

import com.guilhermemarx14.algafoodapi.domain.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository {
    List<PaymentMethod> list();

    PaymentMethod save(PaymentMethod paymentMethod);

    PaymentMethod findById(Long id);

    void delete(PaymentMethod paymentMethod);
}
