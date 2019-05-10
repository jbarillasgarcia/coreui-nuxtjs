import BasePerimeter from '../BasePerimeter';

export default new BasePerimeter({
    name: 'Index',

    purpose: 'accessIndexPerimeter',

    debug: false,

    can: {
        access() {
            // NEVER CHANGE THIS TO FALSE OR YOU WILL CAUSE AN INFINITE CYCLE!!!
            return true;
        }
    }
});