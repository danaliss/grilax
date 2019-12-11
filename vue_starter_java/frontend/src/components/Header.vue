<template>
    <div class="header">
      <p @click="logout()">Logoff</p>
      <router-link to="/">Home</router-link>
    </div>
</template>

<script>
import auth from '../auth';

export default {
    name: "nav-header",
    data() {
        return {
            auth
        }
    },
    methods: {
        logout() {
            auth.logout();
            this.$router.push({ name: 'login' }).catch((err)=> {});
        }
    }
}
</script>

<style>


</style>
