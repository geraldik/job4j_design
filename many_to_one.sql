create table customers(
     id serial primary key,
     name varchar(255)
     
 );
 
 create table orders(
     id serial primary key,
     amaunt int,
	 customer_id int references customers(id)
 );
 
insert into customers(name) values ('Andrey');
insert into orders(amaunt, customer_id) values ('250', 1);

select * from orders;
select * from customers where id in (select id from orders);