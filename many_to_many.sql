 create table orders(
     id serial primary key,
     number int
 );
 
 create table items(
     id serial primary key,
     article varchar(255)
 );
 
 create table orders_items(
     id serial primary key,
     order_id int references orders(id),
     item_id int references items(id)
 );
 
 insert into orders(number) values (121);
 insert into orders(number) values (11);
 insert into orders(number) values (318);
 
 insert into items(article) values ('G1234');
 insert into items(article) values ('F1234');
 insert into items(article) values ('R1234');
 
 insert into orders_items(order_id, item_id) values (1, 1);
 insert into orders_items(order_id, item_id) values (2, 1);
 insert into orders_items(order_id, item_id) values (2, 2);
 insert into orders_items(order_id, item_id) values (2, 3);
 insert into orders_items(order_id, item_id) values (3, 3);