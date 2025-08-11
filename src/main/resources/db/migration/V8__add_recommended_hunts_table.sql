create table hunt_vocation(
    hunt_id bigint not null,
    vocation_id bigint not null,
    primary key(hunt_id, vocation_id),
    foreign key(hunt_id) references hunts(id) on delete cascade,
    foreign key(vocation_id) references vocations(id) on delete cascade
);