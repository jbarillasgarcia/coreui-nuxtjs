import BasePerimeter from './BasePerimeter';

export default new BasePerimeter({
    name: 'Roles',

    purpose: 'rolesPerimeter',

    debug: false,

    can: {
        create() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Create', this.child.state.auth.user.privileges.includes('users.create'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('users.create');
        },

        read() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Read', this.child.state.auth.user.privileges.includes('roles.read'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('roles.read');
        },

        update() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Update', this.child.state.auth.user.privileges.includes('roles.update'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('roles.update');
        },

        remove() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Delete', this.child.state.auth.user.privileges.includes('roles.delete'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('roles.delete');
        },

        download() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Export', this.child.state.auth.user.privileges.includes('roles.export'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('roles.export');
        },
        
        debug() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Export', this.child.state.auth.user.privileges.includes('roles.debug'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('roles.debug');
        }
    }
});