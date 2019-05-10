INSERT INTO application_user (first_name, last_name, email, address, phone, birth_date, picture, username, password, password_hint, created_date, created_by, last_modified_date, last_modified_by, enabled, default_system_user, removable) VALUES ('Root', 'System', 'root@genesis.com', 'Diagonal 6, Edificio Design Center', '(502) 24658456 Ext. 17', '2019-01-01', null, 'root', '$2a$10$h/xQBmdiK5dfq.de3ammUujIt5rKtPmHX2dASznQy1KuoYEecVg7m', 'uno dos tres cuatro cinco', now(), null, null, null, 1, 1, 0);
INSERT INTO application_user (first_name, last_name, email, address, phone, birth_date, picture, username, password, password_hint, created_date, created_by, last_modified_date, last_modified_by, enabled, default_system_user, removable) VALUES ('Developer', 'System', 'developer@genesis.com', 'Diagonal 6, Edificio Design Center', '(502) 24658456 Ext. 18', '2019-01-01', null, 'dev', '$2a$10$h/xQBmdiK5dfq.de3ammUujIt5rKtPmHX2dASznQy1KuoYEecVg7m', 'uno dos tres cuatro cinco', now(), null, null, null, 1, 1, 0);

INSERT INTO application_authority(name, description) VALUES ('Root', 'Can only modify system settings and manage users.');
INSERT INTO application_authority(name, description) VALUES ('Developer', 'Can only access sample pages and system layouts.');
INSERT INTO application_authority(name, description) VALUES ('Administrator', 'Can manage application users and settings. Cannot edit data.');
INSERT INTO application_authority(name, description) VALUES ('User', 'Can access dashboard. Can perform CRUD operations on data.');

INSERT INTO application_authority_rel_user(authority, user) SELECT aut.id, usr.id FROM application_authority AS aut, application_user AS usr WHERE aut.name = 'Root' AND usr.username = 'root';
INSERT INTO application_authority_rel_user(authority, user) SELECT aut.id, usr.id FROM application_authority AS aut, application_user AS usr WHERE aut.name = 'Developer' AND usr.username = 'dev';

