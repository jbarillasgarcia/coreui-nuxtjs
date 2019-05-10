import BasePerimeter from './BasePerimeter';

export default new BasePerimeter({
    name: 'DashboardDemo',

    purpose: 'dashboardDemoPerimeter',

    debug: false,

    can: {
        doSomething() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Access', this.child.state.auth.user.privileges.includes('something.access'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('something.access');
        }
    }
});