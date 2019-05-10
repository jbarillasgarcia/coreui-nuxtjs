import Vue from 'vue'
import Router from 'vue-router'
import { interopDefault } from './utils'

const _7c5da064 = () => interopDefault(import('../pages/Dashboard/index.vue' /* webpackChunkName: "pages/Dashboard/index" */))
const _7b9d76e4 = () => interopDefault(import('../pages/DashboardDemo.vue' /* webpackChunkName: "pages/DashboardDemo" */))
const _2140d760 = () => interopDefault(import('../pages/Login.vue' /* webpackChunkName: "pages/Login" */))
const _40a2baa9 = () => interopDefault(import('../pages/PasswordRecovery.vue' /* webpackChunkName: "pages/PasswordRecovery" */))
const _0e3b564f = () => interopDefault(import('../pages/Inicio/Roles/index.vue' /* webpackChunkName: "pages/Inicio/Roles/index" */))
const _3b56dfc9 = () => interopDefault(import('../pages/Inicio/Usuarios/index.vue' /* webpackChunkName: "pages/Inicio/Usuarios/index" */))
const _bf5ce59a = () => interopDefault(import('../pages/tables/DataTable.vue' /* webpackChunkName: "pages/tables/DataTable" */))
const _11711418 = () => interopDefault(import('../pages/tables/SimpleTables.vue' /* webpackChunkName: "pages/tables/SimpleTables" */))
const _f9566d62 = () => interopDefault(import('../pages/theme/Colors.vue' /* webpackChunkName: "pages/theme/Colors" */))
const _ec66e3e4 = () => interopDefault(import('../pages/theme/Typography.vue' /* webpackChunkName: "pages/theme/Typography" */))
const _609d2f91 = () => interopDefault(import('../pages/Inicio/Reportes/DataRewards/index.vue' /* webpackChunkName: "pages/Inicio/Reportes/DataRewards/index" */))
const _385ed9d8 = () => interopDefault(import('../pages/Inicio/Roles/Detalle.vue' /* webpackChunkName: "pages/Inicio/Roles/Detalle" */))
const _d764ccb6 = () => interopDefault(import('../pages/Inicio/Roles/test.vue' /* webpackChunkName: "pages/Inicio/Roles/test" */))
const _382fa60e = () => interopDefault(import('../pages/Inicio/Usuarios/Detalle.vue' /* webpackChunkName: "pages/Inicio/Usuarios/Detalle" */))
const _eeb9d812 = () => interopDefault(import('../pages/tables/_data.js' /* webpackChunkName: "pages/tables/_data" */))
const _3fb1d72e = () => interopDefault(import('../pages/index.vue' /* webpackChunkName: "pages/index" */))

Vue.use(Router)

if (process.client) {
  window.history.scrollRestoration = 'manual'
}
const scrollBehavior = function (to, from, savedPosition) {
  // if the returned position is falsy or an empty object,
  // will retain current scroll position.
  let position = false

  // if no children detected
  if (to.matched.length < 2) {
    // scroll to the top of the page
    position = { x: 0, y: 0 }
  } else if (to.matched.some(r => r.components.default.options.scrollToTop)) {
    // if one of the children has scrollToTop option set to true
    position = { x: 0, y: 0 }
  }

  // savedPosition is only available for popstate navigations (back button)
  if (savedPosition) {
    position = savedPosition
  }

  return new Promise((resolve) => {
    // wait for the out transition to complete (if necessary)
    window.$nuxt.$once('triggerScroll', () => {
      // coords will be used if no selector is provided,
      // or if the selector didn't match any element.
      if (to.hash) {
        let hash = to.hash
        // CSS.escape() is not supported with IE and Edge.
        if (typeof window.CSS !== 'undefined' && typeof window.CSS.escape !== 'undefined') {
          hash = '#' + window.CSS.escape(hash.substr(1))
        }
        try {
          if (document.querySelector(hash)) {
            // scroll to anchor by returning the selector
            position = { selector: hash }
          }
        } catch (e) {
          console.warn('Failed to save scroll position. Please add CSS.escape() polyfill (https://github.com/mathiasbynens/CSS.escape).')
        }
      }
      resolve(position)
    })
  })
}

export function createRouter() {
  return new Router({
    mode: 'history',
    base: '/',
    linkActiveClass: 'nuxt-link-active',
    linkExactActiveClass: 'nuxt-link-exact-active',
    scrollBehavior,

    routes: [{
      path: "/Dashboard",
      component: _7c5da064,
      name: "Dashboard"
    }, {
      path: "/DashboardDemo",
      component: _7b9d76e4,
      name: "DashboardDemo"
    }, {
      path: "/Login",
      component: _2140d760,
      name: "Login"
    }, {
      path: "/PasswordRecovery",
      component: _40a2baa9,
      name: "PasswordRecovery"
    }, {
      path: "/Inicio/Roles",
      component: _0e3b564f,
      name: "Inicio-Roles"
    }, {
      path: "/Inicio/Usuarios",
      component: _3b56dfc9,
      name: "Inicio-Usuarios"
    }, {
      path: "/tables/DataTable",
      component: _bf5ce59a,
      name: "tables-DataTable"
    }, {
      path: "/tables/SimpleTables",
      component: _11711418,
      name: "tables-SimpleTables"
    }, {
      path: "/theme/Colors",
      component: _f9566d62,
      name: "theme-Colors"
    }, {
      path: "/theme/Typography",
      component: _ec66e3e4,
      name: "theme-Typography"
    }, {
      path: "/Inicio/Reportes/DataRewards",
      component: _609d2f91,
      name: "Inicio-Reportes-DataRewards"
    }, {
      path: "/Inicio/Roles/Detalle",
      component: _385ed9d8,
      name: "Inicio-Roles-Detalle"
    }, {
      path: "/Inicio/Roles/test",
      component: _d764ccb6,
      name: "Inicio-Roles-test"
    }, {
      path: "/Inicio/Usuarios/Detalle",
      component: _382fa60e,
      name: "Inicio-Usuarios-Detalle"
    }, {
      path: "/tables/:data?",
      component: _eeb9d812,
      name: "tables-data"
    }, {
      path: "/",
      component: _3fb1d72e,
      name: "index"
    }],

    fallback: false
  })
}
