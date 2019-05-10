-- auto-generated definition
create table application_authority_rel_user
(
    authority int not null,
    user      int not null,
    primary key (authority, user),
    constraint application_role_rel_user_application_role_id_fk
    foreign key (authority) references application_authority (id),
    constraint application_role_rel_user_application_user_id_fk
    foreign key (user) references application_user (id)
);

