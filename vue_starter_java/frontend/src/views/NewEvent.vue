<template>
   <div class="new-event-form container col-6">
    
      <br>
  
<form>
      <h3 class="text-center">New Event</h3>
  
<div class="form-group form-row" >
    <div class = "col">
    <label for="inputAddress">Event Name</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="Exciting event name!!!"/>
  </div>
  </div>
  <div class="form-group form-row" >
      <div class='col'>
    <label for="description">Event Description</label>
    <textarea type="text-area" class="form-control" id="description" rows="3" placeholder="Details about the event here"/>
  </div>
  </div>

  <div class="form-group form-row">

    <div class="col">
      <label for="inputZip">Event Date</label>
      <input type="date" class="form-control" id="event-date">
    </div>
    <div class="col">
      <label for="inputZip">Event Time</label>
      <input type="text" class="form-control" id="event-date" placeholder="Event Time Here">
    </div>
    <div class="col">
      <label for="inputCity">RSVP Deadline</label>
      <input type="date" class="form-control" id="event-rsvp-deadline">
    </div>
  </div>
  
  
  <br>
  <br>
  

  <div class="form-group form-row" >
      <div class = "col">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
  </div>
  </div>

  
  <div class="form-group form-row">
    <div class="col-md-4">
      <label for="inputCity">City</label>
      <input type="text" class="form-control" id="inputCity">
    </div>
    <div class="col-md-4">
      <label for="inputState">State</label>
      <state-options></state-options>
    </div>
    <div class="col-md-4">
      <label for="inputZip">Zip</label>
      <input type="text" class="form-control" id="inputZip">
    </div>
  </div>
  <div class = "form-row form-group col-md ">
  <button type="submit" class="btn btn-primary">Submit Event</button>
 
  </div>
</form>
</div>


</template>

<script>
import StateOptions from '../components/StateOptions'
export default {
    name : "new-event",
    components : {
      StateOptions
    },
    data() {
      return {
        event: {
          name : '',
          description : '',
          date : '',
          time : '',
          deadline : '',
          userId : '',
          hosting : '',
          attending :  ''

        },
        address : {
          addressId : '',
          streetAddress : '',
          city : '',
          state : '',
          zip : '',
          userId : ''
        }

      }
    }

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

input {
  background-color: var(--gxwhite) !important;
}

</style>