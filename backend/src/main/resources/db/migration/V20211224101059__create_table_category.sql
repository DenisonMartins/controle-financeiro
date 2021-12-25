create table if not exists category (
    id bigint auto_increment,
    description varchar(100) not null,
    constraint category_pk
    primary key (id)
);