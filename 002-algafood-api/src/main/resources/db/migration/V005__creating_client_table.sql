create table client
(
    id            bigint      not null auto_increment,
    name          varchar(80) not null,
    email         varchar(80) not null,
    password      varchar(20) not null,
    creation_date datetime(6) not null,
    user_group_id bigint      not null,
    primary key (id)
) engine = InnoDB
  charset = utf8;

alter table client
    add constraint fk_client_user_group
        foreign key (user_group_id)
            references user_group (id);