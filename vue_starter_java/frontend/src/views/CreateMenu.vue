<template>
<div id="create-menu" class = "container-fluid">
    <form @submit.prevent="createMenu" class = "offset-md-3 col-md-6">
        <br><br>
        
        <h4>Entrees</h4>
        <entree-input v-model="entree1" />
        <entree-input v-model="entree2" />
        <entree-input v-model="entree3" />

        
        <br><br>
        <h4>Sides</h4>
        <side-input v-model="side1"/>
        <side-input v-model="side2"/>
        <side-input v-model="side3"/>


        <br><br>

        <h4>Beverages</h4>
        <beverage-input v-model="beverage1"/>
        <beverage-input v-model="beverage2"/>
        <beverage-input v-model="beverage3"/>
        
        <br><br>
        <h4>Desserts</h4>
        <dessert-input v-model="dessert1"/>
        <dessert-input v-model="dessert2"/>
        <dessert-input v-model="dessert3"/>

        <button type="submit" class = "btn btn-secondary">Create Menu</button>
        
        <br>
 
  
    </form>





</div>
    
</template>
<script>
import auth from '../auth'
import EntreeInput from '../components/EntreeInput'
import SideInput from '../components/SideInput'
import BeverageInput from '../components/BeverageInput'
import DessertInput from '../components/DessertInput'
export default {
    name : 'create-menu',
    components : {
        EntreeInput,
        SideInput,
        BeverageInput,
        DessertInput
},
    data() {
        return {
            
            entree1 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Entree'
            },
            entree2 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Entree'
            },
            entree3 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Entree'
            },
            side1 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Side'
            },
            side2 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Side'
            },
            side3 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Side'
            },
            dessert1 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Dessert'
            },
            dessert2 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Dessert'
            },
            dessert3 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Dessert'
            },
            beverage1 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Beverage'
            },
            beverage2 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Beverage'
            },
            beverage3 : {
                foodName : '',
                vegetarian : false,
                vegan : false,
                glutenFree : false,
                nutFree : false,
                description : '',
                foodCategory : 'Beverage'
            },
        }
    },
    methods: {
                    fetcherMethod(menuItem){
                        if(menuItem.foodName !== ''){
                        fetch(`${process.env.VUE_APP_REMOTE_API}/api/event/${this.$route.params.eventId}/menu`, {
                        method: 'POST',
                        headers: {
                          "Authorization": "Bearer "+ auth.getToken(),
                          "Accept": 'application/json',
                          'Content-Type': 'application/json',
                
                        },
                        body: JSON.stringify(menuItem),
                      })
                    }
                    },
    createMenu() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/api/event/${this.$route.params.eventId}/menu`, {
        method: 'POST',
        headers: {
          "Authorization": "Bearer "+ auth.getToken(),
          "Accept": 'application/json',
          'Content-Type': 'application/json',

        },
        body: JSON.stringify(this.entree1),
      })
      .then(this.fetcherMethod(this.entree2))
      .then(this.fetcherMethod(this.entree3))
      .then(this.fetcherMethod(this.side1))
      .then(this.fetcherMethod(this.side2))
      .then(this.fetcherMethod(this.side3))
      .then(this.fetcherMethod(this.beverage1))
      .then(this.fetcherMethod(this.beverage2))
      .then(this.fetcherMethod(this.beverage3))
      .then(this.fetcherMethod(this.dessert1))
      .then(this.fetcherMethod(this.dessert2))
      .then(this.fetcherMethod(this.dessert3))

        
        .then((response) => {
          if (response.ok) {
            this.$router.push({ path: `/event/${this.$route.params.eventId}/eventdetails`, query: { createEventStatus: 'success' } });
          } else {
            this.registrationErrors = true;
          }
        })

        .then((err) => console.error(err));
    },
  },
}
</script>
<style scoped>

</style>