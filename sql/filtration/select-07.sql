select t.name, count(p)
from product as p
join type as t
on p.type_id = t.id
group by t.name
having count(p) < 10;
