create table `order`
(
    id                   bigint         not null auto_increment,
    address_complement   varchar(80),
    address_neighborhood varchar(80),
    address_number       varchar(80),
    address_street       varchar(80),
    address_zip_code     varchar(80),
    address_city_id      bigint,
    subtotal             decimal(19, 2) not null,
    freight_rate         decimal(19, 2) not null,
    total                decimal(19, 2) not null,
    creation_date        datetime(6)    not null,
    confirmation_date    datetime(6),
    cancellation_date    datetime(6),
    delivery_date        datetime(6),
    client_id            bigint         not null,
    restaurant_id        bigint         not null,
    payment_method_id    bigint         not null,
    status               varchar(10)    not null,
    primary key (id)
) engine = InnoDB
  charset = utf8;

alter table `order`
    add constraint fk_order_client
        foreign key (client_id)
            references client (id);

alter table `order`
    add constraint fk_order_restaurant
        foreign key (restaurant_id)
            references restaurant (id);

alter table `order`
    add constraint fk_order_payment_method
        foreign key (payment_method_id)
            references payment_method (id);


alter table `order`
    add constraint fk_order_city
        foreign key (address_city_id)
            references city (id);