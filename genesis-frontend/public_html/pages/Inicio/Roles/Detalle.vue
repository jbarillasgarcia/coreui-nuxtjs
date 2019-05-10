<template>
    <div class="animated fadeIn">
        <b-form @submit.prevent="save">
            <b-row>
                <b-col lg="12">  
                    <b-card-group columns>
                        <b-card title="Rol" sub-title="Información del rol" bg-variant="primary" text-variant="white">
                            <b-card-body>                            
                                <fieldset class="form-group">
                                    <label>Nombre:</label>
                                    <div class="input-group">
                                        <span class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-address-book-o"></i>
                                            </span>
                                        </span>
                                        <input type="text" class="form-control" id="name-input" v-model="item.name" required :readonly="mode === 'view'">
                                    </div>
                                    <small class="text-muted">Ejemplo: Operador</small>
                                </fieldset>

                                <fieldset class="form-group">
                                    <label>Descripci&oacute;n:</label>
                                    <div class="input-group">
                                        <span class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-info"></i>
                                            </span>
                                        </span>
                                        <input type="text" class="form-control" id="description-input" v-model="item.description" required :readonly="mode === 'view'">
                                    </div>
                                    <small class="text-muted">Ejemplo: Permite realizar consultas a los reportes G&eacute;nesis.</small>
                                </fieldset>

                                <div class="text-right">
                                    <button type="submit" class="btn btn-light btn-sm" v-if="($rolesPerimeter.isAllowed('create') || $rolesPerimeter.isAllowed('update')) && mode !== 'view'"><span class="fa fa-save"></span> Guardar</button>
                                    <button type="button" class="btn btn-light btn-sm" v-if="$rolesPerimeter.isAllowed('update') && mode === 'view'" @click="mode = 'edit'"><span class="fa fa-edit"></span> Editar</button>
                                    <button type="button" class="btn btn-danger btn-sm" @click="cancel"><span class="fa fa-close"></span>&nbsp;Cancelar</button>
                                </div>
                            </b-card-body>                         
                        </b-card>                        
                    </b-card-group>
                </b-col>            
            </b-row>
            <b-row>   
                <b-col lg="12">                
                    <b-card-group>
                        <b-card title="Permisos" sub-title="Todos los permisos del rol">
                            <b-tabs>
                                <b-tab :title="privilegeCategory.name" v-for="privilegeCategory in displayPrivilegeCategories" :key="privilegeCategory.id" v-if="privilegeCategory.privileges.length > 0">
                                    <b-row>
                                        <b-col lg="12" style="padding: 20px; padding-bottom: 30px;" class="text-muted">{{privilegeCategory.description}}</b-col>
                                    </b-row>
                                    <b-row>                                    
                                        <b-col lg="4" v-for="privilege in privilegeCategory.privileges" :key="privilege.id">
                                            <fieldset class="form-group row">                                            
                                                <div class="input-group" style="width: 75px; padding-left: 15px;">                                    
                                                    <label class="switch switch-sm switch-label switch-info">
                                                        <input 
                                                            type="checkbox" 
                                                            class="switch-input" 
                                                            checked 
                                                            v-model="privilege.selected"
                                                            :disabled="mode === 'view'">
                                                        <span class="switch-slider" data-checked="✓" data-unchecked="✕"></span>                                        
                                                    </label>                                                
                                                </div>
                                                <div class="col-lg-9" style="padding-left: 0;">
                                                    <label class="col-lg-12" style="padding-left: 0; margin-bottom: 0;">{{privilege.description}}</label>
                                                    <small class="text-muted">Code: {{privilege.name}}</small>
                                                </div>
                                            </fieldset>
                                        </b-col>
                                    </b-row>
                                </b-tab>                            
                            </b-tabs>
                            <br/>
                            <div class="text-right">
                                <button type="submit" class="btn btn-primary btn-sm" v-if="($rolesPerimeter.isAllowed('create') || $rolesPerimeter.isAllowed('update')) && mode !== 'view'"><span class="fa fa-save"></span> Guardar</button>
                                <button type="button" class="btn btn-primary btn-sm" v-if="$rolesPerimeter.isAllowed('update') && mode === 'view'" @click="mode = 'edit'"><span class="fa fa-edit"></span> Editar</button>
                                <button type="button" class="btn btn-danger btn-sm" @click="cancel"><span class="fa fa-close"></span>&nbsp;Cancelar</button>
                            </div>                        
                        </b-card>
                    </b-card-group>
                </b-col>
            </b-row>
        </b-form>        
    </div>
