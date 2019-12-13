<template>
  <div class="home">
      
      <div class="hosting container col-8">
        <div>
        <h1>Hosting</h1>
        <event-preview v-for="event in hosting" v-bind:list="event" v-bind:key="event.eventId"/>
        </div>
      </div>

      <div class="attending container col-8">
        <h1>Attending</h1>
        <event-preview v-for="event in attending" v-bind:list="event" v-bind:key="event.eventId">
        </event-preview>
      </div>

      <div class="invites container col-8">
        <h1>Invites</h1>
        <event-preview v-for="event in invites" v-bind:list="event" v-bind:key="event.eventId">
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
              this.events = data.object;
              
              this.hosting = this.events.filter((current) => {
                return current.hosting === true
              });
              this.attending = this.events.filter((current) =>{
                return current.attending === true
              });
              this.invites = this.events.filter((current) =>{
                return current.attending === false
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