<template>


      <nav class="navbar navbar-expand-sm" role="navigation" aria-label="main navigation">
        <div class="navbar-nav">
            <a class="nav-item nav-link">GRILLAX LOGO
            <img src="" width="112" height="28">
            </a>
            <p class ="nav-item nav-link" @click="logout()">Logoff</p>
            <router-link class ="nav-item nav-link" to="/">Home</router-link>
            <router-link class ="nav-item nav-link" to="/newevent">Create New Event</router-link>
        </div>
      </nav>







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
:root {
  --gxorange: #ff7f68;
  --gxyellow: #ffdb2b;
  --gxpink: #ef2871;
  --gxgreen: #71d861;
  --gxgreendark: #63bd55;
  --gxwhite: #effffb;
  --gxgreentransparent: rgb(113, 216, 97, 1)
}
nav {
    background-color: var(--gxgreentransparent);
    
}

</style>
