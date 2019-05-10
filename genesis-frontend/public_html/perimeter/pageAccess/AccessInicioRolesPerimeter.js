import BasePerimeter from '../BasePerimeter';

export default new BasePerimeter({
    name: 'InicioRolesPerimeter',

    purpose: 'accessInicioRolesDetallePerimeter',

    debug: false,

    can: {
        access() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Access', this.child.state.auth.user.privileges.includes('roles.access'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('roles.access');
        }
    }
});