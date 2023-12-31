package com.guilhermemarx14.algafoodapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode( onlyExplicitlyIncluded = true )
public class Kitchen {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private String name;

    @JsonIgnore
    @OneToMany( mappedBy = "kitchen" )
    private List<Restaurant> restaurants = new ArrayList<>();
}
