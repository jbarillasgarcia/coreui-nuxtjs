export default function ( { app }) {
    !app.$auth.onError((error, name, endpoint) => {

        console.log("***** AUTHORIZATION ERROR *****");
        console.log("Error: " + error.response.data.status + ":" + error.response.data.error);
        console.log("Message: " + error.response.data.message);

        //console.error(name, error)
    })
}