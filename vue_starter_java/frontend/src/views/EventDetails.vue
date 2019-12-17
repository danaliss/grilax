<template>
<div>
    <div v-if="event">
    <h1>{{event.name}}</h1>
    <section class="details">
        <h2>{{event.time}} {{event.date.dayOfWeek}} {{event.date.month}} {{event.date.day}} {{event.date.year}}</h2>
        <h2>{{event.date.daysAway}} days away!</h2>
        <h4>{{address.streetAddress}} {{address.city}} {{address.state}}</h4>
        <p>{{event.description}}</p>

        <router-link tag="button" :to="{ name: 'sendinvite', params: { eventId: this.$route.params.eventId } }">Send Invitation</router-link>

        <section class="guest-list">
            <h5>Guest List:</h5>
            <ul>
                <li v-for = "guest in yesAttending" v-bind:key="guest.userId"> {{guest.firstName}} {{guest.lastName}}</li>
            </ul>
        </section>
    </section>
    
    <section class="not-attending" v-if="event.hosting">
        <h5 class="no">Declined Invitation:</h5>
        <ul>
        <li v-for = "guest in notAttending" v-bind:key="guest.userId"> {{guest.firstName}} {{guest.lastName}}</li>
        </ul>
        <h5 class="noRsvp">Awaiting RSVP:</h5>
        <ul>
        <li v-for = "guest in notRsvp" v-bind:key="guest.userId"> {{guest.firstName}} {{guest.lastName}}</li>
        </ul>
    </section>

    <section class="rsvp" v-if="event.invited">
        <router-link tag="h1" v-bind:to="{ name:'rsvp', params:{eventId:event.eventId}}">
            <button class="btn">RSVP</button>
        </router-link>
    </section>
    </div>
    <div v-if="event === null">
        <h1>Loading event...please stand by</h1>
    </div>
</div>
</template>

<script>
import auth from '../auth.js'
export default {
    data(){
        return{
            
            event: null,
            address: Object,
            attendees: [],
            yesAttending: [],
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
                const tempEvent = data.object;
                //setting the promises returned by the defined fetsches
                const promises = [
                    this.fetchAddress(tempEvent.addressId),
                   this.fetchAttendees(tempEvent.eventId)
                ];
                //mega promise over an iterible set
                Promise.all(promises)
                .then(()=>{
                    this.event = tempEvent;
                });
                
            
            })
        },
        fetchAddress(addressId){
            return fetch(`${process.env.VUE_APP_REMOTE_API}/api/address/${addressId}`,{
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
                });
        },
        fetchAttendees(eventId){
            return fetch(`${process.env.VUE_APP_REMOTE_API}/api/event/${eventId}/attendees`,{
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
                });
        },
        generateGuestList(){
            this.yesAttending = this.attendees.filter((current) => {
                return current.attending === true && current.host ===false;
            })
            this.notAttending = this.attendees.filter((current) => {
                return current.attending === false && current.hasRsvped && current.host ===false;
            })
            this.notRsvp = this.attendees.filter((current) => {
                return !current.hasRsvped && current.host ===false;
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