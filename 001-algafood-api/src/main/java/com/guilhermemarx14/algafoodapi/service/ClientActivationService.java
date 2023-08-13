package com.guilhermemarx14.algafoodapi.service;

import com.guilhermemarx14.algafoodapi.event.ActivatedClientEvent;
import com.guilhermemarx14.algafoodapi.model.Client;
import com.guilhermemarx14.algafoodapi.notification.Notificator;
import com.guilhermemarx14.algafoodapi.notification.NotificatorType;
import com.guilhermemarx14.algafoodapi.notification.UrgencyLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ClientActivationService {
    //@Autowired(required = false) in case of this is not mandatory
    @NotificatorType(UrgencyLevel.URGENT)
    @Autowired
    private Notificator notificator;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }


    public void activate(Client client) {
        client.activate();

        eventPublisher.publishEvent(new ActivatedClientEvent(client));
    }
}
