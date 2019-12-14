<template>
<div>
<h1>{{event.name}}</h1>
<div class="details">
</div>
</div>  
</template>

<script>
import auth from '../auth.js'
export default {
    data(){
        return{
            event: Object,
            address: Object,
            attendees: []
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
                this.event = data;
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
                    this.address = data
                })
        },
        fetchAttendees(){
            fetch(`${process.env.VUE_APP_REMOTE_API}api/event/${this.event.eventId}/attendees`,{
                 method : "GET",
                    headers: {
                    "Authorization": "Bearer "+ auth.getToken(),
                    "Content-Type" : "application/json",
                    "Accepts" : "application/json"
                    }
                })
                .then((response)=> response.json())
                .then((data) => {
                    this.attendees = data
                })
        }
    
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

</style>