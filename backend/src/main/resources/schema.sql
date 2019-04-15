create table booking
(
   id integer not null,
   property_id varchar(255) not null,
   property_name varchar(255) not null,
   city varchar(255) not null,
   primary key(id)
);