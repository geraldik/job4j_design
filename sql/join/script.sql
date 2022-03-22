create table departments(
	id serial primary  key,
	name varchar(255)
);
create table employees(
	id serial primary  key,
	name varchar(255),
	department_id int references departments(id)
);

insert into departments(name) values ('IT');
insert into departments(name) values ('MARKETING');
insert into departments(name) values ('HR');
insert into departments(name) values ('FINANCE');
insert into departments(name) values ('PURCHASING');

insert into employees(name, department_id) values ('Ivan', 1);
insert into employees(name, department_id) values ('Petr', 5);
insert into employees(name, department_id) values ('Olga', 3);
insert into employees(name, department_id) values ('Egor', 2);
insert into employees(name, department_id) values ('Semen', 1);
insert into employees(name, department_id) values ('Alexander', 5);
insert into employees(name, department_id) values ('Mariya', 3);
insert into employees(name, department_id) values ('Adam', 1);
insert into employees(name, department_id) values ('Viktoriya', 5);
insert into employees(name, department_id) values ('Eva', 1);
insert into employees(name, department_id) values ('Sveta', 2);
insert into employees(name, department_id) values ('Sergey', 2);
insert into employees(name, department_id) values ('Vlad', 1);

select * from employees e left join departments d on e.department_id = d.id;

select * from employees e  right join departments d on e.department_id = d.id;

select * from employees e full join departments d on e.department_id = d.id;

select * from employees cross join departments;

select * from departments d
left join employees e
on e.department_id = d.id
where e.department_id is null;

select * from employees e left join departments d on e.department_id = d.id;

select * from employees e
right join departments d
on e.department_id = d.id
where e.department_id is not null;

create table teens (
	name varchar(255),
	gender boolean
);
insert into teens(name, gender) values ('Anna', false);
insert into teens(name, gender) values ('Max', true);
insert into teens(name, gender) values ('Vladimir', true);
insert into teens(name, gender) values ('Vera', false);
insert into teens(name, gender) values ('Sara', false);

select t1.name as teen_1, t2.name as teen_2,
concat(t1.name, ' + ', t2.name) as "pair"
from teens t1 cross join teens t2
where t1.gender != t2.gender;