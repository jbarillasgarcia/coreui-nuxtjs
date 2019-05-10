import BasePerimeter from '../BasePerimeter';

export default new BasePerimeter({
    name: 'ReportsDataRewards',

    purpose: 'accessReportsDataRewardsPerimeter',

    debug: false,

    can: {
        access() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Access', this.child.state.auth.user.privileges.includes('reports.datarewards.access'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('reports.datarewards.access');
        }
    }
});