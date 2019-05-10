<template>
    <div className="animated">        
        <b-card>
            <b-card-header>
                <i class="fa fa-user mr-1"></i>&nbsp;Usuarios del Sistema
                <div class="card-header-actions">                    
                    <a class="card-header-action" @click="create" style="cursor: pointer" v-if="$usersPerimeter.isAllowed('create')">
                        <i class="fa fa-user-plus"></i>
                    </a>
                    <a class="card-header-action" @click="create" style="cursor: pointer" v-if="$usersPerimeter.isAllowed('download')">
                        <i class="fa fa-download"></i>
                    </a>                    
                </div>
            </b-card-header>
            <b-card-body>
                <v-client-table :columns="columns" :data="data" :options="options" :theme="theme" id="dataTable" class="text-center">
                    <template slot="enabled" slot-scope="data">
                        <b-badge :variant="(data.row.enabled) ? 'success' : 'secondary'">{{data.row.enabled | enabledDisabled}}</b-badge>
                    </template>
                    <template slot="createdBy" slot-scope="data">
                        {{(data.row.createdBy !== null) ? data.row.createdBy.username : ''}}
                    </template>
                    <template slot="createdDate" slot-scope="data">                        
                        {{data.row.createdDate | datetimeFormat}}
                    </template>
                    <template slot="lastModifiedBy" slot-scope="data">
                        {{(data.row.lastModifiedBy !== null) ? data.row.lastModifiedBy.username : ''}}
                    </template>
                    <template slot="lastModifiedDate" slot-scope="data">                        
                        {{data.row.lastModifiedDate | datetimeFormat}}
                    </template>
                    <template slot="actions" slot-scope="data">
                        <button type="button" class="btn btn-sm btn-info"@click="read(data.row)" v-if="$usersPerimeter.isAllowed('read')"><span class="fa fa-eye"></span> Ver</button>
                        <button type="button" class="btn btn-sm btn-secondary"@click="update(data.row)" v-if="$usersPerimeter.isAllowed('update')"><span class="fa fa-edit"></span> Editar</button>
                        <button type="button" class="btn btn-sm btn-danger"@click="remove(data.row)" v-if="$usersPerimeter.isAllowed('remove')"><span class="fa fa-eraser"></span> Eliminar</button>
                        <button type="button" class="btn btn-sm btn-warning"@click="debug(data.row)" v-if="$usersPerimeter.isAllowed('debug')"><span class="fa fa-code"></span> Objeto</button>
                    </template>
                </v-client-table>                
            </b-card-body>            
        </b-card>
        <b-modal
            scrollable
            v-model="modalShow"
            ref="modalDebug" 
            header-bg-variant="info"
            header-text-variant="light"
            footer-bg-variant="dark"
            footer-text-variant="light"
            size="lg" 
            :title="modalDebug.title">
            <pre>{{modalDebug.item}}</pre>
            <div slot="modal-footer" class="w-100">                
                <b-button size="sm" class="float-right" variant="primary" @click="modalShow = !modalShow">Close</b-button>
            </div>
        </b-modal>
    </div>
</template>

<script>
    import Vue from 'vue';
    import {ClientTable, Event} from 'vue-tables-2';

    import UsersPerimeter from '@/perimeter/UsersPerimeter';

    Vue.use(ClientTable);

    export default {
        name: 'DataTable',
        middleware: 'authenticated',
        perimeters: [
            UsersPerimeter
        ],
        components: {
            ClientTable,
            Event
        },
        data: function () {
            return {
                columns: ['firstName', 'lastName', 'phone', 'email', 'username', 'enabled', 'createdBy', 'createdDate', 'actions'],
                data: [],
                options: {
                    headings: {
                        firstName: 'Nombres',
                        lastName: 'Apellidos',
                        phone: 'Teléfono',
                        email: 'Correo',
                        username: 'Usuario',
                        enabled: 'Estado',
                        createdBy: 'Creado Por',
                        createdDate: 'Fecha de Creación',
                        actions: 'Acciones'
                    },
                    dateColumns: ['createdDate'],
                    sortable: ['firstName', 'lastName', 'phone', 'email', 'username', 'enabled'],
                    filterable: ['firstName', 'lastName', 'phone', 'email', 'username'],
                    sortIcon: {
                        base: 'fa', 
                        up: 'fa-sort-asc', 
                        down: 'fa-sort-desc', 
                        is: 'fa-sort'
                    },
                    pagination: {
                        chunk: 5,
                        edge: false,
                        nav: 'scroll'
                    },
                    perPage: 10,
                    templates: {}
                },
                useVuex: false,
                theme: 'bootstrap4',
                template: 'default',
                modalDebug: {                    
                    title: '',
                    item: {}
                },
                modalShow: false
            }
        },
        async mounted() {
            try {
                let response = await this.$axios.get('/user/getAllUsers');

                this.data = response.data;
            } catch (error) {
                console.error("FATAL: " + error)
            }
        },
        methods: {
            create() {                
                this.$router.push({
                    name: 'Inicio-Usuarios-Detalle',
                    params: {
                        mode: 'create',
                        title: 'Crear usuario'
                    }
                });
            },
            read(item) {
                this.$router.push({
                    name: 'Inicio-Usuarios-Detalle',
                    params: {
                        mode: 'view',
                        title: 'Información del usuario',                        
                        username: item.username
                    }
                });
            },
            update(item) {                
                this.$router.push({
                    name: 'Inicio-Usuarios-Detalle',
                    params: {
                        mode: 'edit',
                        title: 'Editar usuario',
                        username: item.username
                    }
                });
            },
            remove(item) {                
            },
            download() {                
            },
            debug(item) {                
                this.modalDebug.title = 'Objeto "' + item.username + '"';
                this.modalDebug.item = item;
                this.$refs.modalDebug.show();
            }
        }
    }
</script>

<style src="./index.scss" lang="scss"/>