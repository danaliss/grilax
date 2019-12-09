<template>
  <div id="app">
    <nav-header />
    <router-view />
  </div>
</template>

<script>
import NavHeader from './components/Header.vue';

export default {
  components: {
    NavHeader
  }
}
</script>

<style>
body {
  background: yellow;
  background: radial-gradient(circle, yellow 50%, orange 100%);
}
#app {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-gap: 20px;
}
h1 {
  grid-row: 1;
  grid-column: 1 / 4;
  text-align:center;
  color:#ff009d;
  text-transform: uppercase;
  font-family: 'Roboto Condensed', sans-serif;
}

</style>
