<template>
   <div class="new-event-form container">
      <br>
      <!--
           name
           date
           time
           description
           deadline date
           address
           submit


           -->
<form>
  
  <div class="form-group col-md-8 form-row col" >
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
  </div>
  <div class="form-group col-md-8 form-row">
    <label for="inputAddress2">Address 2</label>
    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
  </div>
  
  <div class="form-group form-row col-md-8">
    <div class="col">
      <label for="inputCity">City</label>
      <input type="text" class="form-control" id="inputCity">
    </div>
    <div class="col">
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
    <div class="col">
      <label for="inputZip">Zip</label>
      <input type="text" class="form-control" id="inputZip">
    </div>
  </div>
  <div class = "form-row form-group col-md-8">
  <button type="submit" class="btn btn-primary">Submit Event</button>
 
  </div>
</form>
</div>

<!--
    <form>
        <br>
        <div class = "attending-btn container-fluid">
            <h3>Will you be attending?</h3>
        <div class="form-group btn-group btn-group-toggle" data-toggle="buttons">
        
            <label class="btn btn-secondary">
            <input name = "radio-attending" type="radio" value="true">Yes
            </label>
            <label class="btn btn-secondary">
            <input name = "radio-attending" type="radio" value="false">No
            </label>
        
        
        
        </div>
        <div class = "form-group">
        <h3>How many adult guests will you bring?</h3>
        <input type="number">
        </div>
        <div class = "form-group">
        <h3>How many children will you bring?</h3>
        <input type="number">
        </div>
        </div>





        <div class = "food-btn container-fluid btn-group-vertical btn-group-toggle" data-toggle="buttons">
             
            <h3>Please pick one of the following</h3>
              
            
                <label class="btn btn-secondary btn-lg" aria-pressed="true" type="radio">
                <input  name ="radio-food" type="radio"  value="true">
                    <h4>Food item title</h4>
                    <p>Food item description that goes on and on and on about how great the food is and how it's made</p>
                </label>
                
            
          
            
                <label class="btn btn-secondary btn-lg btn-block" type="radio">
                <input name ="radio-food" type="radio" value="true">
                    <h4>Food item title</h4>
                    <p>Food item description</p>
                </label>

           
        </div>

    </form>
    -->

</template>

<script>
export default {
    name : "new-event"
}
</script>

<style scoped>

</style>