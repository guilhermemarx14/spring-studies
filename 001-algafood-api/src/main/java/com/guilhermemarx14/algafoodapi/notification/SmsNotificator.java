package com.guilhermemarx14.algafoodapi.notification;

import com.guilhermemarx14.algafoodapi.model.Client;
import org.springframework.stereotype.Component;

@NotificatorType(UrgencyLevel.URGENT)
@Component
public class SmsNotificator implements Notificator {

    @Override
    public String notify(Client client, String message) {

        return String.format("Notifying %s through SMS on phone: %s: " +
                        "%s", client.getName(), client.getPhone(),
                message);
    }
}
