-- auto-generated definition
create table application_authority
(
    id          int auto_increment
        primary key,
    name        varchar(15)  not null,
    description varchar(100) not null,
    constraint application_role_name_uindex
    unique (name)
);

