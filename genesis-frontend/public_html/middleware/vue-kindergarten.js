import { createSandbox } from 'vue-kindergarten';
import RouteGoverness from '@/governess/RouteGoverness';
import * as perimeters from '@/perimeter';
import child from '@/child';

export default (context) => {
    const {route, error, redirect, store, isServer} = context;

    route.matched.some((routeRecord) => {
        //console.log('Route record: ' + JSON.stringify(routeRecord));

        var routeParts = routeRecord.name.split(" ");

        //var perimeterName = routeParts[routeParts.length - 1][0].toUpperCase() + routeParts[routeParts.length - 1].substr(1);
        var perimeterName = routeRecord.name.replace(/-|\/| /g, '');
        perimeterName = perimeterName[0].toUpperCase() + perimeterName.substr(1);

        //console.log('Searching for perimeter: Access' + perimeterName + 'Perimeter');
        //console.log('Available perimeters: ' + JSON.stringify(perimeters));

        const perimeter = perimeters['Access' + perimeterName + 'Perimeter'];
        const Governess = RouteGoverness;

        /*var seen = [];
         
         console.log('Context: ' + JSON.stringify(context, function(key, val) {
         if (val != null && typeof val == "object") {
         if (seen.indexOf(val) >= 0) {
         return;
         }
         seen.push(val);
         }
         return val;
         }));*/

        //console.log('"Access' + perimeterName + 'Perimeter" found? ' + (perimeter !== undefined ? 'Yes' : 'No'));

        if (perimeter) {
            const sandbox = createSandbox(child(store), {
                governess: new Governess(context),

                perimeters: [
                    perimeter
                ]
            });

            sandbox.guard('access', {redirect});
            //return ret;
        } else {
            //redirect('/');
        }
    });
}