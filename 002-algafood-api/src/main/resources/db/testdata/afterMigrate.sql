insert ignore into kitchen (id, name) values(1, 'thailandesa');
insert ignore into kitchen (id, name) values(2, 'indiana');

insert ignore into payment_method(id, description) values (1, 'Cartão de débito');
insert ignore into payment_method(id, description) values (2, 'Cartão de crédito');
insert ignore into payment_method(id, description) values (3, 'Boleto');
insert ignore into payment_method(id, description) values (4, 'Pix');

insert ignore into permission (id, name, description) values (1, 'USER', 'Permite acesso a funções não essenciais');
insert ignore into permission (id, name, description) values (2, 'ROOT', 'Permite acesso a tudo');

insert ignore into user_group (id, name) values (1, 'Usuários de Aplicação');
insert ignore into user_group (id, name) values (2, 'Usuários de Infraestrutura');

insert ignore into user_group_permissions(user_group_id, permissions_id) values(1,1);
insert ignore into user_group_permissions(user_group_id, permissions_id) values(1,2);
insert ignore into user_group_permissions(user_group_id, permissions_id) values(1,2);

insert ignore into state (id, name) values (1, 'Goiás');
insert ignore into state (id, name) values (2, 'Minas Gerais');
insert ignore into state (id, name) values (3, 'São Paulo');

insert ignore into city (id, name, state_id) values (1, 'Goiânia', 1);
insert ignore into city (id, name, state_id) values (2, 'Belo Horizonte', 2);
insert ignore into city (id, name, state_id) values (3, 'Sâo Paulo', 3);

insert ignore into restaurant(id, name, freight_rate, kitchen_id, address_complement, address_neighborhood,address_number,address_street,address_zip_code,address_city_id,creation_date, update_date) values (1, 'Goiano', 2, 1, 'Em frente a escola','Jardins','10','Rua da consolação','12252454',2, utc_timestamp, utc_timestamp);
insert ignore into restaurant(id, name, freight_rate, kitchen_id, address_complement, address_neighborhood,address_number,address_street,address_zip_code,address_city_id, creation_date, update_date) values (2, 'Cozinha da vovó', 5, 2,null,'União','15', 'Rua 23','45151848',1, utc_timestamp, utc_timestamp);

insert ignore into restaurant_payment_methods(restaurant_id, payment_methods_id) values(1,3);
insert ignore into restaurant_payment_methods(restaurant_id, payment_methods_id) values(1,2);
insert ignore into restaurant_payment_methods(restaurant_id, payment_methods_id) values(2,1);
insert ignore into restaurant_payment_methods(restaurant_id, payment_methods_id) values(2,4);

insert ignore into product (id, name, description, price, active, restaurant_id) values (1,'Stroganoff','Stroganoff de frango',30,true,1);
insert ignore into product (id, name, description, price, active, restaurant_id) values (2,'Jantinha','Acompanha espetinho',25,true,2);
insert ignore into product (id, name, description, price, active, restaurant_id) values (3,'Filé a parmeginana','Muito caro',70,true,1);
insert ignore into product (id, name, description, price, active, restaurant_id) values (4,'Picanha','Picanha mal passada',50,true,2);
insert ignore into product (id, name, description, price, active, restaurant_id) values (5,'Cupim','Espetinho',15,true,1);
insert ignore into product (id, name, description, price, active, restaurant_id) values (6,'Kafka', 'Espetinho',15,false,2);
insert ignore into product (id, name, description, price, active, restaurant_id) values (7,'Mousse de maracujá', 'Sobremesa',25,true,1);

insert ignore into client (id, name, email, password, user_group_id, creation_date) values (1, 'Viviane', 'viviane@alga', '123', 1, utc_timestamp);
insert ignore into client (id, name, email, password, user_group_id, creation_date) values (2, 'Marcelo', 'marcelo@alga', '123', 2, utc_timestamp);
insert ignore into client (id, name, email, password, user_group_id, creation_date) values (3, 'Pedro', 'pedro@alga', '123', 2, utc_timestamp);

insert ignore into `order` (id, address_complement, address_neighborhood, address_number, address_street, address_zip_code, address_city_id, subtotal, freight_rate, total, creation_date, confirmation_date, delivery_date, client_id, restaurant_id, payment_method_id, status) values (1, null, null, null, null, null, null, 0, 0, 0, utc_timestamp, null, null, 1, 1, 1, 'CONFIRMADO');
insert ignore into `order` (id, address_complement, address_neighborhood, address_number, address_street, address_zip_code, address_city_id, subtotal, freight_rate, total, creation_date, confirmation_date, delivery_date, client_id, restaurant_id, payment_method_id, status) values (2, null, null, null, null, null, null, 0, 0, 0, utc_timestamp, null, null, 2, 2, 2, 'CONFIRMADO');

insert ignore into item_order (id, quantity, unity_price, total_price, observation, creation_date, order_id, product_id) values (1, 1, 30, 30, null, utc_timestamp, 1, 1);
insert ignore into item_order (id, quantity, unity_price, total_price, observation, creation_date, order_id, product_id) values (2, 1, 25, 25, null, utc_timestamp, 1, 2);
insert ignore into item_order (id, quantity, unity_price, total_price, observation, creation_date, order_id, product_id) values (3, 1, 70, 70, null, utc_timestamp, 1, 3);
insert ignore into item_order (id, quantity, unity_price, total_price, observation, creation_date, order_id, product_id) values (4, 1, 50, 50, null, utc_timestamp, 1, 4);
insert ignore into item_order (id, quantity, unity_price, total_price, observation, creation_date, order_id, product_id) values (5, 1, 15, 15, null, utc_timestamp, 1, 5);
insert ignore into item_order (id, quantity, unity_price, total_price, observation, creation_date, order_id, product_id) values (6, 1, 15, 15, null, utc_timestamp, 1, 6);