<template>
    <div class="app flex-row align-items-center">
        <div class="container">
            <b-row class="justify-content-center">
                <b-col md="6" sm="8">
                    <b-form @submit.prevent="getHint">
                        <b-card no-body class="mx-4">                        
                            <b-card-body class="p-4">
                                <b-form>
                                    <h1>Recuperar contrase&ntilde;a</h1>
                                    <p class="text-muted">Ingrese su cuenta de usuario</p>
                                    <b-input-group class="mb-3">
                                        <b-input-group-prepend>
                                            <b-input-group-text><i class="icon-user"></i></b-input-group-text>
                                        </b-input-group-prepend>
                                        <b-form-input type="text" class="form-control" placeholder="Usuario" autocomplete="username" v-model="username" required />
                                    </b-input-group>

                                    <b-input-group class="mb-3">
                                        <b-input-group-prepend>
                                            <b-input-group-text><i class="icon-question"></i></b-input-group-text>
                                        </b-input-group-prepend>
                                        <b-form-input type="text" class="form-control" placeholder="Indicio de contraseña" v-model="passwordHint" readonly />
                                    </b-input-group>                
                                </b-form>
                            </b-card-body>
                            <b-card-footer class="p-4">
                                <b-row>
                                    <b-col cols="6">
                                        <b-button block class="btn btn-facebook" href="/Login"><span>Volver</span></b-button>
                                    </b-col>
                                    <b-col cols="6">
                                        <b-button block class="btn btn-twitter" type="submit"><span>Buscar indicio</span></b-button>
                                    </b-col>
                                </b-row>
                            </b-card-footer>
                        </b-card>
                    </b-form>
                </b-col>
            </b-row>
        </div>
    </div>
</template>

<script>
    import toastr from 'toastr';
    import 'toastr/toastr.js';
    import 'toastr/toastr.scss';

    export default {
        name: 'PasswordRecovery',
        layout: 'login',
        middleware: 'unauthenticated',
        created() {
            toastr.options.closeButton = true;
            toastr.options.newestOnTop = false;
            toastr.options.timeOut = 5000; // How long the toast will display without user interaction. If 0, the toastr will persist until selected.
            toastr.options.extendedTimeOut = 5000; // How long the toast will display after a user hovers over it. If 0, the toastr will persist until selected.
            toastr.options.progressBar = true;
            toastr.options.preventDuplicates = true;
        },
        data() {
            return {
                username: '',
                passwordHint: '',
                enabledControls: true
            }
        },
        methods: {
            async getHint() {
                this.enabledControls = false;

                try {
                    let response = await this.$axios.get('/passwordRecovery', {
                        params: {
                            username: this.username
                        }
                    });
                    
                    this.passwordHint = response.data;
                } catch (error) {
                    let message = error.response.data.message.split('|');

                    toastr.remove();
                    toastr.error(message[1], message[0]);
                } finally {
                    this.enabledControls = true;
                }
            }
        }
    }
</script>
