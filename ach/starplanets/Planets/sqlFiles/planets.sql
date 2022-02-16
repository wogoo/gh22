CREATE DATABASE star;

create table planets (
    id serial primary key,
    name varchar(255) not null,
    terrain varchar(255) not null,
    climate varchar(255) not null,
    population int not null,
    films int
);
