<template>
  <div class="home">
      
      <div class="hosting container col-8">
        <div>
        <h1>Hosting</h1>
        <event-preview v-for="event in hosting" v-bind:list="hosting" v-bind:key="event.eventId">
        </event-preview>
        </div>
      </div>

      <div class="attending container col-8">
        <h1>Attending</h1>
        <event-preview v-for="event in attending" v-bind:list="attending" v-bind:key="event.eventId">
        </event-preview>
      </div>

      <div class="invites container col-8">
        <h1>Invites</h1>
        <event-preview v-for="event in invites" v-bind:list="invites" v-bind:key="event.eventId">
        </event-preview>
      </div>
  </div>
</template>

<script>
import EventPreview from '../components/EventPreview.vue';
import auth from '../auth.js'
export default {
  name: 'home', 
  components: {
    EventPreview
  },
  data() {
    return {
      events: [],
      hosting: [],
      attending: [],
      invites: []

    }
  },
  methods : {
    fetchEvents() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/api/events`, {
                method : "GET",
                headers: { //this header will insert the user ID into the called upon methods
                    
                    "Authorization": "Bearer "+auth.getToken(),
                    "Content-Type" : "application/json",
                    "Accepts" : "application/json"
                }
            })
            .then((response)=>response.json())
            .then((data)=>{
              this.events = data;
              // this.hosting = data.filter(x => x.AmHost);
              this.hosting = data.filter((current) => {
                return current.isHost === true
              });
              this.attending = data.filter((current) =>{
                return current.isAttending === true
              });
              this.invites = data.filter((current) =>{
                return current.isAttending == null
              });
            })
    }
  },
  created(){
    this.fetchEvents();
  }
}
</script>

<style>

</style>