<template>
<div class="rsvp-form container">

    <form>
        <br>
        <div class = "attending-btn container-fluid">
            <h3>Will you be attending?</h3>
        <div class="form-group btn-group btn-group-toggle">
            
        
            <label class="btn btn-secondary" v-bind:class="{ active: rsvp.attending==='true' }">
            <input 
            name = "attending" 
            type="radio" 
            v-model="rsvp.attending"
            value="true" />Yes
            </label>

            <label class="btn btn-secondary" v-bind:class="{ active: rsvp.attending==='false' }">
            <input 
            name = "attending" 
            type="radio"
            v-model="rsvp.attending" 
            value="false" />No
            </label>
        </div>

        <div class="form-group">
            <h3>First Name</h3>
            <label for="firstName">
            <input
              type="text"
              placeholder="First Name"
              v-model="rsvp.firstName"
            >
            </label>
             <h3>Last Name</h3>
            <label for="firstName">
            <input
              type="text"
              placeholder="Last Name"
              v-model="rsvp.lastName"
            >
            </label>
          </div>

        <div class = "form-group">
        <h3>How many adult guests will you bring?</h3>
        <select type="number"  class="btn btn-secondary col-md-1" v-model="rsvp.adultGuest">
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
        <select type="number" class="btn btn-secondary col-md-1" v-model="rsvp.childGuest">
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

        <div class="rsvp-menu">
        <h3>Please pick one of the following entrees</h3>
        <rsvp-menu v-for="food in entree" v-bind:foodItem="food" v-bind:key="food.foodId"></rsvp-menu>
        
        <h3>Choose up to two sides</h3>
        <rsvp-menu v-for="food in side" v-bind:foodItem="food" v-bind:key="food.foodId"></rsvp-menu>

        <h3>Choose one dessert</h3>
        <rsvp-menu v-for="food in dessert" v-bind:foodItem="food" v-bind:key="food.foodId"></rsvp-menu>

        <h3>Beverage options at the party</h3>
        <ul>
            <li v-for="drink in beverage" v-bind:key="drink.foodId">{{drink.foodName}} {{drink.description}}</li>
        </ul>
        </div>

        
        <div class = "form-group col-md-8">
            <button type="submit" class="btn btn-secondary btn-lg">Submit RSVP</button>
        </div>

    </form>
</div>

</template>

<script>
import auth from '../auth.js'
import RsvpMenu from '../components/RsvpMenu.vue';
export default {
    name: "rsvp",
    components:{
        RsvpMenu
    },
    data(){
        return {
            rsvp: {
              eventId:'',
              attending: false,
              firstName:'',
              lastName:'',
              adultGuest:'',
              childGuest:'',
              food: {
                  entreeId: '',
                  entreeQuantity: '',
                  sideId: '',
                  sideQuantity: '',
                  dessertId: '',
                  dessertQuantity: ''
              }
            },
            menu: [],
            entree: [],
            side: [],
            beverage: [],
            dessert:[]

        }

    },
    methods: {
        fetchEventMenu(){
            fetch(`${process.env.VUE_APP_REMOTE_API}/api/event/${this.$route.params.eventId}/menu`, {
                method : "GET",
                headers: { 
                    "Authorization": "Bearer "+ auth.getToken(),
                    "Content-Type" : "application/json",
                    "Accepts" : "application/json"
                }
            })
            .then((response) => response.json())
            .then((data) => {
                this.menu = data.object
                this.filterMenu();
            
            })
        },
        fetchAttendeeInfo(){

        },
        filterMenu(){
            this.entree = this.menu.filter((current)=>{
                return current.foodCategory === "Entree"
            })
             this.side = this.menu.filter((current)=>{
                return current.foodCategory === "Side"
            })
             this.dessert = this.menu.filter((current)=>{
                return current.foodCategory === "Dessert"
            })
             this.beverage = this.menu.filter((current)=>{
                return current.foodCategory === "Beverage"
            })
        }
        },
        
        created(){
            this.fetchEventMenu();
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
    background-color: var(--gxgreen) ;
    border-color: var(--gxgreendark) ;
    color: var(--gxwhite);
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
    background-color: var(--gxwhite) ;
}
.selected {
    background-color: var(--gxgreendark) ;
}


</style>
