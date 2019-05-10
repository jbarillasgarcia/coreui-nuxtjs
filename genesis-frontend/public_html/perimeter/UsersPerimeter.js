import BasePerimeter from './BasePerimeter';

export default new BasePerimeter({
    name: 'Users',

    purpose: 'usersPerimeter',

    debug: false,

    can: {
        create() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Create', this.child.state.auth.user.privileges.includes('users.create'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('users.create');
        },

        read() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Read', this.child.state.auth.user.privileges.includes('users.read'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('users.read');
        },

        update() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Update', this.child.state.auth.user.privileges.includes('users.update'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('users.update');
        },

        remove() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Delete', this.child.state.auth.user.privileges.includes('users.delete'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('users.delete');
        },

        download() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Export', this.child.state.auth.user.privileges.includes('users.export'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('users.export');
        },
        
        debug() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Export', this.child.state.auth.user.privileges.includes('users.debug'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('users.debug');
        }
    }
});