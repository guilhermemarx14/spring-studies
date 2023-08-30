package com.guilhermemarx14.algafoodapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode( onlyExplicitlyIncluded = true )
public class Client {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private UserGroup userGroup;

}
