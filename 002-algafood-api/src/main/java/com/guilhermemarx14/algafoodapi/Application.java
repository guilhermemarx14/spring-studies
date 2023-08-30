package com.guilhermemarx14.algafoodapi;

import com.guilhermemarx14.algafoodapi.domain.entity.Restaurant;
import com.guilhermemarx14.algafoodapi.domain.repository.ClientRepository;
import com.guilhermemarx14.algafoodapi.domain.repository.RestaurantRepository;
import com.guilhermemarx14.algafoodapi.infrastructure.repository.CustomJpaRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories( repositoryBaseClass = CustomJpaRepositoryImpl.class )
public class Application {

    public static void main ( String[] args ) {
        SpringApplication.run(Application.class, args);
    }

    public static void mainNoWeb ( String[] args ) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        var clientRepository = applicationContext.getBean(ClientRepository.class);



        log.info(clientRepository.findAll().toString());
    }
}
