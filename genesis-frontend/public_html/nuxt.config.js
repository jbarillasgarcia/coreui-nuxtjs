const pkg = require('./package')

module.exports = {
    mode: 'spa',

    /*
     ** Headers of the page
     */
    head: {
        title: pkg.name,
        meta: [
            {charset: 'utf-8'},
            {name: 'viewport', content: 'width=device-width, initial-scale=1'},
            {hid: 'description', name: 'description', content: pkg.description}
        ],
        link: [
            {rel: 'icon', type: 'image/png', href: '/icon.png'}
        ]
    },

    /*
     ** Customize the progress-bar color
     */
    loading: {color: '#fff'},

    /*
     ** Global CSS
     */
    css: [
    ],

    /*
     ** Plugins to load before mounting the App
     */
    plugins: [
        '~/plugins/vue-kindergarten'
    ],

    /*
     ** Nuxt.js modules
     */
    modules: [
        'bootstrap-vue/nuxt',
        '@nuxtjs/axios',
        '@nuxtjs/auth'
    ],

    /*
     ** Axios module configuration
     */
    axios: {
        baseURL: 'http://192.168.64.150:8762',
        retry: {
            retries: 1
        },
        debug: true/*,
        errorHandler(error, { store, redirect }) {
            if (error.response.status === 401) {
                console.log('expired token, going after /refresh')
                store.dispatch('auth/logout').then(() => {
                    redirect('/users/login');
                });
            }
        }*/
    },

    /*
     ** Build configuration
     */
    build: {
        /*
         ** You can extend webpack config here
         */
        extend(config, ctx) {

        }
    },

    /*
     ** Auth module configuration 
     */
    auth: {
        strategies: {
            local: {
                endpoints: {
                    login: {url: 'auth', method: 'post', propertyName: 'data.token'},
                    user: {url: 'me', method: 'get', propertyName: 'data'},
                    logout: false
                }
            }
        },
        plugins: [
            '~/plugins/auth',
            '~/plugins/axios'
        ]
    },

    /*
     ** Middleware configuration for router 
     */
    router: {
        middleware: 'vue-kindergarten',
        routeNameSplitter: '/'
    }
}
