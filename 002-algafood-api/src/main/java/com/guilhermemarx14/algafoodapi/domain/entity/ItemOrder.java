package com.guilhermemarx14.algafoodapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode( onlyExplicitlyIncluded = true )
public class ItemOrder {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private Integer quantity;

    @Column( nullable = false )
    private BigDecimal unityPrice;

    @Column( nullable = false )
    private BigDecimal totalPrice;

    @Column(name = "`observation`")
    private String observation;

    @Column( nullable = false )
    private LocalDateTime creationDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
