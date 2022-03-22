select * from product p
join type t
on t.id = p.type_id
where t.name ='СЫР';

select*from product where lower(name) like '%мороженое%';

select*from product where current_date > expired_date;

select p.name, p.price
from product as p
where p.price = (select max(p.price) from product p);

select t.name, count(p)
from product as p
join type as t
on p.type_id = t.id
group by t.name;

select * from product p
join type t 
on t.id = p.type_id
where t.name in ('СЫР', 'МОЛОКО');

select t.name, count(p)
from product as p
join type as t
on p.type_id = t.id
group by t.name
having count(p) < 10;

select * from product as p
join type as t
on p.type_id = t.id;