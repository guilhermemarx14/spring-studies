package com.guilhermemarx14.algafoodapi.notification;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("notificator.email")
public class NotificatorProperties {

    private String serverHost;
    private String serverPort; // you can give a standard value here that will be replaced if the property exists
}
