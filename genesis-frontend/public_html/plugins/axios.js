import toastr from 'toastr';
import 'toastr/toastr.js';
import 'toastr/toastr.scss';

export default function ( { $axios, app, store }) {

    $axios.onRequest(config => {
        //console.log('Axios Request ' + config);
    });

    $axios.onError(error => {
        //console.log('Axios Error ' + error.response.status);        

        if (error.response.status === 500) {
            /*toastr.options.closeButton = true;
            toastr.options.newestOnTop = false;
            toastr.options.timeOut = 5000; // How long the toast will display without user interaction. If 0, the toastr will persist until selected.
            toastr.options.extendedTimeOut = 5000; // How long the toast will display after a user hovers over it. If 0, the toastr will persist until selected.
            toastr.options.progressBar = true;
            toastr.options.preventDuplicates = true;

            toastr.error(error.response.data.message, 'Error');*/
            throw error;
        } else if (error.response.status === 401) {
            app.$auth.logout().then(function () {
                console.error("FATAL: Automatically logged out. Session expired. " + error.response.error);

                app.router.push({
                    name: 'Login',
                    params: {
                        message: 'Su sesión ha expirado. Por favor ingrese nuevamente.'
                    }
                });
            });
        } else if (error.response.status === 504) {            
            throw error;
        } else {
            app.$auth.logout().then(function () {
                console.error("FATAL: Automatically logged out. " + JSON.stringify(error.response));

                app.router.push({
                    name: 'Login',
                    params: {
                        message: 'Ha ocurrido un error inesperado. Por favor ingrese nuevamente.'
                    }
                });
            });
        }

        //console.table(error);
        //throw error.response;
    });

    $axios.onResponseError(error => {
        //console.log('Axios ResponseError ' + error);
    });

};