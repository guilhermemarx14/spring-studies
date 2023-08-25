package com.guilhermemarx14.algafoodapi.jpa;

import com.guilhermemarx14.algafoodapi.Application;
import com.guilhermemarx14.algafoodapi.domain.entity.Restaurant;
import com.guilhermemarx14.algafoodapi.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

public class JpaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.NONE)
                .run(args);


        var restaurantRepository = applicationContext.getBean(RestaurantRepository.class);


        Optional<Restaurant> restaurants = restaurantRepository.findFirst();

        System.out.println(restaurants);


    }
}
