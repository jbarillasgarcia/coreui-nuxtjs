import Vue from 'vue';

import moment from 'moment';

import {
Header as AppHeader,
        SidebarToggler,
        Sidebar as AppSidebar,
        SidebarFooter,
        SidebarForm,
        SidebarHeader,
        SidebarMinimizer,
        Aside as AppAside,
        AsideToggler,
        Footer as TheFooter,
        Breadcrumb
        } from '@coreui/vue';

import SidebarNav from '@/components/sidebar/SidebarNav';
import DefaultAside from '@/components/layouts/DefaultAside';
import DefaultHeaderDropdown from '@/components/layouts/DefaultHeaderDropdown';
import DefaultHeaderDropdownNotif from '@/components/layouts/DefaultHeaderDropdownNotif';
import DefaultHeaderDropdownAccnt from '@/components/layouts/DefaultHeaderDropdownAccnt';
import DefaultHeaderDropdownMssgs from '@/components/layouts/DefaultHeaderDropdownMssgs';
import DefaultHeaderDropdownTasks from '@/components/layouts/DefaultHeaderDropdownTasks';

import { capitalize } from '@/middleware/utils';

import menu from './menu';

import DefaultPerimeter from '@/perimeter/DefaultPerimeter';

import {STATUS_ACTIVE, STATUS_INACTIVE, DATETIME_FORMAT} from '@/components/global';

Vue.filter('datetimeFormat', function (value) {
    if (value) {
        return moment(String(value)).format(DATETIME_FORMAT);
    }
});

Vue.filter('enabledDisabled', function (value) {
    return (value) ? STATUS_ACTIVE : STATUS_INACTIVE;
});

Vue.config.productionTip = false;

export default {
    name: 'DefaultContainer',
    perimeters: [
        DefaultPerimeter
    ],
    components: {
        AsideToggler,
        AppHeader,
        AppSidebar,
        AppAside,
        TheFooter,
        Breadcrumb,
        DefaultAside,
        DefaultHeaderDropdown,
        DefaultHeaderDropdownMssgs,
        DefaultHeaderDropdownNotif,
        DefaultHeaderDropdownTasks,
        DefaultHeaderDropdownAccnt,
        SidebarForm,
        SidebarFooter,
        SidebarToggler,
        SidebarHeader,
        SidebarNav,
        SidebarMinimizer
    },
    data() {
        return {
            menu: menu.items
        };
    },
    computed: {
        name() {
            return this.$route.name;
        },
        list() {
            const routeObj = this.$route.matched.filter((route) => route.name || route.meta.label);
            
            let namesList = routeObj[0].name.split('-');            

            let routes = [];
            
            namesList.forEach(function(element) {
               routes.push({
                    text: capitalize(element),
                    href: (element === namesList[0]) ? '/' : '#',
                    active: (element === namesList[namesList.length-1])
               });
            });

            return routes;
        }
    }
}