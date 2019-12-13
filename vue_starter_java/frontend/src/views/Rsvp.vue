<template>
<div class="rsvp-form container">

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
        <select type="number"  class="btn btn-secondary col-md-1 dropdown-toggle" data-toggle="dropdown">
            <option value="0">0</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class = "form-group">
        <h3>How many children will you bring?</h3>
        <select type="number" class="btn btn-secondary col-md-1">
            <option value="0">0</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        </div>





        <div class = "food-btn container-fluid btn-group-vertical btn-group-toggle col-md-8 form-group" data-toggle="buttons">
             
            <h3>Please pick one of the following</h3>
              
            
                <label class="btn btn-secondary btn-lg" type="radio">
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
        <div class = "form-group col-md-8">

            <button type="submit" class="btn btn-secondary btn-lg">Submit RSVP</button>

        </div>

    </form>
</div>

</template>

<script>
export default {
    name: "rsvp",
    data(){
        return {
            rsvp: {
              eventId:'',
              userId:'',
              attending:'',
              firstName:'',
              lastName:'',
              adultGuest:'',
              childGuest:''
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

.btn {
    background-color: var(--gxgreen) !important;
    border-color: var(--gxgreendark) !important;
    color: var(--gxwhite)!important;
    word-wrap: break-word;
    white-space: normal;
    text-align: left;
}

.attending-btn .btn{

    text-align: center;
}
.btn.active {
  color: var(--gxwhite) !important; 
  background-color: var(--gxgreendark) !important; 
  border-color: var(--gxgreendark) !important;
  
}
h3 {
    color: var(--gxpink);
}
.card {
    background-color: var(--gxwhite) !important;
}


</style>
