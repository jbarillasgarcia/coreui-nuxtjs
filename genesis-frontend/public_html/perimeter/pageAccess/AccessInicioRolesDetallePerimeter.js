import BasePerimeter from '../BasePerimeter';

export default new BasePerimeter({
    name: 'InicioRolessPerimeter',

    purpose: 'accessInicioRolesPerimeter',

    debug: false,

    can: {
        access() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log(
                        'Access',
                        this.child.state.auth.user.privileges.includes('roles.create') ||
                        this.child.state.auth.user.privileges.includes('roles.read') ||
                        this.child.state.auth.user.privileges.includes('roles.update')
                        )

            return this.child.state.auth.loggedIn && (
                    this.child.state.auth.user.privileges.includes('roles.create') ||
                    this.child.state.auth.user.privileges.includes('roles.read') ||
                    this.child.state.auth.user.privileges.includes('roles.update')
                    );
        }
    }
});