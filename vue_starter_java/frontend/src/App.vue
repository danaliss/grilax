<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link>
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  
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