</template>

<script>
    import Vue from 'vue';        
    import toastr from 'toastr';
    import 'toastr/toastr.js';
    import 'toastr/toastr.scss';

    import RolesPerimeter from '@/perimeter/RolesPerimeter';

    export default {
        name: 'RolesDetalle',
        middleware: 'authenticated',
        perimeters: [
            RolesPerimeter
        ],
        data() {
            return {
                mode: 'create', // edit | view | resetPassword
                title: 'Untitled',
                item: {},                
                displayPrivilegeCategories: []
            }
        },
        async created() {
            this.mode = this.$route.params.mode;
            this.title = this.$route.params.title;

            if (this.$route.params.roleId === undefined) {
                this.item = {
                    name: null,
                    description: null,
                    privileges: []
                }
            } else {
                // Get role information
                try {
                    const roleResponse = await this.$axios.get('/authority/getAuthorityById', {
                        params: {
                            authorityId: this.$route.params.roleId
                        }
                    });

                    this.item = roleResponse.data;
                } catch (error) {
                    console.error('FATAL: ' + error);
                }                
            }


            toastr.options.closeButton = true;
            toastr.options.newestOnTop = false;
            toastr.options.timeOut = 5000; // How long the toast will display without user interaction. If 0, the toastr will persist until selected.
            toastr.options.extendedTimeOut = 5000; // How long the toast will display after a user hovers over it. If 0, the toastr will persist until selected.
            toastr.options.progressBar = true;
            toastr.options.preventDuplicates = true;
        },
        async mounted() {
            // Get all privileges by category            
            let buildDisplayPrivilegeCategories = [];

            try {
                const allPrivilegeCategoriesResponse = await this.$axios.get('/privilegeCategory/getAllCategories');

                buildDisplayPrivilegeCategories = allPrivilegeCategoriesResponse.data;
            } catch (error) {
                console.error('FATAL: ' + error);
            }

            if (this.mode !== 'create') {
                // Set selected privileges
                for (let i = 0; i < buildDisplayPrivilegeCategories.length; i++) {
                    for (let j = 0; j < buildDisplayPrivilegeCategories[i].privileges.length; j++) {
                        for (let k = 0; k < this.item.privileges.length; k++) {
                            if (this.item.privileges[k].id === buildDisplayPrivilegeCategories[i].privileges[j].id) {
                                buildDisplayPrivilegeCategories[i].privileges[j].selected = true;
                            }
                        }
                    }
                }
            }

            this.displayPrivilegeCategories = buildDisplayPrivilegeCategories;            
        },
        methods: {            
            async save() {
                //console.log('Save ' + JSON.stringify(this.item));

                try {
                    let response = null;
                    
                    this.item.privileges = [];

                    for (let i = 0; i < this.displayPrivilegeCategories.length; i++) {
                        for (let j = 0; j < this.displayPrivilegeCategories[i].privileges.length; j++) {
                            if (this.displayPrivilegeCategories[i].privileges[j].selected === true) {
                                this.item.privileges.push({
                                    id: this.displayPrivilegeCategories[i].privileges[j].id,
                                    name: this.displayPrivilegeCategories[i].privileges[j].name,
                                    description: this.displayPrivilegeCategories[i].privileges[j].description
                                });
                            }
                        }
                    }

                    if (this.mode === 'create') {
                        response = await this.$axios.post('/authority/createAuthority', this.item);
                    } else {
                        response = await this.$axios.put('/authority/updateAuthority', this.item);
                    }

                    this.item = response.data;

                    toastr.remove();
                    toastr.success('El rol ' + this.item.name + ' ha sido ' + (this.mode === 'create' ? 'creado' : 'actualizado') + ' satisfactoriamente.', 'Rol ' + (this.mode === 'create' ? 'creado' : 'actualizado'));

                    // go back to List view
                    this.$router.go(-1);
                } catch (error) {
                    let message = error.response.data.message.split('|');

                    toastr.remove();
                    toastr.error(message[1], message[0]);
                }
            },
            cancel() {
                console.log('Cancel/close');

                if (this.mode === 'view' || this.item.id === undefined) {
                    this.$router.go(-1);
                } else {
                    this.mode = 'view';
                }
            }            
        }
    }
</script>