create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('laptop', 1000), ('smartphone', 400), ('tablet', 300), ('smartwatch', 200);
insert into people(name) values ('Artem'), ('Kseniya'), ('Sergey');
insert into devices_people(device_id, people_id) values (1, 1), (1, 2);
insert into devices_people(device_id, people_id) values (2, 1), (2, 2), (2, 2);
insert into devices_people(device_id, people_id) values (3, 3);
insert into devices_people(device_id, people_id) values (4, 1), (4, 3);

select avg(price) from  devices;

select p.name, avg(dv.price)
from devices_people as dp
join people as p
on dp.people_id = p.id
join devices as dv
on dp.device_id = dv.id
group by p.name;

select p.name, avg(dv.price)
from devices_people as dp
join people as p
on dp.people_id = p.id
join devices as dv
on dp.device_id = dv.id
group by p.name
having avg(dv.price) > 5000;
