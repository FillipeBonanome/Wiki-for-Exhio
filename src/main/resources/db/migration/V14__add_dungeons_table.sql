create table dungeons(
    id bigint not null primary key auto_increment,
    name varchar(255) not null,
    dungeon_size varchar(255) not null,
    monsters_to_kill bigint not null
);

create table dungeon_monster(
    dungeon_id bigint not null,
    monster_id bigint not null,
    primary key(dungeon_id, monster_id),
    foreign key(dungeon_id) references dungeons(id),
    foreign key(monster_id) references monsters(id)
);