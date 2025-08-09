alter table monsters add column level bigint;
update monsters set level = 10;
alter table monsters modify column level bigint not null default 10;