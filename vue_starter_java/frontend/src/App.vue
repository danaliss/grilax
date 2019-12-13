<template>
  <div id="app">
    <nav-header />
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
body {
  background:#ff7d49;
  background: radial-gradient(circle,#ffdb2b 90%, #ff7d49 100%);
  font-family: 'Baloo Bhai', cursive;
}
#app {
  
}
h1 {
  text-align:center;
  color:#ef2871;
  text-transform: uppercase;
  font-family: 'Titan One', cursive;
  
}

</style>
