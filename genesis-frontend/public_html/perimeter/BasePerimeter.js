import { Perimeter } from 'vue-kindergarten';

export default class BasePerimeter extends Perimeter {

    log(action, isAllowed) {
        //console.log("Store = " + JSON.stringify(this.child.state));
        console.log(action + ' ' + this.name + ': ' + (isAllowed ? 'Allowed' : 'Denied'));
    }    

}