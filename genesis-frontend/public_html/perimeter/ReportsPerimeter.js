import BasePerimeter from './BasePerimeter';

export default new BasePerimeter({
    name: 'Reports',

    purpose: 'reportsPerimeter',

    debug: false,

    can: {
        readDataRewards() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Read', this.child.state.auth.user.privileges.includes('reports.datarewards.read'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('reports.datarewards.read');
        },

        exportDataRewards() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Export', this.child.state.auth.user.privileges.includes('reports.datarewards.export'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('reports.datarewards.export');
        }
    }
});