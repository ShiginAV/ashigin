-- create tables
create table role(
	id serial primary key,
	description character varying(2000)
);

insert into role(description) values('description of role_01');
insert into role(description) values('description of role_02');
insert into role(description) values('description of role_03');

create table users(
	id serial primary key, 
	name character varying(2000),
	role_id integer references role(id)
);

insert into users(name, role_id) values('name of user_1', 1);
insert into users(name, role_id) values('name of user_2', 2);
insert into users(name, role_id) values('name of user_3', 2);

create table rules(
	id serial primary key,
	description character varying(2000)
);

insert into rules(description) values('description of rules_01');
insert into rules(description) values('description of rules_02');
insert into rules(description) values('description of rules_03');

create table role_rules(
	role_id integer references role(id),
	rules_id integer references rules(id)
);

insert into role_rules(role_id, rules_id) values(1, 3);
insert into role_rules(role_id, rules_id) values(2, 2);
insert into role_rules(role_id, rules_id) values(3, 1);

create table category(
	id serial primary key,
	description character varying(2000)
);

insert into category(description) values('description of category_01');
insert into category(description) values('description of category_02');
insert into category(description) values('description of category_03');

create table state(
	id serial primary key,
	description character varying(2000)
);

insert into state(description) values('description of state_01');
insert into state(description) values('description of state_02');
insert into state(description) values('description of state_03');

create table item(
	id serial primary key,
	description character varying(2000),
	users_id integer references users(id),
	category_id integer references category(id),
	state_id integer references state(id)
);

insert into item(description, users_id, category_id, state_id) values('description of items_1', 1, 2, 3);
insert into item(description, users_id, category_id, state_id) values('description of items_2', 2, 3, 1);
insert into item(description, users_id, category_id, state_id) values('description of items_3', 3, 2, 3);

create table comments(
	id serial primary key,
	text character varying(2000),
	item_id integer references item(id)
);

insert into comments(text, item_id) values('text of comments_1', 3);
insert into comments(text, item_id) values('text of comments_2', 1);
insert into comments(text, item_id) values('text of comments_3', 3);

create table attaches(
	id serial primary key,
	description character varying(2000),
	item_id integer references item(id)
);

insert into attaches(description, item_id) values('description of attaches_1', 1);
insert into attaches(description, item_id) values('description of attaches_2', 1);
insert into attaches(description, item_id) values('description of attaches_3', 1);
													   
													   