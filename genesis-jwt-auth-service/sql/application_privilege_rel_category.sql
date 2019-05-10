-- auto-generated definition
create table application_privilege_rel_category
(
    privilege int not null,
    category  int not null,
    primary key (privilege, category),
    constraint application_privilege_rel_category_application_category_id_fk
    foreign key (category) references application_privilege_category (id),
    constraint application_privilege_rel_category_application_privilege_id_fk
    foreign key (privilege) references application_privilege (id)
);

