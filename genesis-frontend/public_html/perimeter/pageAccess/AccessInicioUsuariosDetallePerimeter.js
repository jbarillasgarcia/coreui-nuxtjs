import BasePerimeter from '../BasePerimeter';

export default new BasePerimeter({
    name: 'InicioUsuariosPerimeter',

    purpose: 'accessInicioUsuariosPerimeter',

    debug: false,

    can: {
        access() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log(
                        'Access',
                        this.child.state.auth.user.privileges.includes('users.create') ||
                        this.child.state.auth.user.privileges.includes('users.read') ||
                        this.child.state.auth.user.privileges.includes('users.update')
                        )

            return this.child.state.auth.loggedIn && (
                    this.child.state.auth.user.privileges.includes('users.create') ||
                    this.child.state.auth.user.privileges.includes('users.read') ||
                    this.child.state.auth.user.privileges.includes('users.update')
                    );
        }
    }
});