INSERT INTO application_privilege(name, description) VALUES('dashboard.access', 'Can access dashboard.');
INSERT INTO application_privilege(name, description) VALUES('theme.colors.access', 'Can access theme/colors page.');
INSERT INTO application_privilege(name, description) VALUES('theme.typography.access', 'Can access theme/typography page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.breadcrumbs.access', 'Can access components/breadcrumbs page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.cards.access', 'Can access components/cards page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.carousels.access', 'Can access components/carousels page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.collapses.access', 'Can access components/collapses page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.jumbotrons.access', 'Can access components/jumbotrons page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.listgroups.access', 'Can access components/listgroups page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.navs.access', 'Can access components/navs page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.navbars.access', 'Can access components/navbars page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.paginations.access', 'Can access components/paginations page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.popovers.access', 'Can access components/popovers page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.progressbars.access', 'Can access components/progresbars page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.switches.access', 'Can access components/switches page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.tabs.access', 'Can access components/tabs page.');
INSERT INTO application_privilege(name, description) VALUES('components.base.tooltips.access', 'Can access components/tooltips page.');
INSERT INTO application_privilege(name, description) VALUES('components.buttons.buttons.access', 'Can access components/buttons page.');
INSERT INTO application_privilege(name, description) VALUES('components.buttons.brandbuttons.access', 'Can access components/brandbuttons page.');
INSERT INTO application_privilege(name, description) VALUES('components.buttons.buttonsgroup.access', 'Can access components/buttonsgroup page.');
INSERT INTO application_privilege(name, description) VALUES('components.buttons.buttondropdowns.access', 'Can access components/buttondropdowns page.');
INSERT INTO application_privilege(name, description) VALUES('components.buttons.loadingbuttons.access', 'Can access components/loadingbuttons page.');
INSERT INTO application_privilege(name, description) VALUES('components.charts.access', 'Can access components/charts page.');
INSERT INTO application_privilege(name, description) VALUES('components.editors.codeeditors.access', 'Can access components/codeeditors page.');
INSERT INTO application_privilege(name, description) VALUES('components.editors.texteditors.access', 'Can access components/texteditors page.');
INSERT INTO application_privilege(name, description) VALUES('components.forms.basicforms.access', 'Can access components/basicforms page.');
INSERT INTO application_privilege(name, description) VALUES('components.forms.advancedforms.access', 'Can access components/advancedforms page.');
INSERT INTO application_privilege(name, description) VALUES('components.forms.validation.access', 'Can access components/validation page.');
INSERT INTO application_privilege(name, description) VALUES('components.googlemaps.access', 'Can access components/googlemaps page.');
INSERT INTO application_privilege(name, description) VALUES('components.icons.coreuiicons.access', 'Can access components/coreuiicons page.');
INSERT INTO application_privilege(name, description) VALUES('components.icons.flags.access', 'Can access components/flags page.');
INSERT INTO application_privilege(name, description) VALUES('components.icons.fontawesome.access', 'Can access components/fontawesome page.');
INSERT INTO application_privilege(name, description) VALUES('components.icons.simplelineicons.access', 'Can access components/simplelineicons page.');
INSERT INTO application_privilege(name, description) VALUES('components.notifications.alerts.access', 'Can access components/alerts page.');
INSERT INTO application_privilege(name, description) VALUES('components.notifications.badges.access', 'Can access components/badges page.');
INSERT INTO application_privilege(name, description) VALUES('components.notifications.modals.access', 'Can access components/modals page.');
INSERT INTO application_privilege(name, description) VALUES('components.notifications.toastr.access', 'Can access components/toastr page.');
INSERT INTO application_privilege(name, description) VALUES('components.plugins.draggable.access', 'Can access components/draggable page.');
INSERT INTO application_privilege(name, description) VALUES('components.plugins.calendar.access', 'Can access components/calendar page.');
INSERT INTO application_privilege(name, description) VALUES('components.plugins.spinners.access', 'Can access components/spinners page.');
INSERT INTO application_privilege(name, description) VALUES('components.tables.datatable.access', 'Can access components/datatable page.');
INSERT INTO application_privilege(name, description) VALUES('components.tables.tables.access', 'Can access components/tables page.');
INSERT INTO application_privilege(name, description) VALUES('components.widgets.access', 'Can access components/widgets page.');
INSERT INTO application_privilege(name, description) VALUES('extras.pages.login.access', 'Can access extras/login page.');
INSERT INTO application_privilege(name, description) VALUES('extras.pages.register.access', 'Can access extras/register page.');
INSERT INTO application_privilege(name, description) VALUES('extras.pages.error404.access', 'Can access extras/error404 page.');
INSERT INTO application_privilege(name, description) VALUES('extras.pages.error500.access', 'Can access extras/error500 page.');
INSERT INTO application_privilege(name, description) VALUES('extras.apps.invoicing.invoice.access', 'Can access extras/invoice page.');
INSERT INTO application_privilege(name, description) VALUES('extras.apps.email.inbox.access', 'Can access extras/emailinbox page.');
INSERT INTO application_privilege(name, description) VALUES('extras.apps.email.message.access', 'Can access extras/emailmessage page.');
INSERT INTO application_privilege(name, description) VALUES('extras.apps.email.compose.access', 'Can access extras/emailcompose page.');
INSERT INTO application_privilege(name, description) VALUES('labels.access', 'Can access labels page.');
INSERT INTO application_privilege(name, description) VALUES('users.access', 'Can access users page.');
INSERT INTO application_privilege(name, description) VALUES('users.create', 'Can create users.');
INSERT INTO application_privilege(name, description) VALUES('users.read', 'Can read users.');
INSERT INTO application_privilege(name, description) VALUES('users.update', 'Can edit users.');
INSERT INTO application_privilege(name, description) VALUES('users.delete', 'Can delete users.');
INSERT INTO application_privilege(name, description) VALUES('users.export', 'Can export users.');
INSERT INTO application_privilege(name, description) VALUES('users.debug', 'Can see user as object.');
INSERT INTO application_privilege(name, description) VALUES('updates.access', 'Can read updates/notifications.');
INSERT INTO application_privilege(name, description) VALUES('updates.serverStatus.access', 'Can read server statistics.');
INSERT INTO application_privilege(name, description) VALUES('tasks.access', 'Can read tasks.');
INSERT INTO application_privilege(name, description) VALUES('messages.access', 'Can read messages.');
INSERT INTO application_privilege(name, description) VALUES('account.settings.profile.access', 'Can read/update user profile.');
INSERT INTO application_privilege(name, description) VALUES('account.settings.settings.access', 'Can read/update account settings.');
INSERT INTO application_privilege(name, description) VALUES('account.settings.payments.access', 'Can read/update account payments information.');
INSERT INTO application_privilege(name, description) VALUES('account.settings.projects.access', 'Can read/update user projects.');
INSERT INTO application_privilege(name, description) VALUES('account.settings.lockAccount.access', 'Can lock/disable user account.');
INSERT INTO application_privilege(name, description) VALUES('comments.access', 'Can access comments.');
INSERT INTO application_privilege(name, description) VALUES('customDropdownMenu.access', 'Can access custom dropdown menu.');
INSERT INTO application_privilege(name, description) VALUES('reports.datarewards.access', 'Can access Data Rewards report.');
INSERT INTO application_privilege(name, description) VALUES('reports.datarewards.read', 'Can read/search Data Rewards report data.');
INSERT INTO application_privilege(name, description) VALUES('reports.datarewards.export', 'Can export Data Rewards report results.');
INSERT INTO application_privilege(name, description) VALUES('dashboarddemo.access', 'Can access dashboard demo.');
INSERT INTO application_privilege(name, description) VALUES('asideMenu.access', 'Can access right menu.');
INSERT INTO application_privilege(name, description) VALUES('roles.access', 'Can access roles page.');
INSERT INTO application_privilege(name, description) VALUES('roles.create', 'Can create roles.');
INSERT INTO application_privilege(name, description) VALUES('roles.read', 'Can read roles.');
INSERT INTO application_privilege(name, description) VALUES('roles.update', 'Can edit roles.');
INSERT INTO application_privilege(name, description) VALUES('roles.delete', 'Can delete roles.');
INSERT INTO application_privilege(name, description) VALUES('roles.export', 'Can export roles.');
INSERT INTO application_privilege(name, description) VALUES('roles.debug', 'Can see role as JSON string.');


