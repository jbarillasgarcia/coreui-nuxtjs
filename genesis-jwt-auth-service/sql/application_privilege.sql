-- auto-generated definition
create table application_privilege
(
    id          int auto_increment
        primary key,
    name        varchar(100) not null,
    description varchar(100) not null,
    constraint application_permission_name_uindex
    unique (name)
);

