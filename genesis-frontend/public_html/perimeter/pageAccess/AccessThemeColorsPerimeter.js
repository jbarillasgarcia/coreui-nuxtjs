import BasePerimeter from '../BasePerimeter';

export default new BasePerimeter({
    name: 'Colors',

    purpose: 'accessThemeColorsPerimeter',

    debug: false,

    can: {
        access() {
            if (this.debug && this.child.state.auth.loggedIn)
                this.log('Access', this.child.state.auth.user.privileges.includes('theme.colors.access'))

            return this.child.state.auth.loggedIn && this.child.state.auth.user.privileges.includes('theme.colors.access');
        }
    }
});