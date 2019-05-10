export default function ( { store, redirect }) {
    // If the user is authenticated redirect to home page
    if (store.state.auth.loggedIn) {
        console.log("User is authenticated: " + JSON.stringify(store.state.auth));
        return redirect('/')
    }
}