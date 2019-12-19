<template>
  <div id="app">
    <nav-header v-if="$router.currentRoute.name!='login' && $router.currentRoute.name!='register'" />
    <router-view />
  </div>
</template>

<script>
import NavHeader from './components/Header.vue';
import auth from './auth.js'
export default {
  components: {
    NavHeader
  },
  data() {
    return {
    }
  },
  
}
</script>

<style>
@import url('https://fonts.googleapis.com/css?family=Titan+One&display=swap');
@import url('https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap');

html{
  height: 100%;
}
body {
  height: 100%;
  background:#ff7d49;
  background: linear-gradient(to right, #ff7f68, #ffdb2b, #ffdb2b,#ffdb2b,#ffdb2b,#ffdb2b, #ff7f68);

  
 
  font-family: 'Baloo Bhai', cursive;
}

#app {
height: 100%;
}

h1 {
  text-align:center;
  color:#ef2871;
  text-transform: uppercase;
  font-family: 'Titan One', cursive;
  
}

</style>
