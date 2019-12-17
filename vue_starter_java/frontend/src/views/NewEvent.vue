<template>
   <div class="container col-6" id="new-event-form">
    
      <br>
  
<form @submit.prevent="createEvent">
      <h3 class="text-center">New Event</h3>
      <div class="alert alert-danger" role="alert" v-if="newEventError">
        There were problems creating this event (all fields are required)
      </div>
  
<div class="form-group form-row" >
    <div class = "col">
    <label >Event Name</label>
    <input 
    type="text" 
    class="form-control" 
    id="inputAddress" 
    v-model="event.name" 
    required placeholder="Exciting event name!!!"/>
  </div>
  </div>
  <div class="form-group form-row" >
      <div class='col'>
    <label for="description">Event Description</label>
    <textarea 
    type="text-area" 
    class="form-control" 
    id="description" 
    rows="3" 
    v-model="event.description"
    placeholder="Details about the event here"/>
  </div>
  </div>

  <div class="form-group form-row">

    <div class="col">
      <label for="inputZip">Event Date</label>
      <input 
      type="date" 
      class="form-control" 
      id="event-date"
      v-model="event.date">
    </div>
    <div class="col">
      <label for="event-date">Event Time</label>
      <input 
      type="text" 
      class="form-control" 
      id="event-date" 
      v-model="event.time"
      placeholder="Event Time Here">
    </div>
    <div class="col">
      <label for="event-rsvp-deadline">RSVP Deadline</label>
      <input 
      type="date" 
      class="form-control" 
      id="event-rsvp-deadline"
      v-model="event.deadline">
    </div>
  </div>
  
  
  <br>
  <br>
  

  <div class="form-group form-row" >
      <div class = "col">
    <label for="inputAddress">Address</label>
    <input type="text" 
    v-model="event.address.streetAdress"
    class="form-control" 
    id="inputAddress" 
    placeholder="1234 Main St">
  </div>
    <!-- v-model="address.streetAddress" -->
  </div>

  
  <div class="form-group form-row">
    <div class="col-md-4">
      <label for="inputCity">City</label>
      <input 
      v-model="event.address.city"
      type="text" 
      class="form-control" 
      id="inputCity"
      >
      <!-- v-model="address.city"-->
    </div>
    <div class="col-md-4">
      <label for="inputState">State</label>
      <!--
      
      <state-options
        :value='address.state'  
        @input="(newAddress)=>{address = newAddress}"
      />-->
      <select id="inputState" 
      v-model="event.address.state"
      class="form-control">
      <!-- v-model="address.state"  -->
          
        <option selected>Choose...</option>
        <option value="AL">Alabama</option>
            <option value="AK">Alaska</option>
            <option value="AZ">Arizona</option>
            <option value="AR">Arkansas</option>
            <option value="CA">California</option>
            <option value="CO">Colorado</option>
            <option value="CT">Connecticut</option>
            <option value="DE">Delaware</option>
            <option value="DC">District Of Columbia</option>
            <option value="FL">Florida</option>
            <option value="GA">Georgia</option>
            <option value="HI">Hawaii</option>
            <option value="ID">Idaho</option>
            <option value="IL">Illinois</option>
            <option value="IN">Indiana</option>
            <option value="IA">Iowa</option>
            <option value="KS">Kansas</option>
            <option value="KY">Kentucky</option>
            <option value="LA">Louisiana</option>
            <option value="ME">Maine</option>
            <option value="MD">Maryland</option>
            <option value="MA">Massachusetts</option>
            <option value="MI">Michigan</option>
            <option value="MN">Minnesota</option>
            <option value="MS">Mississippi</option>
            <option value="MO">Missouri</option>
            <option value="MT">Montana</option>
            <option value="NE">Nebraska</option>
            <option value="NV">Nevada</option>
            <option value="NH">New Hampshire</option>
            <option value="NJ">New Jersey</option>
            <option value="NM">New Mexico</option>
            <option value="NY">New York</option>
            <option value="NC">North Carolina</option>
            <option value="ND">North Dakota</option>
            <option value="OH">Ohio</option>
            <option value="OK">Oklahoma</option>
            <option value="OR">Oregon</option>
            <option value="PA">Pennsylvania</option>
            <option value="RI">Rhode Island</option>
            <option value="SC">South Carolina</option>
            <option value="SD">South Dakota</option>
            <option value="TN">Tennessee</option>
            <option value="TX">Texas</option>
            <option value="UT">Utah</option>
            <option value="VT">Vermont</option>
            <option value="VA">Virginia</option>
            <option value="WA">Washington</option>
            <option value="WV">West Virginia</option>
            <option value="WI">Wisconsin</option>
            <option value="WY">Wyoming</option>
            
      </select>
    </div>
    <div class="col-md-4">
      <label for="inputZip">Zip</label>
      <input 
      v-model="event.address.zip"
      type="text" 
      class="form-control"
      id="inputZip">
    </div>
      <!-- v-model="address.zip"  -->
  </div>
  <div class = "form-row form-group col-md ">
  <button type="submit" class="btn btn-primary">Submit Event</button>
 
  </div>
</form>
</div>


</template>

<script>
//import StateOptions from '../components/StateOptions'
import auth from '../auth'
export default {
    name : "new-event",
    components : {
      //StateOptions
    },
    data() {
      return {
        event: {
          name : '',
          date : '',
          time : '',
          description : '',
          deadline : '',
          addressId : '',
          hosting : true,
          attending :  true,
          userId : '',
          address : {
            addressId : '',
            streetAddress : '',
            city : '',
            state : '',
            zip : '',
            userId : ''
          },
        },
        newEventError : false,
      }
    },
     methods: {
    createEvent() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/api/events`, {
        method: 'POST',
        headers: {
          "Authorization": "Bearer "+ auth.getToken(),
          "Accept": 'application/json',
          'Content-Type': 'application/json',

        },
        body: JSON.stringify(this.event),
      })
        .then((response) => {
          if (response.ok) {
            this.$router.push({ path: `/`, query: { createEventStatus: 'success' } });
          } else {
            this.newEventError = true;
          }
        })

        .then((err) => console.error(err));
    },
  },


}
</script>

<style scoped>

:root {
  --gxorange: #ff7f68;
  --gxyellow: #ffdb2b;
  --gxpink: #ef2871;
  --gxgreen: rgb(217, 224, 216);
   --gxgreendark: #63bd55;
  --gxwhite: #effffb;
  --gxgreentransparent: rgb(113, 216, 97, 1)
}

input, textarea, select {
  background-color: var(--gxwhite) !important;
}

</style>