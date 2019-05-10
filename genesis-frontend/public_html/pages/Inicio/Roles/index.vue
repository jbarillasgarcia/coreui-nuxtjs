<template>
    <div className="animated">
        <b-card>
            <b-card-header>
                <i class="fa fa-key mr-1"></i>&nbsp;Roles del Sistema
                <div class="card-header-actions">
                    <a class="card-header-action" @click="create" style="cursor: pointer" v-if="$rolesPerimeter.isAllowed('create')">
                        <i class="fa fa-plus"></i>
                    </a>
                    <a class="card-header-action" @click="create" style="cursor: pointer" v-if="$rolesPerimeter.isAllowed('download')">
                        <i class="fa fa-download"></i>
                    </a>                    
                </div>
            </b-card-header>
            <b-card-body>
                <v-client-table :columns="columns" :data="data" :options="options" :theme="theme" id="dataTable" class="text-center">                    
                    <template slot="actions" slot-scope="data">
                        <button type="button" class="btn btn-sm btn-info"@click="read(data.row)" v-if="$rolesPerimeter.isAllowed('read')"><span class="fa fa-eye"></span> Ver</button>
                        <button type="button" class="btn btn-sm btn-secondary"@click="update(data.row)" v-if="$rolesPerimeter.isAllowed('update')"><span class="fa fa-edit"></span> Editar</button>
                        <button type="button" class="btn btn-sm btn-danger"@click="remove(data.row)" v-if="$rolesPerimeter.isAllowed('remove')"><span class="fa fa-eraser"></span> Eliminar</button>
                        <button type="button" class="btn btn-sm btn-warning"@click="debug(data.row)" v-if="$rolesPerimeter.isAllowed('debug')"><span class="fa fa-code"></span> Objeto</button>
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

    import RolesPerimeter from '@/perimeter/RolesPerimeter';

    Vue.use(ClientTable);

    export default {
        name: 'DataTable',
        middleware: 'authenticated',
        perimeters: [
            RolesPerimeter
        ],
        components: {
            ClientTable,
            Event
        },
        data: function () {
            return {
                columns: ['name', 'description', 'actions'],
                data: [],
                options: {
                    headings: {
                        name: 'Rol',
                        description: 'Descripción',
                        actions: 'Acciones'
                    },
                    dateColumns: [],
                    sortable: ['name', 'description'],
                    filterable: ['name', 'description'],
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
                let response = await this.$axios.get('/authority/getAllAuthorities');

                this.data = response.data;
            } catch (error) {
                console.error("FATAL: " + error)
            }
        },
        methods: {
            create() {                
                this.$router.push({
                    name: 'Inicio-Roles-Detalle',
                    params: {
                        mode: 'create',
                        title: 'Crear rol'
                    }
                });
            },
            read(item) {                
                this.$router.push({
                    name: 'Inicio-Roles-Detalle',
                    params: {
                        mode: 'view',
                        title: 'Información del rol',
                        roleId: item.id
                    }
                });
            },
            update(item) {                
                this.$router.push({
                    name: 'Inicio-Roles-Detalle',
                    params: {
                        mode: 'edit',
                        title: 'Editar rol',
                        roleId: item.id
                    }
                });
            },
            remove(item) {                
            },
            download() {                
            },
            debug(item) {
                this.modalDebug.title = 'Objeto "' + item.name + '"';
                this.modalDebug.item = item;
                this.$refs.modalDebug.show();
            }
        }
    }
</script>

<style src="./index.scss" lang="scss"/>