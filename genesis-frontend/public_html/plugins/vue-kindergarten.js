import Vue from 'vue';
import VueKindergarten from 'vue-kindergarten';
import child from '@/child';

Vue.use(VueKindergarten, {
    child: (store) => {
        /*if (store !== null)
            console.log('store: ' + JSON.stringify(store.state));*/
        
        /*var seen = [];

        console.log('Store: ' + JSON.stringify(store, function(key, val) {
            if (val != null && typeof val == "object") {
                 if (seen.indexOf(val) >= 0) {
                     return;
                 }
                 seen.push(val);
             }
             return val;
         }));*/

        return store;
    }
});
