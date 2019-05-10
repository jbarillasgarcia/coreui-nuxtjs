<template>
    <div class="app flex-row align-items-center">
        <div class="container">
            <b-row class="justify-content-center">
                <b-col md="10">
                    <b-card-group>
                        <b-card no-body class="p-4 bg-primary text-white">
                            <b-card-body>
                                <b-form method="post" @submit.prevent="login">
                                    <h1>Login</h1>
                                    <p>Ingrese a su cuenta</p>
                                    <b-alert show variant="danger" v-if="message">{{message}}</b-alert>
                                    <b-input-group class="mb-3">
                                        <b-input-group-prepend><b-input-group-text><i class="icon-user"></i></b-input-group-text></b-input-group-prepend>
                                        <b-form-input type="text" class="form-control" placeholder="Usuario" autocomplete="username email" v-model="username" />
                                    </b-input-group>
                                    <b-input-group class="mb-4">
                                        <b-input-group-prepend><b-input-group-text><i class="icon-lock"></i></b-input-group-text></b-input-group-prepend>
                                        <b-form-input type="password" class="form-control" placeholder="Contraseña" autocomplete="current-password" v-model="password" />
                                    </b-input-group>
                                    <b-row>
                                        <b-col cols="6">
                                            <b-button type="submit" variant="secondary" class="px-4">Entrar</b-button>
                                        </b-col>
                                        <b-col cols="6" class="text-right">
                                            <!--<b-button variant="link" class="px-0">&iquest;Olvid&oacute; su contrase&ntilde;a&quest;</b-button>-->
                                            <nuxt-link to="/PasswordRecovery"><span class="text-white">&iquest;Olvid&oacute; su contrase&ntilde;a&quest;</span></nuxt-link>
                                        </b-col>
                                    </b-row>
                                </b-form>
                            </b-card-body>
                        </b-card>
                        <b-card no-body class="bg-white py-5 d-md-down-none" style="width:44%">
                            <b-card-body class="text-center">
                                <div>
                                    <img class="navbar-brand-full" src="img/brand/wau.png" height="192" alt="Wau">
                                    <!--<h2>T&iacute;tulo</h2>
                                    <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>-->
                                    <!--<b-button variant="primary" class="active mt-3">Register Now!</b-button>-->
                                </div>
                            </b-card-body>
                        </b-card>
                    </b-card-group>
                </b-col>
            </b-row>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Login',
        layout: 'login',
        middleware: 'unauthenticated',
        data() {
            return {
                username: '',
                password: '',
                message: null,
                error: null
            }
        },
        mounted() {
            this.message = this.$route.params.message;            
        },
        errorCaptured() {
            console.log('some error found');
        },
        methods: {
            async login() {
                try {
                    await this.$auth.loginWith('local', {
                        data: {
                            username: this.username,
                            password: this.password
                        }
                    }).then(function () {
                        console.log("Logged in!!!");                        
                    });

                    this.$router.push('/Dashboard');
                } catch (error) {
                    //console.log("Error found " + JSON.stringify(error));
                    
                    if (error.response.data.message === 'InsufficientAuthenticationException - Full authentication is required to access this resource') {
                        this.message = 'Debe especificar un usuario y contraseña válidos.';
                    } else {
                        this.message = 'Error interno. Por favor consulte con su administrador.';
                    }
                    
                    console.log('FATAL: ' + error.response.data.message);
                    this.error = error.response.data.status + ":" + error.response.data.error
                }
            }
        }
    }
</script>
