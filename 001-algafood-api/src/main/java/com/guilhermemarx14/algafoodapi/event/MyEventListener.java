package com.guilhermemarx14.algafoodapi.event;

import com.guilhermemarx14.algafoodapi.notification.Notificator;
import com.guilhermemarx14.algafoodapi.notification.NotificatorType;
import com.guilhermemarx14.algafoodapi.notification.UrgencyLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {

    @NotificatorType(UrgencyLevel.NORMAL)
    @Autowired
    private Notificator notificator;

    @EventListener
    public void activatedClientListener(ActivatedClientEvent event) {
        notificator.notify(event.getClient(), "Client is active");
    }
}
