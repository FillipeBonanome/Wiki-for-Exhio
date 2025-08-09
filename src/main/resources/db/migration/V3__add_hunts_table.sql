create table hunts(
    id bigint not null auto_increment primary key,
    name varchar(255) not null unique,
    description varchar(255) not null,
    video_url varchar(255),
    recommended_level bigint not null
);

create table hunt_monster(
    hunt_id bigint not null,
    monster_id bigint not null,
    primary key(hunt_id, monster_id),
    foreign key(hunt_id) references hunts(id) on delete cascade,
    foreign key(monster_id) references monsters(id) on delete cascade
);