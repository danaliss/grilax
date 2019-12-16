<template>
<div >
    <h1>{{event.name}}</h1>
    <section class="details">
        <h2>{{event.time}} {{event.date.dayOfWeek}} {{event.date.month}} {{event.date.day}} {{event.date.year}}</h2>
        <h2>{{event.date.daysAway}} days away!</h2>
        <h4>{{address.streetAddress}} {{address.city}} {{address.state}}</h4>
        <p>{{event.description}}</p>

    <section class="guest-list">
        <h5>Guests</h5>
        <ul>
        <li v-for = "guest in attendees" v-bind:key="guest.userId"> {{guest.firstName}} {{guest.lastName}}</li>
        </ul>
    </section>
    </section>
    
    <section class="not-attending" v-if="event.hosting">
        <h5 class="no">Not Attending</h5>
        <ul>
        <li v-for = "guest in notAttending" v-bind:key="guest.userId"> {{guest.firstName}} {{guest.lastName}}</li>
        </ul>
        <h5 class="noRsvp">Not RSVP</h5>
        <ul>
        <li v-for = "guest in notRsvp" v-bind:key="guest.userId"> {{guest.firstName}} {{guest.lastName}}</li>
        </ul>
    </section>

    <section class="rsvp">
        <router-link tag="h1" v-bind:to="{ name:'rsvp', params:{eventId:event.eventId}}">
            <button class="btn">RSVP</button>
        </router-link>
    </section>
</div>
</template>

<script>
import auth from '../auth.js'
export default {
    data(){
        return{
            
            event: Object,
            address: Object,
            attendees: [],
            notAttending: [],
            notRsvp: []
        
        }
    },
    methods:{
        fetchDescription(){
            fetch(`${process.env.VUE_APP_REMOTE_API}/api/event/${this.$route.params.eventId}`,{
                 method : "GET",
                headers: { //this header will insert the user ID into the called upon methods
                    
                    "Authorization": "Bearer "+ auth.getToken(),
                    "Content-Type" : "application/json",
                    "Accepts" : "application/json"
                }
            })
            .then((response) => response.json())
            .then((data)=>{
                this.event = data.object;
                this.fetchAddress();
                this.fetchAttendees();
                
            
            })
        },
        fetchAddress(){
            fetch(`${process.env.VUE_APP_REMOTE_API}/api/address/${this.event.addressId}`,{
                 method : "GET",
                    headers: {
                    "Authorization": "Bearer "+ auth.getToken(),
                    "Content-Type" : "application/json",
                    "Accepts" : "application/json"
                    }
                })
                .then((response)=> response.json())
                .then((data) => {
                    this.address = data.object
                })
        },
        fetchAttendees(){
            fetch(`${process.env.VUE_APP_REMOTE_API}/api/event/${this.event.eventId}/attendees`,{
                 method : "GET",
                    headers: {
                    "Authorization": "Bearer "+ auth.getToken(),
                    "Content-Type" : "application/json",
                    "Accepts" : "application/json"
                    }
                })
                .then((response)=> response.json())
                .then((data) => {
                    this.attendees = data.object
                    this.generateGuestList();
                })
        },
        generateGuestList(){
            this.attendees = this.attendees.filter((current) => {
                return current.attending === true && current.host ===false;
            })
            this.notAttending = this.attendees.filter((current) => {
                return current.attending === false && current.host ===false;
            })
            this.notRsvp = this.attendees.filter((current) => {
                return current.attending === null && current.host ===false;
            })
        },
    
    },
    created(){
    this.fetchDescription();
  }

  
}
</script>
<style scoped>
.details {
    background: #effffb;
    color: #63bd55;
}
.not-attending {
    background: rgb(128,128,128);
}
.no {
    color: #FF0033;
}
.noRsvp {
    color: #FFCC33;
}

</style>