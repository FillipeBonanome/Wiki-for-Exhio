create table monsters(
    id bigint primary key not null auto_increment,
    name varchar(255) not null,
    description text not null,
    experience bigint not null,
    health bigint not null,
    category varchar(255) not null,
    physical_resist bigint default 0,
    fire_resist bigint default 0,
    ice_resist bigint default 0,
    energy_resist bigint default 0,
    poison_resist bigint default 0,
    holy_resist bigint default 0,
    death_resist bigint default 0
);