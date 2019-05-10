import BasePerimeter from '../BasePerimeter';

export default new BasePerimeter({
    name: 'InicioUsuariosPerimeter',

    purpose: 'accessInicioUsuariosDetallePerimeter',

    debug: false,

    can: {
        access() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Access', this.child.state.auth.user.privileges.includes('users.access'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('users.access');
        }
    }
});