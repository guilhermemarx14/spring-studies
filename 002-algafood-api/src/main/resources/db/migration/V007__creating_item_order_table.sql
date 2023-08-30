create table item_order
(
    id            bigint         not null auto_increment,
    quantity         bigint         not null,
    unity_price   decimal(19, 2) not null,
    total_price   decimal(19, 2) not null,
    observation   varchar(255),
    creation_date datetime(6)    not null,
    order_id      bigint         not null,
    product_id    bigint         not null,
    primary key (id)
) engine = InnoDB
  charset = utf8;

alter table item_order
    add constraint fk_item_order_order
        foreign key (order_id)
            references `order` (id);

alter table item_order
    add constraint fk_item_order_product
        foreign key (product_id)
            references product (id);