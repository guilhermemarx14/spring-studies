package com.guilhermemarx14.algafoodapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {
    private String name;
    private String email;
    private String phone;
    private boolean active = false;

    public Client(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void activate() {
        this.active = true;
    }
}