INSERT INTO application_privilege_rel_authority(privilege, authority)
SELECT pri.id, aut.id
FROM application_privilege AS pri, application_authority AS aut
WHERE aut.name = 'Root' AND pri.name IN (
    'dashboard.access',
    'users.access',
    'users.create',
    'users.read',
    'users.update',
    'users.export',
    'users.debug',
    'roles.access',
    'roles.create',
    'roles.read',
    'roles.update',
    'roles.export',
    'roles.debug'
);

INSERT INTO application_privilege_rel_authority(privilege, authority)
SELECT pri.id, aut.id
FROM application_privilege AS pri, application_authority AS aut
WHERE aut.name = 'Developer' AND pri.name IN (
    'dashboarddemo.access',
    'theme.colors.access',
    'theme.typography.access',
    'components.base.breadcrumbs.access',
    'components.base.cards.access',
    'components.base.carousels.access',
    'components.base.collapses.access',
    'components.base.jumbotrons.access',
    'components.base.listgroups.access',
    'components.base.navs.access',
    'components.base.navbars.access',
    'components.base.paginations.access',
    'components.base.popovers.access',
    'components.base.progressbars.access',
    'components.base.switches.access',
    'components.base.tabs.access',
    'components.base.tooltips.access',
    'components.buttons.buttons.access',
    'components.buttons.brandbuttons.access',
    'components.buttons.buttonsgroup.access',
    'components.buttons.buttondropdowns.access',
    'components.buttons.loadingbuttons.access',
    'components.charts.access',
    'components.editors.codeeditors.access',
    'components.editors.texteditors.access',
    'components.forms.basicforms.access',
    'components.forms.advancedforms.access',
    'components.forms.validation.access',
    'components.googlemaps.access',
    'components.icons.coreuiicons.access',
    'components.icons.flags.access',
    'components.icons.fontawesome.access',
    'components.icons.simplelineicons.access',
    'components.notifications.alerts.access',
    'components.notifications.badges.access',
    'components.notifications.modals.access',
    'components.notifications.toastr.access',
    'components.plugins.draggable.access',
    'components.plugins.calendar.access',
    'components.plugins.spinners.access',
    'components.tables.datatable.access',
    'components.tables.tables.access',
    'components.widgets.access',
    'extras.pages.login.access',
    'extras.pages.register.access',
    'extras.pages.error404.access',
    'extras.pages.error500.access',
    'extras.apps.invoicing.invoice.access',
    'extras.apps.email.inbox.access',
    'extras.apps.email.message.access',
    'extras.apps.email.compose.access',
    'labels.access',
    'updates.access',
    'updates.serverStatus.access',
    'tasks.access',
    'messages.access',
    'account.settings.profile.access',
    'account.settings.settings.access',
    'account.settings.payments.access',
    'account.settings.projects.access',
    'account.settings.lockAccount.access',
    'comments.access',
    'customDropdownMenu.access',
    'asideMenu.access'
);

