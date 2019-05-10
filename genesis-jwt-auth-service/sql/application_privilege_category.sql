-- auto-generated definition
create table application_privilege_category
(
    id          int auto_increment
        primary key,
    name        varchar(100) not null,
    description varchar(100) not null,
    constraint application_privilege_category_name_uindex
    unique (name)
);

