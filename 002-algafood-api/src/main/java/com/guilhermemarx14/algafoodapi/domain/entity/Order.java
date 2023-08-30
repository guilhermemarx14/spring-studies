package com.guilhermemarx14.algafoodapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guilhermemarx14.algafoodapi.domain.entity.places.Address;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode( onlyExplicitlyIncluded = true )
@Table(name = "`order`")
public class Order {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Embedded
    private Address address;

    @Column( nullable = false )
    private BigDecimal subtotal;

    @Column( nullable = false )
    private BigDecimal freightRate;

    @Column( nullable = false )
    private BigDecimal total;

    @Column( nullable = false )
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime confirmationDate;

    @Column
    private LocalDateTime cancellationDate;

    @Column
    private LocalDateTime deliveryDate;


    @OneToMany(mappedBy = "order")
    List<ItemOrder> itemOrders = new ArrayList<>();

    @Column
    @Enumerated( EnumType.STRING )
    private OrderStatus status;
}
