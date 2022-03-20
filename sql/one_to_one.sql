create table addresses(
     id serial primary key,
     name varchar(255)
     
 );
 
 create table customers(
     id serial primary key,
     name varchar(255),
	 address_id int references addresses(id) unique
 );
 
insert into addresses(name) values ('Moscow, Arbat, d. 1');
insert into customers(name, address_id) values ('Bob', 1);