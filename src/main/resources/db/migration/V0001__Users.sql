create table users(
    id bigserial primary key,
    name text,
    birthday date,
    role varchar(32),
    tlm timestamp,
    created timestamp
);