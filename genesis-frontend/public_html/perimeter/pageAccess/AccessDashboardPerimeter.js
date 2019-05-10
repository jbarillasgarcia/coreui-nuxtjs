import BasePerimeter from '../BasePerimeter';

export default new BasePerimeter({
    name: 'Dashboard',

    purpose: 'accessDashboardPerimeter',

    debug: false,

    can: {
        access() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Access', this.child.state.auth.user.privileges.includes('dashboard.access'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('dashboard.access');
        }
    }
});