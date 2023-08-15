package com.guilhermemarx14.algafoodapi.notification;

import com.guilhermemarx14.algafoodapi.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NotificatorType(UrgencyLevel.NORMAL)
@Component
public class EmailNotificator implements Notificator {

    @Autowired
    NotificatorProperties properties;

    @Override
    public String notify(Client client, String message) {
        System.out.println(properties.getServerHost() + " " + properties.getServerPort());
        return String.format("Notifying %s through email: %s: %s",
                client.getName(), client.getEmail(), message);
    }
}
