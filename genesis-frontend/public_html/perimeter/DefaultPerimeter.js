import { Perimeter } from 'vue-kindergarten';

export default new Perimeter({
    name: 'Default',

    purpose: 'defaultPerimeter',

    debug: false,

    can: {        
        accessDashboardDemo() {
            return this.accessDashboardDemo();
        },

        accessTheme() {
            return this.accessTheme();
        },

        accessThemeColors() {
            return this.accessThemeColors();
        },

        accessThemeTypography() {
            return this.accessThemeTypography();
        },

        accessComponents() {
            return this.accessComponents();
        },

        accessComponentsBase() {
            return this.accessComponentsBase();
        },

        accessComponentsBaseBreadcrumbs() {
            return this.accessComponentsBaseBreadcrumbs();
        },

        accessComponentsBaseCards() {
            return this.accessComponentsBaseCards();
        },

        accessComponentsBaseCarousels() {
            return this.accessComponentsBaseCarousels();
        },

        accessComponentsBaseCollapses() {
            return this.accessComponentsBaseCollapses();
        },

        accessComponentsBaseJumbotrons() {
            return this.accessComponentsBaseJumbotrons();
        },

        accessComponentsBaseListGroups() {
            return this.accessComponentsBaseListGroups();
        },

        accessComponentsBaseNavs() {
            return this.accessComponentsBaseNavs();
        },

        accessComponentsBaseNavbars() {
            return this.accessComponentsBaseNavbars();
        },

        accessComponentsBasePaginations() {
            return this.accessComponentsBasePaginations();
        },

        accessComponentsBasePopovers() {
            return this.accessComponentsBasePopovers();
        },

        accessComponentsBaseProgressBars() {
            return this.accessComponentsBaseProgressBars();
        },

        accessComponentsBaseSwitches() {
            return this.accessComponentsBaseSwitches();
        },

        accessComponentsBaseTabs() {
            return this.accessComponentsBaseTabs();
        },

        accessComponentsBaseTooltips() {
            return this.accessComponentsBaseTooltips();
        },

        accessComponentsButtons() {
            return this.accessComponentsButtons();
        },

        accessComponentsButtonsButtons() {
            return this.accessComponentsButtonsButtons();
        },

        accessComponentsButtonsBrandButtons() {
            return this.accessComponentsButtonsBrandButtons();
        },

        accessComponentsButtonsButtonGroup() {
            return this.accessComponentsButtonsButtonGroup();
        },

        accessComponentsButtonsButtonDropdowns() {
            return this.accessComponentsButtonsButtonDropdowns();
        },

        /* Not present */
        accessComponentsButtonsLoadingButtons() {
            return this.accessComponentsButtonsLoadingButtons();
        },

        accessComponentsCharts() {
            return this.accessComponentsCharts();
        },

        accessComponentsEditors() {
            return this.accessComponentsEditors();
        },

        accessComponentsEditorsCodeEditors() {
            return this.accessComponentsEditorsCodeEditors();
        },

        accessComponentsEditorsTextEditors() {
            return this.accessComponentsEditorsTextEditors();
        },

        accessComponentsForms() {
            return this.accessComponentsForms();
        },

        accessComponentsFormsBasicForms() {
            return this.accessComponentsFormsBasicForms();
        },

        accessComponentsFormsAdvancedForms() {
            return this.accessComponentsFormsAdvancedForms();
        },

        accessComponentsFormsValidation() {
            return this.accessComponentsFormsValidation();
        },

        accessComponentsGoogleMaps() {
            return this.accessComponentsGoogleMaps();
        },

        accessComponentsIcons() {
            return this.accessComponentsIcons();
        },

        accessComponentsIconsCoreUIIcons() {
            return this.accessComponentsIconsCoreUIIcons();
        },

        accessComponentsIconsFlags() {
            return this.accessComponentsIconsFlags();
        },

        accessComponentsIconsFontAwesome() {
            return this.accessComponentsIconsFontAwesome();
        },

        accessComponentsIconsSimpleLineIcons() {
            return this.accessComponentsIconsSimpleLineIcons();
        },

        accessComponentsNotifications() {
            return this.accessComponentsNotifications();
        },

        accessComponentsNotificationsAlerts() {
            return this.accessComponentsNotificationsAlerts();
        },

        accessComponentsNotificationsBadges() {
            return this.accessComponentsNotificationsBadges();
        },

        accessComponentsNotificationsModals() {
            return this.accessComponentsNotificationsModals();
        },

        accessComponentsNotificationsToastr() {
            return this.accessComponentsNotificationsToastr();
        },

        accessComponentsPlugins() {
            return this.accessComponentsPlugins();
        },

        accessComponentsPluginsDraggable() {
            return this.accessComponentsPluginsDraggable();
        },

        accessComponentsPluginsCalendar() {
            return this.accessComponentsPluginsCalendar();
        },

        accessComponentsPluginsSpinners() {
            return this.accessComponentsPluginsSpinners();
        },

        accessComponentsTables() {
            return this.accessComponentsTables();
        },

        accessComponentsTablesDataTable() {
            return this.accessComponentsTablesDataTable();
        },

        accessComponentsTablesTables() {
            return this.accessComponentsTablesTables();
        },

        accessComponentsWidgets() {
            return this.accessComponentsWidgets();
        },

        accessExtras() {
            return this.accessExtras();
        },

        accessExtrasPages() {
            return this.accessExtrasPages();
        },

        accessExtrasPagesLogin() {
            return this.accessExtrasPagesLogin();
        },

        accessExtrasPagesRegister() {
            return this.accessExtrasPagesRegister();
        },

        accessExtrasPagesError404() {
            return this.accessExtrasPagesError404();
        },

        accessExtrasPagesError500() {
            return this.accessExtrasPagesError500();
        },

        accessExtrasApps() {
            return this.accessExtrasApps()
        },

        accessExtrasAppsInvoicing() {
            return this.accessExtrasAppsInvoicing();
        },

        accessExtrasAppsInvoicingInvoice() {
            return this.accessExtrasAppsInvoicingInvoice();
        },

        accessExtrasAppsEmail() {
            return this.accessExtrasAppsEmail();
        },

        accessExtrasAppsEmailInbox() {
            return this.accessExtrasAppsEmailInbox();
        },

        accessExtrasAppsEmailMessage() {
            return this.accessExtrasAppsEmailMessage();
        },

        accessExtrasAppsEmailCompose() {
            return this.accessExtrasAppsEmailCompose();
        },

        accessLabels() {
            return this.accessLabels();
        },

        accessUpdates() {
            return this.accessUpdates();
        },

        accessUpdatesUpdates() {
            return this.accessUpdatesUpdates();
        },

        accessUpdatesServerStatus() {
            return this.accessUpdatesServerStatus();
        },

        accessTasks() {
            return this.accessTasks();
        },

        accessMessages() {
            return this.accessMessages();
        },

        accessComments() {
            return this.accessComments();
        },

        accessCustomDropdownMenu() {
            return this.accessCustomDropdownMenu();
        },
        
        accessAsideMenu() {
            return this.accessAsideMenu();
        },

        accessAccountAccount() {
            return this.accessAccountAccount();
        },

        accessAccountSettings() {
            return this.accessAccountSettings();
        },

        accessAccountSettingsProfile() {
            return this.accessAccountSettingsProfile();
        },

        accessAccountSettingsSettings() {
            return this.accessAccountSettingsSettings();
        },

        accessAccountSettingsPayments() {
            return this.accessAccountSettingsPayments();
        },

        accessAccountSettingsProjects() {
            return this.accessAccountSettingsProjects();
        },

        accessAccountLockAccount() {
            return this.accessAccountLockAccount();
        },
        
        accessDashboard() {
            return this.accessDashboard();
        },

        accessUsers() {
            return this.accessUsers();
        },
        
        accessRoles() {
            return this.accessRoles();
        },

        accessReports() {
            return this.accessReports();
        },

        accessReportDataRewards() {
            return this.accessReportDataRewards();
        }

    },

    accessAllowed(permission) {
        // user must be authenticated and have required authorization to access a resource
        return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes(permission);
    },

    accessDashboardDemo() {
        return this.accessAllowed('dashboarddemo.access');
    },

    accessTheme() {
        return this.accessThemeColors() ||
                this.accessThemeTypography()
                ;
    },

    accessThemeColors() {
        return this.accessAllowed('theme.colors.access');
    },

    accessThemeTypography() {
        return this.accessAllowed('theme.typography.access');
    },

    accessComponents() {
        return this.accessComponentsBase() ||
                this.accessComponentsButtons() ||
                this.accessComponentsCharts() ||
                this.accessComponentsEditors() ||
                this.accessComponentsForms() ||
                this.accessComponentsGoogleMaps() ||
                this.accessComponentsIcons() ||
                this.accessComponentsNotifications() ||
                this.accessComponentsPlugins() ||
                this.accessComponentsTables() ||
                this.accessComponentsWidgets() /* Not present */
                ;
    },

    accessComponentsBase() {
        return this.accessComponentsBaseBreadcrumbs() ||
                this.accessComponentsBaseCards() ||
                this.accessComponentsBaseCarousels() ||
                this.accessComponentsBaseCollapses() ||
                this.accessComponentsBaseJumbotrons() ||
                this.accessComponentsBaseListGroups() ||
                this.accessComponentsBaseNavs() ||
                this.accessComponentsBaseNavbars() ||
                this.accessComponentsBasePaginations() ||
                this.accessComponentsBasePopovers() ||
                this.accessComponentsBaseProgressBars() ||
                this.accessComponentsBaseSwitches() ||
                this.accessComponentsBaseTabs() ||
                this.accessComponentsBaseTooltips()
                ;
    },

    accessComponentsBaseBreadcrumbs() {
        return this.accessAllowed('components.base.breadcrumbs.access');
    },

    accessComponentsBaseCards() {
        return this.accessAllowed('components.base.cards.access');
    },

    accessComponentsBaseCarousels() {
        return this.accessAllowed('components.base.carousels.access');
    },

    accessComponentsBaseCollapses() {
        return this.accessAllowed('components.base.collapses.access');
    },

    accessComponentsBaseJumbotrons() {
        return this.accessAllowed('components.base.jumbotrons.access');
    },

    accessComponentsBaseListGroups() {
        return this.accessAllowed('components.base.listgroups.access');
    },

    accessComponentsBaseNavs() {
        return this.accessAllowed('components.base.navs.access');
    },

    accessComponentsBaseNavbars() {
        return this.accessAllowed('components.base.navbars.access');
    },

    accessComponentsBasePaginations() {
        return this.accessAllowed('components.base.paginations.access');
    },

    accessComponentsBasePopovers() {
        return this.accessAllowed('components.base.popovers.access');
    },

    accessComponentsBaseProgressBars() {
        return this.accessAllowed('components.base.progressbars.access');
    },

    accessComponentsBaseSwitches() {
        return this.accessAllowed('components.base.switches.access');
    },

    accessComponentsBaseTabs() {
        return this.accessAllowed('components.base.tabs.access');
    },

    accessComponentsBaseTooltips() {
        return this.accessAllowed('components.base.tooltips.access');
    },

    accessComponentsButtons() {
        return this.accessComponentsButtonsButtons() ||
                this.accessComponentsButtonsBrandButtons() ||
                this.accessComponentsButtonsButtonDropdowns() ||
                this.accessComponentsButtonsButtonGroup() ||
                this.accessComponentsButtonsLoadingButtons() /* Not present */
                ;
    },

    accessComponentsButtonsButtons() {
        return this.accessAllowed('components.buttons.buttons.access');
    },

    accessComponentsButtonsBrandButtons() {
        return this.accessAllowed('components.buttons.brandbuttons.access');
    },

    accessComponentsButtonsButtonGroup() {
        return this.accessAllowed('components.buttons.buttonsgroup.access');
    },

    accessComponentsButtonsButtonDropdowns() {
        return this.accessAllowed('components.buttons.buttondropdowns.access');
    },

    /* Not present */
    accessComponentsButtonsLoadingButtons() {
        return this.accessAllowed('components.buttons.loadingbuttons.access');
    },

    accessComponentsCharts() {
        return this.accessAllowed('components.charts.access');
    },

    accessComponentsEditors() {
        return this.accessComponentsEditorsCodeEditors() ||
                this.accessComponentsEditorsTextEditors()
                ;
    },

    accessComponentsEditorsCodeEditors() {
        return this.accessAllowed('components.editors.codeeditors.access');
    },

    accessComponentsEditorsTextEditors() {
        return this.accessAllowed('components.editors.texteditors.access');
    },

    accessComponentsForms() {
        return this.accessComponentsFormsBasicForms() ||
                this.accessComponentsFormsAdvancedForms() ||
                this.accessComponentsFormsValidation()
                ;
    },

    accessComponentsFormsBasicForms() {
        return this.accessAllowed('components.forms.basicforms.access');
    },

    accessComponentsFormsAdvancedForms() {
        return this.accessAllowed('components.forms.advancedforms.access');
    },

    accessComponentsFormsValidation() {
        return this.accessAllowed('components.forms.validation.access');
    },

    accessComponentsGoogleMaps() {
        return this.accessAllowed('components.googlemaps.access');
    },

    accessComponentsIcons() {
        return this.accessComponentsIconsCoreUIIcons() ||
                this.accessComponentsIconsFlags() ||
                this.accessComponentsIconsFontAwesome() ||
                this.accessComponentsIconsSimpleLineIcons()
                ;
    },

    accessComponentsIconsCoreUIIcons() {
        return this.accessAllowed('components.icons.coreuiicons.access');
    },

    accessComponentsIconsFlags() {
        return this.accessAllowed('components.icons.flags.access');
    },

    accessComponentsIconsFontAwesome() {
        return this.accessAllowed('components.icons.fontawesome.access');
    },

    accessComponentsIconsSimpleLineIcons() {
        return this.accessAllowed('components.icons.simplelineicons.access');
    },

    accessComponentsNotifications() {
        return this.accessComponentsNotificationsAlerts() ||
                this.accessComponentsNotificationsBadges() ||
                this.accessComponentsNotificationsModals() ||
                this.accessComponentsNotificationsToastr()
                ;
    },

    accessComponentsNotificationsAlerts() {
        return this.accessAllowed('components.notifications.alerts.access');
    },

    accessComponentsNotificationsBadges() {
        return this.accessAllowed('components.notifications.badges.access');
    },

    accessComponentsNotificationsModals() {
        return this.accessAllowed('components.notifications.modals.access');
    },

    accessComponentsNotificationsToastr() {
        return this.accessAllowed('components.notifications.toastr.access');
    },

    accessComponentsPlugins() {
        return this.accessComponentsPluginsDraggable() ||
                this.accessComponentsPluginsCalendar() ||
                this.accessComponentsPluginsSpinners()
                ;
    },

    accessComponentsPluginsDraggable() {
        return this.accessAllowed('components.plugins.draggable.access');
    },

    accessComponentsPluginsCalendar() {
        return this.accessAllowed('components.plugins.calendar.access');
    },

    accessComponentsPluginsSpinners() {
        return this.accessAllowed('components.plugins.spinners.access');
    },

    accessComponentsTables() {
        return this.accessComponentsTablesDataTable() ||
                this.accessComponentsTablesTables()
                ;
    },

    accessComponentsTablesDataTable() {
        return this.accessAllowed('components.tables.datatable.access');
    },

    accessComponentsTablesTables() {
        return this.accessAllowed('components.tables.tables.access');
    },

    accessComponentsWidgets() {
        return this.accessAllowed('components.widgets.access');
    },

    accessExtras() {
        return this.accessExtrasPages() ||
                this.accessExtrasApps()
                ;
    },

    accessExtrasPages() {
        return this.accessExtrasPagesLogin() ||
                this.accessExtrasPagesRegister() ||
                this.accessExtrasPagesError404() ||
                this.accessExtrasPagesError500()
                ;
    },

    accessExtrasPagesLogin() {
        return this.accessAllowed('extras.pages.login.access');
    },

    accessExtrasPagesRegister() {
        return this.accessAllowed('extras.pages.register.access');
    },

    accessExtrasPagesError404() {
        return this.accessAllowed('extras.pages.error404.access');
    },

    accessExtrasPagesError500() {
        return this.accessAllowed('extras.pages.error500.access');
    },

    accessExtrasApps() {
        return this.accessExtrasAppsInvoicing() ||
                this.accessExtrasAppsEmail()
                ;
    },

    accessExtrasAppsInvoicing() {
        return this.accessExtrasAppsInvoicingInvoice();
    },

    accessExtrasAppsInvoicingInvoice() {
        return this.accessAllowed('extras.apps.invoicing.invoice.access');
    },

    accessExtrasAppsEmail() {
        return this.accessExtrasAppsEmailInbox() ||
                this.accessExtrasAppsEmailMessage() ||
                this.accessExtrasAppsEmailCompose()
                ;
    },

    accessExtrasAppsEmailInbox() {
        return this.accessAllowed('extras.apps.email.inbox.access');
    },

    accessExtrasAppsEmailMessage() {
        return this.accessAllowed('extras.apps.email.message.access');
    },

    accessExtrasAppsEmailCompose() {
        return this.accessAllowed('extras.apps.email.compose.access');
    },

    accessLabels() {
        return this.accessAllowed('labels.access');
    },

    accessUpdates() {
        return this.accessUpdatesUpdates() ||
                this.accessUpdatesServerStatus()
                ;
    },

    accessUpdatesUpdates() {
        return this.accessAllowed('updates.access');
    },

    accessUpdatesServerStatus() {
        return this.accessAllowed('updates.serverStatus.access');
    },

    accessTasks() {
        return this.accessAllowed('tasks.access');
    },

    accessMessages() {
        return this.accessAllowed('messages.access');
    },

    accessComments() {
        return this.accessAllowed('comments.access');
    },

    accessCustomDropdownMenu() {
        return this.accessAllowed('customDropdownMenu.access');
    },
    
    accessAsideMenu() {
        return this.accessAllowed('asideMenu.access');
    },

    accessAccountAccount() {
        return this.accessUpdates() ||
                this.accessTasks() ||
                this.accessMessages() ||
                this.accessComments();
        ;
    },

    accessAccountSettings() {
        return this.accessAccountSettingsProfile() ||
                this.accessAccountSettingsSettings() ||
                this.accessAccountSettingsPayments() ||
                this.accessAccountSettingsProjects()
                ;
    },

    accessAccountSettingsProfile() {
        return this.accessAllowed('account.settings.profile.access');
    },

    accessAccountSettingsSettings() {
        return this.accessAllowed('account.settings.settings.access');
    },

    accessAccountSettingsPayments() {
        return this.accessAllowed('account.settings.payments.access');
    },

    accessAccountSettingsProjects() {
        return this.accessAllowed('account.settings.projects.access');
    },

    accessAccountLockAccount() {
        return this.accessAllowed('account.settings.lockAccount.access');
    },
    
    accessDashboard() {
        return this.accessAllowed('dashboard.access');
    },

    accessUsers() {
        return this.accessAllowed('users.access');
    },
    
    accessRoles() {
        return this.accessAllowed('roles.access');
    },

    accessReports() {
        return this.accessReportDataRewards();
    },

    accessReportDataRewards() {
        return this.accessAllowed('reports.datarewards.access');
    }

});