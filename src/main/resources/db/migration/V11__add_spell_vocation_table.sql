create table spell_vocation(
    spell_id bigint not null,
    vocation_id bigint not null,
    primary key(spell_id, vocation_id),
    foreign key(spell_id) references spells(id),
    foreign key(vocation_id) references vocations(id)
);