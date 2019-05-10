import { HeadGoverness } from 'vue-kindergarten';

export default class RouteGoverness extends HeadGoverness {
    guard(action, { redirect }) {
        //console.log('Guarding action "' + action + '"');
        
        if (this.isNotAllowed(action)) {
            //console.log('User is not allowed here!!!');
            redirect('/');
        } else {
            //console.log('User is allowed here.');            
        }
    }
}