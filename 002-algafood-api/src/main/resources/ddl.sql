
    create table city (
       id bigint not null auto_increment,
        name varchar(255) not null,
        state_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table kitchen (
       id bigint not null auto_increment,
        name varchar(255) not null,
        observation varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table payment_method (
       id bigint not null auto_increment,
        description varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table permission (
       id bigint not null auto_increment,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table product (
       id bigint not null auto_increment,
        active bit not null,
        description varchar(255) not null,
        name varchar(255) not null,
        price decimal(19,2) not null,
        restaurant_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table restaurant (
       id bigint not null auto_increment,
        address_complement varchar(255),
        address_neighborhood varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        address_zip_code varchar(255),
        creation_date datetime(6) not null,
        freight_rate decimal(19,2) not null,
        name varchar(255) not null,
        update_date datetime(6) not null,
        address_city_id bigint,
        kitchen_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table restaurant_payment_methods (
       restaurant_id bigint not null,
        payment_methods_id bigint not null
    ) engine=InnoDB;

    create table state (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_group (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_group_permissions (
       user_group_id bigint not null,
        permissions_id bigint not null
    ) engine=InnoDB;

    alter table city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state (id);

    alter table product 
       add constraint FKp4b7e36gck7975p51raud8juk 
       foreign key (restaurant_id) 
       references restaurant (id);

    alter table restaurant 
       add constraint FK8pcwgn41lfg43d8u82ewn3cn 
       foreign key (address_city_id) 
       references city (id);

    alter table restaurant 
       add constraint FKrur1dqx79jim8s8dvdp16qc3d 
       foreign key (kitchen_id) 
       references kitchen (id);

    alter table restaurant_payment_methods 
       add constraint FKa3bu8vqg9u3hgmlfqf87nnwvw 
       foreign key (payment_methods_id) 
       references payment_method (id);

    alter table restaurant_payment_methods 
       add constraint FKy9pnuae6v8kwh57mdyum00o5 
       foreign key (restaurant_id) 
       references restaurant (id);

    alter table user_group_permissions 
       add constraint FK1kp2p8of20958qgwsh077f38q 
       foreign key (permissions_id) 
       references permission (id);

    alter table user_group_permissions 
       add constraint FKl75ic1i1e9uro5gl52j3j55p4 
       foreign key (user_group_id) 
       references user_group (id);

    create table city (
       id bigint not null auto_increment,
        name varchar(255) not null,
        state_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table kitchen (
       id bigint not null auto_increment,
        name varchar(255) not null,
        observation varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table payment_method (
       id bigint not null auto_increment,
        description varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table permission (
       id bigint not null auto_increment,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table product (
       id bigint not null auto_increment,
        active bit not null,
        description varchar(255) not null,
        name varchar(255) not null,
        price decimal(19,2) not null,
        restaurant_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table restaurant (
       id bigint not null auto_increment,
        address_complement varchar(255),
        address_neighborhood varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        address_zip_code varchar(255),
        creation_date datetime(6) not null,
        freight_rate decimal(19,2) not null,
        name varchar(255) not null,
        update_date datetime(6) not null,
        address_city_id bigint,
        kitchen_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table restaurant_payment_methods (
       restaurant_id bigint not null,
        payment_methods_id bigint not null
    ) engine=InnoDB;

    create table state (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_group (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_group_permissions (
       user_group_id bigint not null,
        permissions_id bigint not null
    ) engine=InnoDB;

    alter table city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state (id);

    alter table product 
       add constraint FKp4b7e36gck7975p51raud8juk 
       foreign key (restaurant_id) 
       references restaurant (id);

    alter table restaurant 
       add constraint FK8pcwgn41lfg43d8u82ewn3cn 
       foreign key (address_city_id) 
       references city (id);

    alter table restaurant 
       add constraint FKrur1dqx79jim8s8dvdp16qc3d 
       foreign key (kitchen_id) 
       references kitchen (id);

    alter table restaurant_payment_methods 
       add constraint FKa3bu8vqg9u3hgmlfqf87nnwvw 
       foreign key (payment_methods_id) 
       references payment_method (id);

    alter table restaurant_payment_methods 
       add constraint FKy9pnuae6v8kwh57mdyum00o5 
       foreign key (restaurant_id) 
       references restaurant (id);

    alter table user_group_permissions 
       add constraint FK1kp2p8of20958qgwsh077f38q 
       foreign key (permissions_id) 
       references permission (id);

    alter table user_group_permissions 
       add constraint FKl75ic1i1e9uro5gl52j3j55p4 
       foreign key (user_group_id) 
       references user_group (id);

    create table city (
       id bigint not null auto_increment,
        name varchar(255) not null,
        state_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table kitchen (
       id bigint not null auto_increment,
        name varchar(255) not null,
        observation varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table payment_method (
       id bigint not null auto_increment,
        description varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table permission (
       id bigint not null auto_increment,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table product (
       id bigint not null auto_increment,
        active bit not null,
        description varchar(255) not null,
        name varchar(255) not null,
        price decimal(19,2) not null,
        restaurant_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table restaurant (
       id bigint not null auto_increment,
        address_complement varchar(255),
        address_neighborhood varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        address_zip_code varchar(255),
        creation_date datetime(6) not null,
        freight_rate decimal(19,2) not null,
        name varchar(255) not null,
        update_date datetime(6) not null,
        address_city_id bigint,
        kitchen_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table restaurant_payment_methods (
       restaurant_id bigint not null,
        payment_methods_id bigint not null
    ) engine=InnoDB;

    create table state (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_group (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_group_permissions (
       user_group_id bigint not null,
        permissions_id bigint not null
    ) engine=InnoDB;

    alter table city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state (id);

    alter table product 
       add constraint FKp4b7e36gck7975p51raud8juk 
       foreign key (restaurant_id) 
       references restaurant (id);

    alter table restaurant 
       add constraint FK8pcwgn41lfg43d8u82ewn3cn 
       foreign key (address_city_id) 
       references city (id);

    alter table restaurant 
       add constraint FKrur1dqx79jim8s8dvdp16qc3d 
       foreign key (kitchen_id) 
       references kitchen (id);

    alter table restaurant_payment_methods 
       add constraint FKa3bu8vqg9u3hgmlfqf87nnwvw 
       foreign key (payment_methods_id) 
       references payment_method (id);

    alter table restaurant_payment_methods 
       add constraint FKy9pnuae6v8kwh57mdyum00o5 
       foreign key (restaurant_id) 
       references restaurant (id);

    alter table user_group_permissions 
       add constraint FK1kp2p8of20958qgwsh077f38q 
       foreign key (permissions_id) 
       references permission (id);

    alter table user_group_permissions 
       add constraint FKl75ic1i1e9uro5gl52j3j55p4 
       foreign key (user_group_id) 
       references user_group (id);

    create table city (
       id bigint not null auto_increment,
        name varchar(255) not null,
        state_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table kitchen (
       id bigint not null auto_increment,
        name varchar(255) not null,
        observation varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table payment_method (
       id bigint not null auto_increment,
        description varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table permission (
       id bigint not null auto_increment,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table product (
       id bigint not null auto_increment,
        active bit not null,
        description varchar(255) not null,
        name varchar(255) not null,
        price decimal(19,2) not null,
        restaurant_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table restaurant (
       id bigint not null auto_increment,
        address_complement varchar(255),
        address_neighborhood varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        address_zip_code varchar(255),
        creation_date datetime(6) not null,
        freight_rate decimal(19,2) not null,
        name varchar(255) not null,
        update_date datetime(6) not null,
        address_city_id bigint,
        kitchen_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table restaurant_payment_methods (
       restaurant_id bigint not null,
        payment_methods_id bigint not null
    ) engine=InnoDB;

    create table state (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_group (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_group_permissions (
       user_group_id bigint not null,
        permissions_id bigint not null
    ) engine=InnoDB;

    alter table city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state (id);

    alter table product 
       add constraint FKp4b7e36gck7975p51raud8juk 
       foreign key (restaurant_id) 
       references restaurant (id);

    alter table restaurant 
       add constraint FK8pcwgn41lfg43d8u82ewn3cn 
       foreign key (address_city_id) 
       references city (id);

    alter table restaurant 
       add constraint FKrur1dqx79jim8s8dvdp16qc3d 
       foreign key (kitchen_id) 
       references kitchen (id);

    alter table restaurant_payment_methods 
       add constraint FKa3bu8vqg9u3hgmlfqf87nnwvw 
       foreign key (payment_methods_id) 
       references payment_method (id);

    alter table restaurant_payment_methods 
       add constraint FKy9pnuae6v8kwh57mdyum00o5 
       foreign key (restaurant_id) 
       references restaurant (id);

    alter table user_group_permissions 
       add constraint FK1kp2p8of20958qgwsh077f38q 
       foreign key (permissions_id) 
       references permission (id);

    alter table user_group_permissions 
       add constraint FKl75ic1i1e9uro5gl52j3j55p4 
       foreign key (user_group_id) 
       references user_group (id);

    create table city (
       id bigint not null auto_increment,
        name varchar(255) not null,
        state_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table kitchen (
       id bigint not null auto_increment,
        name varchar(255) not null,
        observation varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table payment_method (
       id bigint not null auto_increment,
        description varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table permission (
       id bigint not null auto_increment,
        description varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table product (
       id bigint not null auto_increment,
        active bit not null,
        description varchar(255) not null,
        name varchar(255) not null,
        price decimal(19,2) not null,
        restaurant_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table restaurant (
       id bigint not null auto_increment,
        address_complement varchar(255),
        address_neighborhood varchar(255),
        address_number varchar(255),
        address_street varchar(255),
        address_zip_code varchar(255),
        creation_date datetime(6) not null,
        freight_rate decimal(19,2) not null,
        name varchar(255) not null,
        update_date datetime(6) not null,
        address_city_id bigint,
        kitchen_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table restaurant_payment_methods (
       restaurant_id bigint not null,
        payment_methods_id bigint not null
    ) engine=InnoDB;

    create table state (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_group (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user_group_permissions (
       user_group_id bigint not null,
        permissions_id bigint not null
    ) engine=InnoDB;

    alter table city 
       add constraint FK6p2u50v8fg2y0js6djc6xanit 
       foreign key (state_id) 
       references state (id);

    alter table product 
       add constraint FKp4b7e36gck7975p51raud8juk 
       foreign key (restaurant_id) 
       references restaurant (id);

    alter table restaurant 
       add constraint FK8pcwgn41lfg43d8u82ewn3cn 
       foreign key (address_city_id) 
       references city (id);

    alter table restaurant 
       add constraint FKrur1dqx79jim8s8dvdp16qc3d 
       foreign key (kitchen_id) 
       references kitchen (id);

    alter table restaurant_payment_methods 
       add constraint FKa3bu8vqg9u3hgmlfqf87nnwvw 
       foreign key (payment_methods_id) 
       references payment_method (id);

    alter table restaurant_payment_methods 
       add constraint FKy9pnuae6v8kwh57mdyum00o5 
       foreign key (restaurant_id) 
       references restaurant (id);

    alter table user_group_permissions 
       add constraint FK1kp2p8of20958qgwsh077f38q 
       foreign key (permissions_id) 
       references permission (id);

    alter table user_group_permissions 
       add constraint FKl75ic1i1e9uro5gl52j3j55p4 
       foreign key (user_group_id) 
       references user_group (id);
