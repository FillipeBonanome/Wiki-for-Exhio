create table spells(
    id bigint not null primary key auto_increment,
    name varchar(255) not null,
    description varchar(255) not null,
    mana_cost bigint not null,
    soul_cost bigint not null,
    element varchar(255) not null,
    cooldown double(3,2) not null,
    cooldown_group varchar(255) not null,
    spell_range bigint not null
);