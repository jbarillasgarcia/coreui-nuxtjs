<template>
    <AppHeaderDropdown right no-caret>        
        <template slot="header">
            <a class="nav-label" href="#">{{this.$store.state.auth.user.firstName}} {{this.$store.state.auth.user.lastName}}</a>
            <img
                src="img/avatars/6.jpg"
                class="img-avatar"
                alt="admin@bootstrapmaster.com" />
        </template>
        <template slot="dropdown">
            <b-dropdown-header tag="div" class="text-center"  v-if="$defaultPerimeter.isAllowed('accessAccountAccount')"><strong>Account</strong></b-dropdown-header>
            <b-dropdown-item  v-if="$defaultPerimeter.isAllowed('accessUpdates')"><i class="fa fa-bell-o" /> Updates
                <b-badge variant="info">{{ itemsCount }}</b-badge>
            </b-dropdown-item>
            <b-dropdown-item v-if="$defaultPerimeter.isAllowed('accessMessages')"><i class="fa fa-envelope-o" /> Messages
                <b-badge variant="success">{{ itemsCount }}</b-badge>
            </b-dropdown-item>
            <b-dropdown-item v-if="$defaultPerimeter.isAllowed('accessTasks')"><i class="fa fa-tasks" /> Tasks
                <b-badge variant="danger">{{ itemsCount }}</b-badge>
            </b-dropdown-item>
            <b-dropdown-item v-if="$defaultPerimeter.isAllowed('accessComments')"><i class="fa fa-comments" /> Comments
                <b-badge variant="warning">{{ itemsCount }}</b-badge>
            </b-dropdown-item>
            <b-dropdown-header
                tag="div"
                class="text-center"
                v-if="$defaultPerimeter.isAllowed('accessAccountSettings')">
                <strong>Settings</strong>
            </b-dropdown-header>
            <b-dropdown-item @click="userProfile" v-if="$defaultPerimeter.isAllowed('accessAccountSettingsProfile') || $usersPerimeter.isAllowed('read') || $usersPerimeter.isAllowed('update')"><i class="fa fa-user" /> Profile</b-dropdown-item>
            <b-dropdown-item v-if="$defaultPerimeter.isAllowed('accessAccountSettingsSettings')"><i class="fa fa-wrench" /> Settings</b-dropdown-item>
            <b-dropdown-item v-if="$defaultPerimeter.isAllowed('accessAccountSettingsPayments')"><i class="fa fa-usd" /> Payments
                <b-badge variant="secondary">{{ itemsCount }}</b-badge>
            </b-dropdown-item>
            <b-dropdown-item v-if="$defaultPerimeter.isAllowed('accessAccountSettingsProjects')"><i class="fa fa-file" /> Projects
                <b-badge variant="primary">{{ itemsCount }}</b-badge>
            </b-dropdown-item>
            <b-dropdown-divider v-if="$defaultPerimeter.isAllowed('accessAccountLockAccount')" />
            <b-dropdown-item v-if="$defaultPerimeter.isAllowed('accessAccountLockAccount')"><i class="fa fa-shield" /> Lock Account</b-dropdown-item>
            <b-dropdown-item @click="logout" ><i class="fa fa-lock" /> Logout</b-dropdown-item>
        </template>
    </AppHeaderDropdown>
</template>

<script>    
    import { HeaderDropdown as AppHeaderDropdown } from '@coreui/vue';
    import { capitalize } from '@/middleware/utils';
    import DefaultPerimeter from '@/perimeter/DefaultPerimeter';
    import UsersPerimeter from '@/perimeter/UsersPerimeter';
    export default {
        name: 'DefaultHeaderDropdownAccnt',
        perimeters: [
            DefaultPerimeter,
            UsersPerimeter
        ],
        components: {
            AppHeaderDropdown
        },
        data: () => {
            return {itemsCount: 42}
        },
        methods: {
            userProfile() {
                this.$router.push({
                    name: 'Inicio-Usuarios-Detalle',
                    params: {
                        mode: 'view',
                        title: 'Información del usuario',
                        username: this.$store.state.auth.user.username
                    }
                });
            },
            async logout() {
                //await this.$auth.fetchUser();

                await this.$auth.logout().then(function () {
                    console.log("Logged out!!!");
                });

                this.$router.push('/Login');
            }
        }
    }

</script>
