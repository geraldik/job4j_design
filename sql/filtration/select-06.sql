select * from product p
join type t 
on t.id = p.type_id
where t.name in ('СЫР', 'МОЛОКО');
