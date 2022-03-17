insert into roles(name) values ('Administrator');
insert into users(name, role_id) values ('Roman', 1);
insert into categorys (name) values ('Bug reports');
insert into states (name) values ('Active');
insert into items (name, user_id, category_id, state_id) values ('Another one bug', 1, 1, 1);
insert into comments (name, item_id) values ('Some comment', 1);
insert into comments (name, item_id) values ('Another one comment', 1);
insert into attachs (name, item_id) values ('Explanation.txt', 1);