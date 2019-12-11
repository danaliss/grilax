<template>
  <div class="home">
      
      <div class="hosting container">
        <div>
        <h1>Hosting</h1>
        <event-preview>
        </event-preview>
        </div>
      </div>
      <div class="attending">
        <h1>Attending</h1>
          <event-preview>
          </event-preview>
      </div>
      <div class="invites">
        <h1>Invites</h1>
          <event-preview>
          </event-preview>
      </div>
  </div>
</template>

<script>
import EventPreview from '../components/EventPreview.vue';
export default {
  name: 'home', 
  components: {
    EventPreview
  }
}
</script>

<style>

</style>