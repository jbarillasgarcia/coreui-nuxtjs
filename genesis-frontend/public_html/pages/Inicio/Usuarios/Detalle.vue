<template>
    <div class="animated fadeIn">
        <b-form @submit.prevent="save">
            <b-row>
                <b-col lg="12">                
                    <b-card-group columns>
                        <b-card title="Personal" sub-title="Información personal del usuario" bg-variant="primary" text-variant="white">
                            <b-card-body>
                                <fieldset class="form-group">
                                    <label>Nombres:</label>
                                    <div class="input-group">
                                        <span class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-address-book-o"></i>
                                            </span>
                                        </span>
                                        <input type="text" class="form-control" id="first-name-input" v-model="item.firstName" required :readonly="mode === 'view'">
                                    </div>
                                    <small class="text-muted">Ejemplo: John</small>
                                </fieldset>

                                <fieldset class="form-group">
                                    <label>Apellidos:</label>
                                    <div class="input-group">
                                        <span class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-address-book-o"></i>
                                            </span>
                                        </span>
                                        <input type="text" class="form-control" id="last-name-input" v-model="item.lastName" required :readonly="mode === 'view'">
                                    </div>
                                    <small class="text-muted">Ejemplo: Doe</small>
                                </fieldset>

                                <fieldset class="form-group">
                                    <label>Correo electrónico:</label>
                                    <div class="input-group">
                                        <span class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-at"></i>
                                            </span>
                                        </span>
                                        <input type="text" class="form-control" id="email-input" v-model="item.email" required :readonly="mode === 'view'">
                                    </div>
                                    <small class="text-muted">Ejemplo: john.doe@genesis.com</small>
                                </fieldset>

                                <fieldset class="form-group">
                                    <label>Tel&eacute;fono:</label>
                                    <div class="input-group">
                                        <span class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-phone"></i>
                                            </span>
                                        </span>
                                        <input type="text" class="form-control" id="phone-input" v-model="item.phone" :readonly="mode === 'view'">
                                    </div>
                                    <small class="text-muted">Ejemplo: (502) 30215468, 24775842 ext. 10, 1550</small>
                                </fieldset>

                                <fieldset class="form-group">
                                    <label>Direcci&oacute;n:</label>
                                    <div class="input-group">
                                        <span class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-address-card-o"></i>
                                            </span>
                                        </span>
                                        <input type="text" class="form-control" id="address-input" v-model="item.address" :readonly="mode === 'view'">
                                    </div>
                                    <small class="text-muted">Ejemplo: Diagonal 6, Edificio Design Center Zona 10, Guatemala</small>
                                </fieldset>

                                <fieldset class="form-group">
                                    <label>Fecha de nacimiento:</label>
                                    <div class="input-group">
                                        <span class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-birthday-cake"></i>
                                            </span>
                                        </span>
                                        <input type="date" class="form-control" id="birthday-input" v-model="item.birthday" :readonly="mode === 'view'">
                                    </div>
                                    <small class="text-muted">Ejemplo: 2019/03/01</small>
                                </fieldset>  
                                <div class="text-right">
                                    <button type="submit" class="btn btn-light btn-sm" v-if="($usersPerimeter.isAllowed('create') || $usersPerimeter.isAllowed('update')) && mode !== 'view'"><span class="fa fa-save"></span> Guardar</button>
                                    <button type="button" class="btn btn-light btn-sm" v-if="$usersPerimeter.isAllowed('update') && mode === 'view'" @click="mode = 'edit'"><span class="fa fa-edit"></span> Editar</button>
                                    <button type="button" class="btn btn-danger btn-sm" @click="cancel"><span class="fa fa-close"></span>&nbsp;Cancelar</button>
                                </div>
                            </b-card-body>                         
                        </b-card>
                        <b-card title="Imagen" sub-title="Avatar del usuario">
                            <b-card-body>
                                <b-col lg="6" class="offset-3">
                                    <!--<img src="https://openclipart.org/download/247319/abstract-user-flat-3.svg" alt="my photo" class="img-thumbnail">-->
                                    <!--<img :src="pictureBytes" alt="my photo" class="img-thumbnail">-->
                                    <img src="~/static/img/avatars/sample.svg" alt="my photo" class="img-thumbnail">
                                    <!--<img src="img/avatars/6.jpg" class="img-avatar" alt="my photo" width="100px" height="100px" />-->
                                </b-col>
                                <fieldset class="form-group">
                                    <label>Archivo:</label>
                                    <b-form-file
                                        v-model="userPicture"
                                        accept="image/jpeg, image/png"
                                        browse-text="Buscar"
                                        :state="Boolean(userPicture)"
                                        placeholder="Choose a file..."
                                        drop-placeholder="Drop file here..."
                                        disabled
                                        />
                                    <small class="text-muted">Formato: JPG, PNG | Tama&ntilde;o m&aacute;ximo: 180x180 pixeles</small>
                                </fieldset>
                                <div class="text-right">
                                    <button type="submit" class="btn btn-primary btn-sm" v-if="($usersPerimeter.isAllowed('create') || $usersPerimeter.isAllowed('update')) && mode !== 'view'"><span class="fa fa-save"></span> Guardar</button>
                                    <button type="button" class="btn btn-primary btn-sm" v-if="$usersPerimeter.isAllowed('update') && mode === 'view'" @click="mode = 'edit'"><span class="fa fa-edit"></span> Editar</button>
                                </div>
                            </b-card-body>                        
                        </b-card>
                        <b-card title="Atributos" sub-title="Información interna del sistema">                            
                            <b-table striped small hover :items="internalData" :fields="internalDataFields"/>
                    </b-card>
                    <b-card title="Cuenta" sub-title="Cuenta del sistema">
                        <b-card-body>
                            <fieldset class="form-group">
                                <label>Usuario:</label>
                                <div class="input-group">
                                    <span class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa fa-user"></i>
                                        </span>
                                    </span>
                                    <input type="text" class="form-control" id="username-input" v-model="item.username" required :readonly="mode === 'view'">
                                </div>
                                <small class="text-muted">Ejemplo: jdoe</small>
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Contrase&ntilde;a:</label>
                                <div class="input-group">
                                    <span class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa fa-asterisk"></i>
                                        </span>
                                    </span>
                                    <input type="password" class="form-control" id="last-name-input" v-model="item.password" readonly="true" @click="showPasswordModal" placeholder="Haga clic para especificar contraseña" required :disabled="mode === 'view'">
                                </div>
                                <small class="text-muted">Ejemplo: K@m!k@z3</small>
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Indicio de contrase&ntilde;a:</label>
                                <div class="input-group">
                                    <span class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa fa-question-circle"></i>
                                        </span>
                                    </span>
                                    <input type="text" class="form-control" id="email-input" v-model="item.passwordHint" required :readonly="mode === 'view'">
                                </div>
                                <small class="text-muted">Ejemplo: nombre de mi primer perro</small>
                            </fieldset>

                            <fieldset class="form-group row">
                                <label class="col-sm-2">Estado:</label>
                                <div class="input-group col-sm-10">                                    
                                    <label class="switch switch-label switch-info">
                                        <input 
                                            type="checkbox" 
                                            class="switch-input" 
                                            checked 
                                            v-model="item.enabled" 
                                            :disabled="mode === 'view'">
                                        <span class="switch-slider" data-checked="✓" data-unchecked="✕"></span>                                        
                                    </label>
                                    <small style="padding-top: 5px">&nbsp;&nbsp;{{enabled}}</small>
                                </div>                                
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Rol(es) del usuario:</label>
                                <div class="input-group">
                                    <multiselect
                                        v-model="item.authorities"
                                        :options="displayAuthorities"
                                        label="name"
                                        track-by="name"
                                        :multiple="true"
                                        :close-on-select="true"
                                        :allow-empty="false"
                                        :searchable="true"
                                        @input="selectedAuthoritiesChanged"
                                        :disabled="mode === 'view'">
                                    </multiselect>
                                </div>
                                <small class="text-muted">Seleccione los roles para este usuario</small>
                            </fieldset>

                            <div class="text-right">
                                <button type="submit" class="btn btn-primary btn-sm" v-if="($usersPerimeter.isAllowed('create') || $usersPerimeter.isAllowed('update')) && mode !== 'view'"><span class="fa fa-save"></span> Guardar</button>
                                <button type="button" class="btn btn-primary btn-sm" v-if="$usersPerimeter.isAllowed('update') && mode === 'view'" @click="mode = 'edit'"><span class="fa fa-edit"></span> Editar</button>
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
                    <b-card title="Permisos" sub-title="Todos los permisos del usuario">
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
                                                        :disabled="privilege.disabled || mode === 'view'">
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
                            <button type="submit" class="btn btn-primary btn-sm" v-if="($usersPerimeter.isAllowed('create') || $usersPerimeter.isAllowed('update')) && mode !== 'view'"><span class="fa fa-save"></span> Guardar</button>
                            <button type="button" class="btn btn-primary btn-sm" v-if="$usersPerimeter.isAllowed('update') && mode === 'view'" @click="mode = 'edit'"><span class="fa fa-edit"></span> Editar</button>
                            <button type="button" class="btn btn-danger btn-sm" @click="cancel"><span class="fa fa-close"></span>&nbsp;Cancelar</button>
                        </div>                        
                    </b-card>
                </b-card-group>
            </b-col>
        </b-row>
    </b-form>
    <br/>        
    <b-modal 
        centered
        v-model="modalShow"
        ref="modalPassword" 
        header-bg-variant="info"
        header-text-variant="light"
        footer-bg-variant="dark"
        footer-text-variant="light"
        :title="modalPassword.title">
        <b-form>                
            <b-input-group class="mb-3" v-if="modalPassword.mode !== 'create'">
                <b-input-group-prepend>
                    <b-input-group-text><i class="fa fa-asterisk"></i></b-input-group-text>
                </b-input-group-prepend>
                <b-form-input type="password" class="form-control" placeholder="Contraseña actual" v-model="modalPassword.currentPassword"/>
            </b-input-group>
            <b-input-group class="mb-3">
                <b-input-group-prepend>
                    <b-input-group-text><i class="fa fa-asterisk"></i></b-input-group-text>
                </b-input-group-prepend>
                <b-form-input type="password" class="form-control" placeholder="Nueva contraseña" v-model="modalPassword.newPassword" v-on:input="onPasswordChange"/>
            </b-input-group>
            <b-input-group class="mb-4">
                <b-input-group-prepend>
                    <b-input-group-text><i class="fa fa-asterisk"></i></b-input-group-text>
                </b-input-group-prepend>
                <b-form-input type="password" class="form-control" placeholder="Confirmar nueva contraseña" v-model="modalPassword.confirmPassword" v-on:input="onPasswordChange"/>
            </b-input-group>                
        </b-form>            
        <div slot="modal-footer" class="w-100 text-right">
            <b-button-group>
                <b-button class="float-right" variant="primary" @click="modalOk">Ok</b-button>
                <b-button class="float-right" variant="danger" @click="modalClose">Cancel</b-button>
            </b-button-group>
        </div>
    </b-modal>
