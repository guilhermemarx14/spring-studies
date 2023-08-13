package com.guilhermemarx14.algafoodapi;

import com.guilhermemarx14.algafoodapi.model.Client;
import com.guilhermemarx14.algafoodapi.service.ClientActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyFirstController {
    @Autowired
    ClientActivationService clientActivationService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Client client = new Client("John doe", "john.doe@email.com", "1234567");
        clientActivationService.activate(client);
        return "Hello";
    }
}
