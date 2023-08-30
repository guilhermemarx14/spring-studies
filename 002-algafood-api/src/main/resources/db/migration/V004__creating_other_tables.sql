create table payment_method
(
    id          bigint      not null auto_increment,
    description varchar(60) not null,
    primary key (id)
) engine = InnoDB
  charset = utf8;

create table permission
(
    id          bigint      not null auto_increment,
    description varchar(80) not null,
    name        varchar(30) not null,
    primary key (id)
) engine = InnoDB
  charset = utf8;

create table product
(
    id            bigint         not null auto_increment,
    active        bit            not null,
    description   varchar(255)   not null,
    name          varchar(255)   not null,
    price         decimal(19, 2) not null,
    restaurant_id bigint         not null,
    primary key (id)
) engine = InnoDB
  charset = utf8;

create table restaurant
(
    id                   bigint         not null auto_increment,
    address_complement   varchar(80),
    address_neighborhood varchar(80),
    address_number       varchar(80),
    address_street       varchar(80),
    address_zip_code     varchar(80),
    creation_date        datetime(6)    not null,
    freight_rate         decimal(19, 2) not null,
    name                 varchar(80)    not null,
    update_date          datetime(6)    not null,
    address_city_id      bigint,
    kitchen_id           bigint         not null,
    primary key (id)
) engine = InnoDB
  charset = utf8;

create table restaurant_payment_methods
(
    restaurant_id      bigint not null,
    payment_methods_id bigint not null
) engine = InnoDB
  charset = utf8;


create table user_group
(
    id   bigint      not null auto_increment,
    name varchar(80) not null,
    primary key (id)
) engine = InnoDB
  charset = utf8;

create table user_group_permissions
(
    user_group_id  bigint not null,
    permissions_id bigint not null
) engine = InnoDB
  charset = utf8;


alter table product
    add constraint fk_product_restaurant
        foreign key (restaurant_id)
            references restaurant (id);

alter table restaurant
    add constraint fk_restaurant_city
        foreign key (address_city_id)
            references city (id);

alter table restaurant
    add constraint fk_restaurant_kitchen
        foreign key (kitchen_id)
            references kitchen (id);

alter table restaurant_payment_methods
    add constraint fk_restaurant_payment_methods_payment_methods
        foreign key (payment_methods_id)
            references payment_method (id);

alter table restaurant_payment_methods
    add constraint fk_restaurant_payment_methods_restaurant
        foreign key (restaurant_id)
            references restaurant (id);

alter table user_group_permissions
    add constraint fk_user_group_permissions_permissions
        foreign key (permissions_id)
            references permission (id);

alter table user_group_permissions
    add constraint fk_user_group_permissions_user_group
        foreign key (user_group_id)
            references user_group (id);
