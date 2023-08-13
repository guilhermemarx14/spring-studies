package com.guilhermemarx14.algafoodapi.event;

import com.guilhermemarx14.algafoodapi.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ActivatedClientEvent {

    private Client client;
}
