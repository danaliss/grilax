<template>


      <nav class="navbar navbar-expand-lg" role="navigation" aria-label="main navigation">
        <div class="navbar-nav">
            <a class="nav-item nav-link">GRILLAX LOGO
            <img src="" width="112" height="28">
            </a>
            <p class ="nav-item nav-link" @click="logout()">Logoff</p>
            <router-link class ="nav-item nav-link" to="/">Home</router-link>
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
  --gxwhite: #effffb;
  --gxwhitetransparent: rgba(239, 255, 251, .3)
}
nav {
    background-color: var(--gxwhitetransparent);
    
}

</style>
