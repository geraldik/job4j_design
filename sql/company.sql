CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
insert into company(id, name) values
 (1, 'company_name1'),
 (2, 'company_name2'),
 (3, 'company_name3'),
 (4, 'company_name4'),
 (5, 'company_name5');

insert into person values
(1, 'name1', 1),
(2, 'name2', 1),
(3, 'name3', 2),
(4, 'name4', 3),
(5, 'name5', 4),
(6, 'name6', 4),
(7, 'name7', 2),
(8, 'name8', 2),
(9, 'name9', 2)

select*from person p
join company c on p.company_id=c.id
where p.company_id!=5

SELECT cp.name, MAX(cp.person_count)
FROM (SELECT c.name, COUNT(p.company_id) AS person_count 
	  FROM company c
 	  JOIN person p 
	  ojphb[wON p.company_id=c.id
      GROUP BY c.name) cp 
GROUP BY cp.name, cp.person_count
HAVING cp.person_count=(SELECT MAX(cp.person_count)
						FROM (SELECT c.name, COUNT(p.company_id) AS person_count 
					    	  FROM company c
 	      					  JOIN person p 
						 	  ON p.company_id=c.id
      						  GROUP BY c.name) cp)


 