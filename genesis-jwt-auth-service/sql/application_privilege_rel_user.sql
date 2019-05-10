-- auto-generated definition
create table application_privilege_rel_user
(
    privilege int not null,
    user      int not null,
    primary key (privilege, user),
    constraint application_privilege_rel_user_application_privilege_id_fk
    foreign key (privilege) references application_privilege (id),
    constraint application_privilege_rel_user_application_user_id_fk
    foreign key (user) references application_user (id)
);

