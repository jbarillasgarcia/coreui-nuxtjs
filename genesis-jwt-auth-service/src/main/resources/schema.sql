-- auto-generated definition
create table if not exists application_user
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
    password_hint       varchar(50)         not null,
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

-- auto-generated definition
create table if not exists application_authority
(
    id          int auto_increment
        primary key,
    name        varchar(15)  not null,
    description varchar(100) not null,
    constraint application_role_name_uindex
    unique (name)
);

-- auto-generated definition
create table if not exists application_privilege
(
    id          int auto_increment
        primary key,
    name        varchar(100) not null,
    description varchar(100) not null,
    constraint application_permission_name_uindex
    unique (name)
);

-- auto-generated definition
create table if not exists application_privilege_category
(
    id          int auto_increment
        primary key,
    name        varchar(100) not null,
    description varchar(100) not null,
    constraint application_privilege_category_name_uindex
    unique (name)
);

-- auto-generated definition
create table if not exists application_authority_rel_user
(
    authority int not null,
    user      int not null,
    primary key (authority, user),
    constraint application_role_rel_user_application_role_id_fk
    foreign key (authority) references application_authority (id),
    constraint application_role_rel_user_application_user_id_fk
    foreign key (user) references application_user (id)
);

-- auto-generated definition
create table if not exists application_privilege_rel_authority
(
    privilege int not null,
    authority int not null,
    primary key (privilege, authority),
    constraint permission_rel_role_application_permission_id_fk
    foreign key (privilege) references application_privilege (id),
    constraint permission_rel_role_application_role_id_fk
    foreign key (authority) references application_authority (id)
);

-- auto-generated definition
create table if not exists application_privilege_rel_category
(
    privilege int not null,
    category  int not null,
    primary key (privilege, category),
    constraint application_privilege_rel_category_application_category_id_fk
    foreign key (category) references application_privilege_category (id),
    constraint application_privilege_rel_category_application_privilege_id_fk
    foreign key (privilege) references application_privilege (id)
);

-- auto-generated definition
create table if not exists application_privilege_rel_user
(
    privilege int not null,
    user      int not null,
    primary key (privilege, user),
    constraint application_privilege_rel_user_application_privilege_id_fk
    foreign key (privilege) references application_privilege (id),
    constraint application_privilege_rel_user_application_user_id_fk
    foreign key (user) references application_user (id)
);

