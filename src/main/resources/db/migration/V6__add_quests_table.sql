create table quests(
    id bigint primary key not null auto_increment,
    name varchar(255) not null,
    hunt_id bigint not null,
    item varchar(255),
    gold varchar(255),
    stats varchar(255),
    level bigint not null,

    foreign key(hunt_id) references hunts(id)
);