import BasePerimeter from '../BasePerimeter';

export default new BasePerimeter({
    name: 'Typography',

    purpose: 'accessThemeTypographyPerimeter',

    debug: false,

    can: {
        access() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Access', this.child.state.auth.user.privileges.includes('theme.typography.access'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('theme.typography.access');
        }
    }
});