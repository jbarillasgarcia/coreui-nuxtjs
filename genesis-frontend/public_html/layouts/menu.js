export default {
    items: [
        {
            name: 'Dashboard',
            url: '/DashboardDemo',
            icon: 'icon-speedometer',
            badge: {
                variant: 'primary',
                text: 'NEW'
            },
            permission: 'accessDashboardDemo'
        },
        {
            name: 'Dashboard',
            url: '/Dashboard',
            icon: 'icon-speedometer',
            permission: 'accessDashboard'
        },
        {
            title: true,
            name: 'Reportes',
            class: '',
            wrapper: {
                element: '',
                attributes: {}
            },
            permission: 'accessReports'
        },
        {
            name: 'Data Rewards',
            url: '/Inicio/Reportes/DataRewards',
            icon: 'icon-list',
            permission: 'accessReportDataRewards'
        },
        {
            title: true,
            name: 'Theme',
            class: '',
            wrapper: {
                element: '',
                attributes: {}
            },
            permission: 'accessTheme'
        },
        {
            name: 'Colors',
            url: '/theme/colors',
            icon: 'icon-drop',
            permission: 'accessThemeColors'
        },
        {
            name: 'Typography',
            url: '/theme/typography',
            icon: 'icon-pencil',
            permission: 'accessThemeTypography'
        },
        {
            title: true,
            name: 'Components',
            class: '',
            wrapper: {
                element: '',
                attributes: {}
            },
            permission: 'accessComponents'
        },
        {
            name: 'Base',
            url: '/base',
            icon: 'icon-puzzle',
            permission: 'accessComponentsBase',
            children: [
                {
                    name: 'Breadcrumbs',
                    url: '/base/breadcrumbs',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseBreadcrumbs'
                },
                {
                    name: 'Cards',
                    url: '/base/cards',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseCards'
                },
                {
                    name: 'Carousels',
                    url: '/base/carousels',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseCarousels'
                },
                {
                    name: 'Collapses',
                    url: '/base/collapses',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseCollapses'
                },
                {
                    name: 'Jumbotrons',
                    url: '/base/jumbotrons',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseJumbotrons'
                },
                {
                    name: 'List Groups',
                    url: '/base/list-groups',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseListGroups'
                },
                {
                    name: 'Navs',
                    url: '/base/navs',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseNavs'
                },
                {
                    name: 'Navbars',
                    url: '/base/navbars',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseNavbars'
                },
                {
                    name: 'Paginations',
                    url: '/base/paginations',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBasePaginations'
                },
                {
                    name: 'Popovers',
                    url: '/base/popovers',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBasePopovers'
                },
                {
                    name: 'Progress Bars',
                    url: '/base/progress-bars',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseProgressBars'
                },
                {
                    name: 'Switches',
                    url: '/base/switches',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseSwitches'
                },
                {
                    name: 'Tabs',
                    url: '/base/tabs',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseTabs'
                },
                {
                    name: 'Tooltips',
                    url: '/base/tooltips',
                    icon: 'icon-puzzle',
                    permission: 'accessComponentsBaseTooltips'
                }
            ]
        },
        {
            name: 'Buttons',
            url: '/buttons',
            icon: 'icon-cursor',
            permission: 'accessComponentsButtons',
            children: [
                {
                    name: 'Buttons',
                    url: '/buttons/standard-buttons',
                    icon: 'icon-cursor',
                    permission: 'accessComponentsButtonsButtons'
                },
                {
                    name: 'Brand Buttons',
                    url: '/buttons/brand-buttons',
                    icon: 'icon-cursor',
                    permission: 'accessComponentsButtonsBrandButtons'
                },
                {
                    name: 'Button Dropdowns',
                    url: '/buttons/dropdowns',
                    icon: 'icon-cursor',
                    permission: 'accessComponentsButtonsButtonDropdowns'
                },
                {
                    name: 'Button Groups',
                    url: '/buttons/button-groups',
                    icon: 'icon-cursor',
                    permission: 'accessComponentsButtonsButtonsGroup'
                }
            ]
        },
        {
            name: 'Charts',
            url: '/charts',
            icon: 'icon-pie-chart',
            permission: 'accessComponentsCharts'
        },
        {
            name: 'Editors',
            url: '/editors',
            icon: 'fa fa-code',
            permission: 'accessComponentsEditors',            
            children: [
                {
                    name: 'Code Editors',
                    url: '/editors/code-editors',
                    icon: 'fa fa-code',
                    badge: {
                        variant: 'danger',
                        text: 'PRO'
                    },
                    permission: 'accessComponentsEditorsCodeEditors'
                },
                {
                    name: 'Text Editors',
                    url: '/editors/text-editors',
                    icon: 'icon-note',
                    badge: {
                        variant: 'danger',
                        text: 'PRO'
                    },
                    permission: 'accessComponentsEditorsTextEditors'
                }
            ]
        },
        {
            name: 'Forms',
            url: '/forms',
            icon: 'icon-note',
            permission: 'accessComponentsForms',
            children: [
                {
                    name: 'Basic Forms',
                    url: '/forms/basic-forms',
                    icon: 'icon-note',
                    permission: 'accessComponentsFormsBasicForms'
                },
                {
                    name: 'Advanced Forms',
                    url: '/forms/advanced-forms',
                    icon: 'icon-note',
                    badge: {
                        variant: 'danger',
                        text: 'PRO'
                    },
                    permission: 'accessComponentsFormsAdvancedForms'
                },
                {
                    name: 'Validation',
                    url: '/forms/validation-forms',
                    icon: 'icon-note',
                    badge: {
                        variant: 'danger',
                        text: 'PRO'
                    },
                    permission: 'accessComponentsFormsValidation'
                }
            ]
        },
        {
            name: 'Google Maps',
            url: '/google-maps',
            icon: 'icon-map',
            badge: {
                variant: 'danger',
                text: 'PRO'
            },
            permission: 'accessComponentsGoogleMaps'
        },
        {
            name: 'Icons',
            url: '/icons',
            icon: 'icon-star',
            permission: 'accessComponentsIcons',
            children: [
                {
                    name: 'CoreUI Icons',
                    url: '/icons/coreui-icons',
                    icon: 'icon-star',
                    badge: {
                        variant: 'info',
                        text: 'NEW'
                    },
                    permission: 'accessComponentsIconsCoreUIIcons'
                },
                {
                    name: 'Flags',
                    url: '/icons/flags',
                    icon: 'icon-star',
                    permission: 'accessComponentsIconsFlags'
                },
                {
                    name: 'Font Awesome',
                    url: '/icons/font-awesome',
                    icon: 'icon-star',
                    badge: {
                        variant: 'secondary',
                        text: '4.7'
                    },
                    permission: 'accessComponentsIconsFontAwesome'
                },
                {
                    name: 'Simple Line Icons',
                    url: '/icons/simple-line-icons',
                    icon: 'icon-star',
                    permission: 'accessComponentsIconsSimpleLineIcons'
                }
            ]
        },
        {
            name: 'Notifications',
            url: '/notifications',
            icon: 'icon-bell',
            permission: 'accessComponentsNotifications',
            children: [
                {
                    name: 'Alerts',
                    url: '/notifications/alerts',
                    icon: 'icon-bell',
                    permission: 'accessComponentsNotificationsAlerts'
                },
                {
                    name: 'Badges',
                    url: '/notifications/badges',
                    icon: 'icon-bell',
                    permission: 'accessComponentsNotificationsBadges'
                },
                {
                    name: 'Modals',
                    url: '/notifications/modals',
                    icon: 'icon-bell',
                    permission: 'accessComponentsNotificationsModals'
                },
                {
                    name: 'Toastr',
                    url: '/notifications/toastr',
                    icon: 'icon-bell',
                    badge: {
                        variant: 'danger',
                        text: 'PRO'
                    },
                    permission: 'accessComponentsNotificationsToastr'
                }
            ]
        },
        {
            name: 'Plugins',
            url: '/plugins',
            icon: 'icon-energy',
            permission: 'accessComponentsPlugins',
            children: [
                {
                    name: 'Draggable',
                    url: '/plugins/draggable',
                    icon: 'icon-cursor-move',
                    badge: {
                        variant: 'danger',
                        text: 'PRO'
                    },
                    permission: 'accessComponentsPluginsDraggable'
                },
                {
                    name: 'Calendar',
                    url: '/plugins/calendar',
                    icon: 'icon-calendar',
                    badge: {
                        variant: 'danger',
                        text: 'PRO'
                    },
                    permission: 'accessComponentsPluginsCalendar'
                },
                {
                    name: 'Spinners',
                    url: '/plugins/spinners',
                    icon: 'fa fa-spinner',
                    badge: {
                        variant: 'danger',
                        text: 'PRO'
                    },
                    permission: 'accessComponentsPluginsSpinners'
                },
            ]
        },
        {
            name: 'Tables',
            url: '/tables',
            icon: 'icon-list',
            permission: 'accessComponentsTables',
            children: [
                {
                    name: 'Data Table',
                    url: '/tables/Datatable',
                    icon: 'icon-list',
                    badge: {
                        variant: 'danger',
                        text: 'PRO'
                    },
                    permission: 'accessComponentsTablesDataTable'
                },
                {
                    name: 'Tables',
                    url: '/tables/SimpleTables',
                    icon: 'icon-list',
                    permission: 'accessComponentsTablesTables'
                }
            ]
        },
        {
            name: 'Widgets',
            url: '/widgets',
            icon: 'icon-calculator',
            badge: {
                variant: 'primary',
                text: 'NEW'
            },
            permission: 'accessComponentsWidgets'
        },
        {
            divider: true
        },
        {
            title: true,
            name: 'Extras',
            permission: 'accessExtras'
        },
        {
            name: 'Pages',
            url: '/pages',
            icon: 'icon-star',
            permission: 'accessExtrasPages',
            children: [
                {
                    name: 'Login',
                    url: '/login',
                    icon: 'icon-star',
                    permission: 'accessExtrasPagesLogin'
                },
                {
                    name: 'Register',
                    url: '/register',
                    icon: 'icon-star',
                    permission: 'accessExtrasPagesRegister'
                },
                {
                    name: 'Error 404',
                    url: '/pages/404',
                    icon: 'icon-star',
                    permission: 'accessExtrasPagesError404'
                },
                {
                    name: 'Error 500',
                    url: '/pages/500',
                    icon: 'icon-star',
                    permission: 'accessExtrasPagesError500'
                }
            ]
        },
        {
            name: 'Apps',
            url: '/apps',
            icon: 'icon-layers',
            permission: 'accessExtrasApps',
            children: [
                {
                    name: 'Invoicing',
                    url: '/apps/invoicing',
                    icon: 'icon-speech',
                    permission: 'accessExtrasAppsInvoicing',
                    children: [
                        {
                            name: 'Invoice',
                            url: '/apps/invoicing/invoice',
                            icon: 'icon-speech',
                            badge: {
                                variant: 'danger',
                                text: 'PRO'
                            },
                            permission: 'accessExtrasAppsInvoicingInvoice'
                        }
                    ]
                },
                {
                    name: 'Email',
                    url: '/apps/email',
                    icon: 'icon-speech',
                    permission: 'accessExtrasAppsEmail',
                    children: [
                        {
                            name: 'Inbox',
                            url: '/apps/email/inbox',
                            icon: 'icon-speech',
                            badge: {
                                variant: 'danger',
                                text: 'PRO'
                            },
                            permission: 'accessExtrasAppsEmailInbox'
                        },
                        {
                            name: 'Message',
                            url: '/apps/email/message',
                            icon: 'icon-speech',
                            badge: {
                                variant: 'danger',
                                text: 'PRO'
                            },
                            permission: 'accessExtrasAppsEmailMessage'
                        },
                        {
                            name: 'Compose',
                            url: '/apps/email/compose',
                            icon: 'icon-speech',
                            badge: {
                                variant: 'danger',
                                text: 'PRO'
                            },
                            permission: 'accessExtrasAppsEmailCompose'
                        }
                    ]
                }
            ]
        },
        {
            divider: true,
            class: 'm-2'
        },
        {
            title: true,
            name: 'Labels',
            permission: 'accessLabels'
        },
        {
            name: 'Label danger',
            url: '',
            icon: 'fa fa-circle',
            label: {
                variant: 'danger'
            },
            permission: 'accessLabels'
        },
        {
            name: 'Label info',
            url: '',
            icon: 'fa fa-circle',
            label: {
                variant: 'info'
            },
            permission: 'accessLabels'
        },
        {
            name: 'Label warning',
            url: '',
            icon: 'fa fa-circle',
            label: {
                variant: 'warning'
            },
            permission: 'accessLabels'
        }
    ]
}
