create table users(
    id binary(16) primary key not null,
    name varchar(255) not null,
    login varchar(255) not null unique,
    password varchar(255) not null,
    email varchar(255) not null unique,
    role varchar(255) not null,
    active tinyint not null
);