</div>
</template>

<script>
    import Vue from 'vue';
    import Multiselect from 'vue-multiselect';
    import moment from 'moment';
    import toastr from 'toastr';
    import 'toastr/toastr.js';
    import 'toastr/toastr.scss';

    import UsersPerimeter from '@/perimeter/UsersPerimeter';

    import {DATETIME_FORMAT} from '@/components/global';

    export default {
        name: 'UsuariosDetalle',
        middleware: 'authenticated',
        components: {
            Multiselect
        },
        perimeters: [
            UsersPerimeter
        ],
        data() {
            return {
                mode: 'create', // edit | view | resetPassword
                title: 'Untitled',
                item: {},
                displayAuthorities: [],
                displayPrivilegeCategories: [],
                userPicture: null,
                internalDataFields: [{key: 'attribute', label: 'Atributo'}, {key: 'value', label: 'Valor'}],
                modalPassword: {
                    title: '',
                    mode: 'create',
                    message: '',
                    currentPassword: '',
                    newPassword: '',
                    confirmPassword: ''
                },
                modalShow: false
            }
        },
        async created() {
            this.mode = this.$route.params.mode;
            this.title = this.$route.params.title;

            if (this.$route.params.username === undefined) {
                this.item = {
                    enabled: true,
                    authorities: [],
                    privileges: []
                }
            } else {
                // Get user information
                try {
                    const userResponse = await this.$axios.get('/user/getUserByUsername', {
                        params: {
                            username: this.$route.params.username
                        }
                    });

                    this.item = userResponse.data;
                } catch (error) {
                    console.error('FATAL: ' + error);
                }

                if (this.item.createdDate) {
                    this.item.createdDate = moment(this.item.createdDate).format(DATETIME_FORMAT);
                }

                if (this.item.lastModifiedDate) {
                    this.item.lastModifiedDate = moment(this.item.lastModifiedDate).format(DATETIME_FORMAT);
                } else {
                    this.item.lastModifiedDate = null;
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
            // Get all authorities            
            try {
                const allAuthoritiesResponse = await this.$axios.get('/authority/getAllAuthorities');

                this.displayAuthorities = allAuthoritiesResponse.data;
            } catch (error) {
                console.error('FATAL: ' + error);
            }

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

                // Set disabled privileges
                for (let i = 0; i < buildDisplayPrivilegeCategories.length; i++) {
                    for (let j = 0; j < buildDisplayPrivilegeCategories[i].privileges.length; j++) {
                        for (let k = 0; k < this.item.authorities.length; k++) {
                            for (let l = 0; l < this.item.authorities[k].privileges.length; l++) {
                                if (this.item.authorities[k].privileges[l].id === buildDisplayPrivilegeCategories[i].privileges[j].id) {
                                    buildDisplayPrivilegeCategories[i].privileges[j].disabled = true;
                                }
                            }
                        }
                    }
                }
            }

            this.displayPrivilegeCategories = buildDisplayPrivilegeCategories;
        },
        computed: {
            createdBy: function () {
                if (this.item.createdBy === undefined || this.item.createdBy === null) {
                    return '';
                }

                //return this.item.createdBy.username;
                return this.item.createdBy.firstName + ' ' + this.item.createdBy.lastName + ' [' + this.item.createdBy.username + ']';
            },
            lastModifiedBy: function () {
                if (this.item.lastModifiedBy === undefined || this.item.lastModifiedBy === null) {
                    return '';
                }

                //return this.item.lastModifiedBy.username;
                return this.item.lastModifiedBy.firstName + ' ' + this.item.lastModifiedBy.lastName + ' [' + this.item.lastModifiedBy.username + ']';
            },
            enabled: function () {
                return this.item.enabled ? 'Activo' : 'Inactivo';
            },
            defaultSystemUser: function () {
                return this.item.defaultSystemUser ? 'Si' : 'No';
            },
            removable: function () {
                return this.item.removable ? 'Si' : 'No';
            },
            internalData: function () {
                const buildInternalData = [];

                if (this.item.id) {
                    buildInternalData.push({attribute: 'Identificador único', value: this.item.id});
                }

                if (this.item.createdDate) {
                    buildInternalData.push({attribute: 'Fecha de creación', value: this.item.createdDate});
                }

                if (this.item.createdBy) {
                    buildInternalData.push({attribute: 'Creado por', value: this.createdBy});
                }

                if (this.item.lastModifiedDate) {
                    buildInternalData.push({attribute: 'Última modificación', value: this.item.createdDate});
                }

                if (this.item.lastModifiedBy) {
                    buildInternalData.push({attribute: 'Modificado por', value: this.lastModifiedBy});
                }

                buildInternalData.push({attribute: 'Estado', value: this.enabled});
                buildInternalData.push({attribute: 'Usuario por defecto', value: this.defaultSystemUser});
                buildInternalData.push({attribute: 'Borrable', value: this.removable});

                return buildInternalData;
            }/*,            
             pictureBytes: function() {
             var fileReader = new FileReader();
             fileReader.readAsArrayBuffer(this.userPicture);
             fileReader.onload = function() {
             return 'data:image/png;base64,' + new Int8Array(fileReader.result);
             }
             //return 'data:image/png;base64,' + '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';
             }*/
        },
        methods: {
            async selectedAuthoritiesChanged(selectedAuthorities) {
                try {
                    let i; // used to iterate on selected authorities
                    let j; // used to iterate on privileges by authority
                    let k; // used to iterate on categories
                    let l; // used to iterate on privileges by category                    

                    // reset old data
                    for (i = 0; i < this.displayPrivilegeCategories.length; i++) {
                        for (j = 0; j < this.displayPrivilegeCategories[i].privileges.length; j++) {
                            this.displayPrivilegeCategories[i].privileges[j].selected = false;
                            this.displayPrivilegeCategories[i].privileges[j].disabled = false;
                        }
                    }

                    let buildDisplayPrivilegeCategories = this.displayPrivilegeCategories;
                    this.displayPrivilegeCategories = [];

                    for (i = 0; i < selectedAuthorities.length; i++) {
                        const authorityResponse = await this.$axios.get('/authority/getAuthorityByName', {
                            params: {
                                authorityName: selectedAuthorities[i].name
                            }
                        });

                        for (j = 0; j < authorityResponse.data.privileges.length; j++) {
                            for (k = 0; k < buildDisplayPrivilegeCategories.length; k++) {
                                for (l = 0; l < buildDisplayPrivilegeCategories[k].privileges.length; l++) {
                                    if (authorityResponse.data.privileges[j].id === buildDisplayPrivilegeCategories[k].privileges[l].id) {
                                        buildDisplayPrivilegeCategories[k].privileges[l].selected = true;
                                        buildDisplayPrivilegeCategories[k].privileges[l].disabled = true;
                                    }
                                }
                            }
                        }
                    }

                    this.displayPrivilegeCategories = buildDisplayPrivilegeCategories;
                } catch (error) {
                    console.error('FATAL: ' + error);
                }

                console.log(JSON.stringify(this.displayPrivilegeCategories));
            },
            async save() {
                //console.log('Save ' + JSON.stringify(this.item));                

                this.item.createdDate = null;
                this.item.createdBy = null;
                this.item.lastModifiedDate = null;
                this.item.lastModifiedBy = null;

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
                        response = await this.$axios.post('/user/createUser', this.item);
                    } else {
                        response = await this.$axios.put('/user/updateUser', this.item);
                    }

                    this.item = response.data;

                    toastr.remove();
                    toastr.success('El usuario ' + this.item.username + ' ha sido ' + (this.mode === 'create' ? 'creado' : 'actualizado') + ' satisfactoriamente.', 'Usuario ' + (this.mode === 'create' ? 'creado' : 'actualizado'));

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
            },
            showPasswordModal() {
                this.modalPassword.title = 'Contraseña de usuario';
                this.modalPassword.mode = this.mode;
                this.$refs.modalPassword.show();
            },
            onPasswordChange() {
                if (this.modalPassword.newPassword.trim() !== this.modalPassword.confirmPassword.trim()) {
                    this.modalPassword.message = 'Las contraseñas no coinciden.';
                    toastr.error(this.modalPassword.message, 'ERROR');
                } else {
                    this.modalPassword.message = null;
                }
            },
            modalClose() {
                toastr.remove();
                this.modalShow = !this.modalShow;
                this.modalPassword.message = null;
                this.modalPassword.currentPassword = '';
                this.modalPassword.newPassword = '';
                this.modalPassword.confirmPassword = '';
            },
            modalOk() {                
                if (this.mode === 'create' || this.mode === 'resetPassword') {
                    if (this.modalPassword.newPassword.trim() === '' || this.modalPassword.confirmPassword.trim() === '') {
                        this.modalPassword.message = 'Debe especificar una contraseña válida.';                        
                        toastr.error(this.modalPassword.message, 'ERROR');
                    } else if (this.modalPassword.newPassword.trim() !== this.modalPassword.confirmPassword.trim()) {
                        this.modalPassword.message = 'Las contraseñas no coinciden.';                        
                        toastr.error(this.modalPassword.message, 'ERROR');
                    } else if (this.modalPassword.newPassword.trim().length < 8) {
                        this.modalPassword.message = 'La contraseña debe tener 8 caracteres como mínimo.';
                        toastr.remove();
                        toastr.error(this.modalPassword.message, 'ERROR');
                    } else {
                        this.item.password = this.modalPassword.newPassword.trim();

                        this.modalShow = !this.modalShow;
                        this.modalPassword.message = null;
                        this.modalPassword.currentPassword = '';
                        this.modalPassword.newPassword = '';
                        this.modalPassword.confirmPassword = '';
                        toastr.remove();
                        toastr.success('La contraseña especificada es válida.');
                    }
                } else {
                    this.validateCurrentCredentials();
                }
            },
            async validateCurrentCredentials() {
                if (this.modalPassword.currentPassword.trim() === '') {
                    this.modalPassword.message = 'Debe especificar la contraseña actual.';
                    toastr.error(this.modalPassword.message, 'ERROR');
                    return;
                }

                let response = null;

                try {
                    response = await this.$axios.post('/auth', {
                        username: this.item.username,
                        password: this.modalPassword.currentPassword
                    });

                    console.log('Response: ' + JSON.stringify(response.data.data) + ' for credentials ' + JSON.stringify({
                        username: this.item.username,
                        password: this.modalPassword.currentPassword
                    }));

                    toastr.remove();
                    
                    if (response.data.data.message === 'Bad credentials') {
                        this.modalPassword.message = 'La contraseña actual es incorrecta.';
                        toastr.error(this.modalPassword.message, 'ERROR');
                    } else if (response.data.data.type === 'bearer' && response.data.data.token !== '') {
                        if (this.modalPassword.currentPassword.trim() === '') {
                            this.modalPassword.message = 'Debe especificar la contraseña actual.';                            
                            toastr.error(this.modalPassword.message, 'ERROR');
                        } else if (this.modalPassword.newPassword.trim() === '' || this.modalPassword.confirmPassword.trim() === '') {
                            this.modalPassword.message = 'La nueva contraseña  es inválida.';
                            toastr.error(this.modalPassword.message, 'ERROR');
                        } else if (this.modalPassword.newPassword.trim() !== this.modalPassword.confirmPassword.trim()) {
                            this.modalPassword.message = 'Las contraseñas no coinciden.';
                            toastr.error(this.modalPassword.message, 'ERROR');
                        } else {
                            this.item.password = this.modalPassword.newPassword.trim();

                            this.modalShow = !this.modalShow;
                            this.modalPassword.message = null;
                            this.modalPassword.currentPassword = '';
                            this.modalPassword.newPassword = '';
                            this.modalPassword.confirmPassword = '';    
                            toastr.remove();
                            toastr.success('La contraseña especificada es válida.');
                        }
                    }
                } catch (error) {
                    console.log('FATAL: ' + JSON.stringify(error));
                }
            }
        }
    }
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>

<style>
    .custom-file-input:lang(en) ~ .custom-file-label::after {
        content: 'Buscar';
    }
</style>