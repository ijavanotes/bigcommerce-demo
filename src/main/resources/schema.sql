
create table IF NOT EXISTS student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table IF NOT EXISTS tb_bc_auth(
id integer not null,
user_name varchar (255), 
access_token varchar(255), 
user_email varchar(255)  ,
scope CLOB, 
context varchar(255)
);