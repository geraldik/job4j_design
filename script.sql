create table employees(	id serial primary key, name text, sex boolean, age integer);
insert into employees(name, sex, age) values('Сергей', 'true', 33);
update employees set age = 35;
delete from employees;