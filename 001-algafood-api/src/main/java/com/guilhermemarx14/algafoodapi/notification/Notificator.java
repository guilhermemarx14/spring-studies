package com.guilhermemarx14.algafoodapi.notification;

import com.guilhermemarx14.algafoodapi.model.Client;

public interface Notificator {
    String notify(Client client, String message);
}