INSERT INTO application_privilege_rel_authority(privilege, authority)
SELECT pri.id, aut.id
FROM application_privilege AS pri, application_authority AS aut
WHERE aut.name = 'Administrator' AND pri.name IN (
    'dashboard.access',
    'users.access',
    'users.create',
    'users.read',
    'users.update',
    'users.export',
    'users.debug',
    'roles.access',
    'roles.create',
    'roles.read',
    'roles.update',
    'roles.export',
    'roles.debug'
);

INSERT INTO application_privilege_rel_authority(privilege, authority)
SELECT pri.id, aut.id
FROM application_privilege AS pri, application_authority AS aut
WHERE aut.name = 'User' AND pri.name IN (
    'dashboard.access',
    'users.access',
    'users.read',
    'reports.datarewards.access',
    'reports.datarewards.read',
    'reports.datarewards.export'
);

INSERT INTO application_privilege_category(name, description) VALUES ('General', 'Permisos de caracter general.');
INSERT INTO application_privilege_category(name, description) VALUES ('Configuración', 'Permisos para configurar el sistema.');
INSERT INTO application_privilege_category(name, description) VALUES ('Usuarios', 'Permisos para gestioar usuarios.');
INSERT INTO application_privilege_category(name, description) VALUES ('Roles', 'Permisos para gestionar roles y permisos.');
INSERT INTO application_privilege_category(name, description) VALUES ('Reportes', 'Permisos para acceder a reportes.');
INSERT INTO application_privilege_category(name, description) VALUES ('Componentes CoreUI', 'Permisos para acceder a componentes de la interfaz grafica del sistema.');
INSERT INTO application_privilege_category(name, description) VALUES ('Plantilla CoreUI', 'Permisos para acceder a elementos de la plantilla del sistema.');
INSERT INTO application_privilege_category(name, description) VALUES ('Catálogos', 'Permisos para gestionar los catálogos del sistema.');
INSERT INTO application_privilege_category(name, description) VALUES ('Otros', 'Permisos que no pueden clasificarse en ninguna de las categorias anteriores.');

