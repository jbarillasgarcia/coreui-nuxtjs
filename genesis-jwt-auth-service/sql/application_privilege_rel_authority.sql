-- auto-generated definition
create table application_privilege_rel_authority
(
    privilege int not null,
    authority int not null,
    primary key (privilege, authority),
    constraint permission_rel_role_application_permission_id_fk
    foreign key (privilege) references application_privilege (id),
    constraint permission_rel_role_application_role_id_fk
    foreign key (authority) references application_authority (id)
);

