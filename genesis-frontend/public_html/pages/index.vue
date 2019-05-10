<template>
    <div>
        <h1>Welcome to Wau Movil CoreUI Pro Vue Application!!!</h1>
        <h2>You're in the index page!!!</h2>
    </div>
</template>

<script>
export default {
    name: 'Home',
    middleware: 'authenticated',    
    beforeCreate() {
        console.log("Lifecycle: beforeCreate");
        this.$router.push('/Dashboard');
    },
    created() {
        console.log("Lifecycle: created");
    },
    beforeMount() {
        console.log("Lifecycle: beforeMount");
    },
    mounted() {
        console.log("Lifecycle: mounted");
    },
    beforeUpdate() {
        console.log("Lifecycle: beforeUpdate");
    },
    updated() {
        console.log("Lifecycle: updated");
    },
    activated() {
        console.log("Lifecycle: activated");
    },
    deactivated() {
        console.log("Lifecycle: deactivated");
    },
    beforeDestroy() {
        console.log("Lifecycle: beforeDestroy");
    },
    destroyed() {
        console.log("Lifecycle: destroyed");
    },
    errorCaptured() {
        console.log("Lifecycle: errorCaptured");
    }
}
</script>
