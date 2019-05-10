<template>
    <div class="app">
        <AppHeader fixed>
            <SidebarToggler class="d-lg-none" display="md" mobile />
            <b-link class="navbar-brand" to="/">
                <img class="navbar-brand-full" src="img/brand/wautext.png" height="48" alt="CoreUI Logo">
                <img class="navbar-brand-minimized" src="img/brand/wau.png" width="32" height="32" alt="CoreUI Logo">
            </b-link>
            <SidebarToggler class="d-md-down-none" display="lg" />
            <b-navbar-nav class="d-md-down-none">
                <b-nav-item class="px-3" to="/DashboardDemo" v-if="$defaultPerimeter.isAllowed('accessDashboardDemo')">Dashboard</b-nav-item>
                <b-nav-item class="px-3" to="/Dashboard" v-if="$defaultPerimeter.isAllowed('accessDashboard')">Dashboard</b-nav-item>
                <b-nav-item class="px-3" to="/Inicio/Usuarios" exact v-if="$defaultPerimeter.isAllowed('accessUsers')">Usuarios</b-nav-item>
                <b-nav-item class="px-3" to="/Inicio/Roles" exact v-if="$defaultPerimeter.isAllowed('accessRoles')">Roles</b-nav-item>
                <b-nav-item class="px-3" v-if="$defaultPerimeter.isAllowed('accessAccountSettingsSettings')">Settings</b-nav-item>
            </b-navbar-nav>
            <b-navbar-nav class="ml-auto">
                <b-nav-item class="d-md-down-none" v-if="$defaultPerimeter.isAllowed('accessUpdates')">
                    <DefaultHeaderDropdownNotif/>
                </b-nav-item>
                <b-nav-item class="d-md-down-none" v-if="$defaultPerimeter.isAllowed('accessTasks')">
                    <DefaultHeaderDropdownTasks/>
                </b-nav-item>
                <b-nav-item class="d-md-down-none" v-if="$defaultPerimeter.isAllowed('accessMessages')">
                    <DefaultHeaderDropdownMssgs/>
                </b-nav-item>
                <b-nav-item class="d-md-down-none">
                    <DefaultHeaderDropdown v-if="$defaultPerimeter.isAllowed('accessCustomDropdownMenu')"/>
                </b-nav-item>
                <DefaultHeaderDropdownAccnt/>
            </b-navbar-nav>
            <AsideToggler v-if="$defaultPerimeter.isAllowed('accessAsideMenu')" class="d-none d-lg-block" />
            <!--<AsideToggler class="d-lg-none" mobile />-->
        </AppHeader>
        <div class="app-body">
            <AppSidebar fixed>
                <SidebarHeader/>
                <SidebarForm/>
                <SidebarNav :navItems="menu"></SidebarNav>
                <SidebarFooter/>
                <SidebarMinimizer/>
            </AppSidebar>
            <main class="main">
                <!--<Breadcrumb :list="list"/>-->
                <b-breadcrumb :items="list" />
                <div class="container-fluid">
                    <!--<router-view></router-view>-->
                    <nuxt/>
                </div>
            </main>
            <AppAside fixed>
                <!--aside-->
                <DefaultAside/>
            </AppAside>
        </div>
        <TheFooter>
            <!--footer-->
            <div>
                <a href="http://www.wau.com/" target="blank">Wau M&oacute;vil</a>
                <span class="ml-1">&copy; 2019</span>
            </div>
            <div class="ml-auto">
                <span class="mr-1"><small>Powered by</small></span>
                <a href="https://coreui.io"><small>CoreUI for Vue</small></a>
            </div>
        </TheFooter>
    </div>
</template>

<script src="./default.js"/>

<style src="./default.scss" lang="scss"/>