create table facultys(
id serial primary key,
name varchar(255)
);
create table students(
id serial primary key,
name varchar(255),
faculty_id int references facultys(id)
);

insert into facultys(name) values ('Economics');
insert into facultys(name) values ('History');
insert into facultys(name) values ('Philisophy');

insert into students(name, faculty_id) values ('Sergey', 1);
insert into students(name, faculty_id) values ('Olga', 2);
insert into students(name, faculty_id) values ('Roman', 1);
insert into students(name, faculty_id) values ('Mariya', 3);
insert into students(name, faculty_id) values ('Petr', 3);

select st.name, fc.name
from students as st
join facultys as fc
on st.faculty_id = fc.id;

select st.name as Имя, fc.name Факультет
from students as st
join facultys as fc
on st.faculty_id = fc.id and fc.name = 'Economics';

select st.name as Имя, fc.name Факультет
from students as st
join facultys as fc
on st.faculty_id = fc.id and fc.name = 'Philisophy';