INSERT INTO application_privilege_rel_category(privilege, category)
SELECT pri.id, cat.id
FROM application_privilege AS pri, application_privilege_category AS cat
WHERE cat.name = 'General'
AND pri.name IN (
    'dashboard.access'
);

INSERT INTO application_privilege_rel_category(privilege, category)
SELECT pri.id, cat.id
FROM application_privilege AS pri, application_privilege_category AS cat
WHERE cat.name = 'Configuración'
AND pri.name IN (
    ''
);

INSERT INTO application_privilege_rel_category(privilege, category)
SELECT pri.id, cat.id
FROM application_privilege AS pri, application_privilege_category AS cat
WHERE cat.name = 'Usuarios'
AND pri.name IN (
    'users.access',
    'users.create',
    'users.read',
    'users.update',
    'users.delete',
    'users.export',
    'users.debug'
);

INSERT INTO application_privilege_rel_category(privilege, category)
SELECT pri.id, cat.id
FROM application_privilege AS pri, application_privilege_category AS cat
WHERE cat.name = 'Roles'
AND pri.name IN (
    'roles.access',
    'roles.create',
    'roles.read',
    'roles.update',
    'roles.delete',
    'roles.export',
    'roles.debug'
);

INSERT INTO application_privilege_rel_category(privilege, category)
SELECT pri.id, cat.id
FROM application_privilege AS pri, application_privilege_category AS cat
WHERE cat.name = 'Reportes'
AND pri.name IN (
    'reports.datarewards.access',
    'reports.datarewards.read',
    'reports.datarewards.export'
);

INSERT INTO application_privilege_rel_category(privilege, category)
SELECT pri.id, cat.id
FROM application_privilege AS pri, application_privilege_category AS cat
WHERE cat.name = 'Componentes CoreUI'
AND pri.name IN (
    'theme.colors.access',
    'theme.typography.access',
    'components.base.breadcrumbs.access',
    'components.base.cards.access',
    'components.base.carousels.access',
    'components.base.collapses.access',
    'components.base.jumbotrons.access',
    'components.base.listgroups.access',
    'components.base.navs.access',
    'components.base.navbars.access',
    'components.base.paginations.access',
    'components.base.popovers.access',
    'components.base.progressbars.access',
    'components.base.switches.access',
    'components.base.tabs.access',
    'components.base.tooltips.access',
    'components.buttons.buttons.access',
    'components.buttons.brandbuttons.access',
    'components.buttons.buttonsgroup.access',
    'components.buttons.buttondropdowns.access',
    'components.buttons.loadingbuttons.access',
    'components.charts.access',
    'components.editors.codeeditors.access',
    'components.editors.texteditors.access',
    'components.forms.basicforms.access',
    'components.forms.advancedforms.access',
    'components.forms.validation.access',
    'components.googlemaps.access',
    'components.icons.coreuiicons.access',
    'components.icons.flags.access',
    'components.icons.fontawesome.access',
    'components.icons.simplelineicons.access',
    'components.notifications.alerts.access',
    'components.notifications.badges.access',
    'components.notifications.modals.access',
    'components.notifications.toastr.access',
    'components.plugins.draggable.access',
    'components.plugins.calendar.access',
    'components.plugins.spinners.access',
    'components.tables.datatable.access',
    'components.tables.tables.access',
    'components.widgets.access',
    'extras.pages.login.access',
    'extras.pages.register.access',
    'extras.pages.error404.access',
    'extras.pages.error500.access',
    'extras.apps.invoicing.invoice.access',
    'extras.apps.email.inbox.access',
    'extras.apps.email.message.access',
    'extras.apps.email.compose.access',
    'labels.access',
    'dashboarddemo.access',
    'asideMenu.access'
);

