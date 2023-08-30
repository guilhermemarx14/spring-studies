package com.guilhermemarx14.algafoodapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    CRIADO("CRIADO"), CONFIRMADO("CONFIRMADO"), ENTREGUE("ENTREGUE"), CANCELADO("CANCELADO");

    private String value;
}
