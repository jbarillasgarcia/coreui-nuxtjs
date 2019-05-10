-- auto-generated definition
create table application_user
(
    id                  int auto_increment
        primary key,
    first_name          varchar(25)         not null,
    last_name           varchar(25)         not null,
    email               varchar(50)         not null,
    address             varchar(50)         null,
    phone               varchar(25)         null,
    birth_date          datetime            null,
    picture             blob                null,
    username            varchar(15)         not null,
    password            varchar(100)        not null,
    password_hint       varchar(25)         not null,
    created_date        datetime            null,
    created_by          int                 null,
    last_modified_date  datetime            null,
    last_modified_by    int                 null,
    enabled             tinyint default '1' not null,
    default_system_user tinyint default '1' null,
    removable           tinyint default '0' null,
    constraint application_user_email_uindex
    unique (email),
    constraint application_user_username_uindex
    unique (username),
    constraint application_user_application_user_id_fk
    foreign key (created_by) references application_user (id),
    constraint application_user_application_user_id_fk_2
    foreign key (last_modified_by) references application_user (id)
);

