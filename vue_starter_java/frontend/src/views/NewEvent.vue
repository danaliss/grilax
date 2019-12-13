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
    <label for="inputAddress">Event Description</label>
    <textarea type="text-area" class="form-control" id="inputAddress" rows="3" placeholder="Details about the event here"/>
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
      <select id="inputState" class="form-control">
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
export default {
    name : "new-event"
}
</script>

<style scoped>

</style>