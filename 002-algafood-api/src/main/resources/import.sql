insert into kitchen (id, name) values(1, 'thailandesa');
insert into kitchen (id, name) values(2, 'indiana');

insert into restaurant(id, name, freight_rate, kitchen_id) values (1, 'Goiano', 2, 1);
insert into restaurant(id, name, freight_rate, kitchen_id) values (2, 'Cozinha da vovó', 5, 2);

insert into payment_method(id, description) values (1, 'Cartão de débito');
insert into payment_method(id, description) values (2, 'Cartão de crédito');
insert into payment_method(id, description) values (3, 'Boleto');
insert into payment_method(id, description) values (4, 'Pix');

insert into permission (id, name, description) values (1, 'USER', 'Permite acesso a funções não essenciais');
insert into permission (id, name, description)  values (2, 'ROOT', 'Permite acesso a tudo');

insert into state (id, name) values (1, 'Goiás');
insert into state (id, name) values (2, 'Minas Gerais');
insert into state (id, name) values (3, 'São Paulo');

insert into city (id, name, state_id) values (1, 'Goiânia', 1);
insert into city (id, name, state_id) values (2, 'Belo Horizonte', 2);
insert into city (id, name, state_id) values (3, 'Sâo Paulo', 3);
