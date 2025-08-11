create table vocations(
    id bigint primary key not null auto_increment,
    name varchar(255) not null,
    race varchar(255) not null,
    health_per_level int not null,
    mana_per_level int not null,
    cap_per_level int not null,
    health_regen int not null,
    mana_regen int not null,
    magic_level int not null,
    fist_skill int not null,
    club_skill int not null,
    sword_skill int not null,
    axe_skill int not null,
    distance_skill int not null,
    shield_skill int not null,
    fishing_skill int not null,
    description text not null
);