INSERT INTO application_privilege_rel_category(privilege, category)
SELECT pri.id, cat.id
FROM application_privilege AS pri, application_privilege_category AS cat
WHERE cat.name = 'Plantilla CoreUI'
AND pri.name IN (
    'updates.access',
    'update.serverStatus.access',
    'tasks.access',
    'messages.access',
    'account.settings.profile.access',
    'account.settings.payments.access',
    'account.settings.projects.access',
    'account.settings.lockAccount.access',
    'comments.access',
    'customDropdownMenu.access'
);

INSERT INTO application_privilege_rel_category(privilege, category)
SELECT pri.id, cat.id
FROM application_privilege AS pri, application_privilege_category AS cat
WHERE cat.name = 'Catálogos'
AND pri.name IN (
    ''
);

INSERT INTO application_privilege_rel_category(privilege, category)
SELECT pri.id, cat.id
FROM application_privilege AS pri, application_privilege_category AS cat
WHERE cat.name = 'Otros'
AND pri.name IN (
    ''
);

INSERT INTO application_privilege_rel_user(privilege, user)
SELECT pri.id, usr.id
FROM application_privilege AS pri, application_user AS usr
WHERE usr.username = 'root' AND pri.name IN (
    'dashboard.access',
    'users.access',
    'users.create',
    'users.read',
    'users.update',
    'users.export',
    'users.debug',
    'roles.access',
    'roles.create',
    'roles.read',
    'roles.update',
    'roles.export',
    'roles.debug'
);

INSERT INTO application_privilege_rel_user(privilege, user)
SELECT pri.id, usr.id
FROM application_privilege AS pri, application_user AS usr
WHERE usr.username = 'dev' AND pri.name IN (
   'dashboarddemo.access',
    'theme.colors.access',
    'theme.typography.access',
    'components.base.breadcrumbs.access',
    'components.base.cards.access',
    'components.base.carousels.access',
    'components.base.collapses.access',
    'components.base.jumbotrons.access',
    'components.base.listgroups.access',
    'components.base.navs.access',
    'components.base.navbars.access',
    'components.base.paginations.access',
    'components.base.popovers.access',
    'components.base.progressbars.access',
    'components.base.switches.access',
    'components.base.tabs.access',
    'components.base.tooltips.access',
    'components.buttons.buttons.access',
    'components.buttons.brandbuttons.access',
    'components.buttons.buttonsgroup.access',
    'components.buttons.buttondropdowns.access',
    'components.buttons.loadingbuttons.access',
    'components.charts.access',
    'components.editors.codeeditors.access',
    'components.editors.texteditors.access',
    'components.forms.basicforms.access',
    'components.forms.advancedforms.access',
    'components.forms.validation.access',
    'components.googlemaps.access',
    'components.icons.coreuiicons.access',
    'components.icons.flags.access',
    'components.icons.fontawesome.access',
    'components.icons.simplelineicons.access',
    'components.notifications.alerts.access',
    'components.notifications.badges.access',
    'components.notifications.modals.access',
    'components.notifications.toastr.access',
    'components.plugins.draggable.access',
    'components.plugins.calendar.access',
    'components.plugins.spinners.access',
    'components.tables.datatable.access',
    'components.tables.tables.access',
    'components.widgets.access',
    'extras.pages.login.access',
    'extras.pages.register.access',
    'extras.pages.error404.access',
    'extras.pages.error500.access',
    'extras.apps.invoicing.invoice.access',
    'extras.apps.email.inbox.access',
    'extras.apps.email.message.access',
    'extras.apps.email.compose.access',
    'labels.access',
    'updates.access',
    'updates.serverStatus.access',
    'tasks.access',
    'messages.access',
    'account.settings.profile.access',
    'account.settings.settings.access',
    'account.settings.payments.access',
    'account.settings.projects.access',
    'account.settings.lockAccount.access',
    'comments.access',
    'customDropdownMenu.access',
    'asideMenu.access'
);