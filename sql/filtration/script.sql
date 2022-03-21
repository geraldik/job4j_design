select*from product where type_id=1;
select*from product where lower(name) like '%мороженое%';
select*from product where current_date > expired_date;
select * from product order by price desc limit 1;
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