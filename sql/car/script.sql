create table car_body(
	id serial primary key,
	color varchar(64)
);

create table engine(
	id serial primary key,
	type varchar(24)
);

create table gearbox(
	id serial primary key,
	automative boolean,
	speed_number int
);

create table car(
	id serial primary key,
	name varchar(64),
	car_body_id int references car_body(id),
	engine_id int references engine(id),
	gearbox_id int references gearbox(id)
);

insert into car_body(color) values ('black'), ('white'), ('red'), ('yellow'), ('green');

insert into engine(type) values ('V4'), ('V6'), ('V8'), ('W12');

insert into gearbox(automative, speed_number) 
values (true, 4), (true, 6), (true, 7), (true, 8), (false, 5), (false, 6);

insert into car(name, car_body_id, engine_id, gearbox_id) 
values ('Hyundai Solaris', 2, 1, 1), ('Skoda Octavia', 3, 1, 3), ('Toyota Camry', 1, 2, 4),
('BMW X5', 1, 3, 4), ('KIA Rio', 4, 1, 5);

Select * from car c
join car_body cb
on c.car_body_id= cb.id
join engine e
on c.engine_id= e.id
join gearbox g
on c.gearbox_id= g.id;

select * from car_body cb 
left join car c 
on c.car_body_id = cb.id 
where c.car_body_id is null;

select * from engine e 
left join car c 
on c.engine_id = e.id 
where c.engine_id is null;

select * from gearbox g 
left join car c 
on c.gearbox_id = g.id 
where c.gearbox_id is null;
