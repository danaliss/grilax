<template>
<div id="create-menu" class = "container-fluid">
    <form class = "offset-md-3 col-md-6">
        <br><br>
        <h4>Entrees</h4>
        <entree-input></entree-input>
        <entree-input></entree-input>
        <entree-input></entree-input>

        <br><br>
        <h4>Sides</h4>
        <side-input></side-input>
        <side-input></side-input>
        <side-input></side-input>

        <br><br>

        <h4>Beverages</h4>
        <beverage-input></beverage-input>
        <beverage-input></beverage-input>
        <beverage-input></beverage-input>


        <button type="submit" class = "btn btn-secondary">Create Menu</button>
        
        
        
        <!--
        <div class="form-group">
        <label for="entree-name">Entree Name</label>
        <input type="text" id="entree-name" placeholder = "Enviable expression for your entree" class= "form-control">
        </div>
        <div class = "form-group">
            <label for="entree-description">Entree Description</label>
            <textarea type="text-area" class="form-control" id="entree-description" placeholder="Delicious details describing your dish"/>
        </div>

        <div class="form-group">
            <label for="side-name">Side Name</label>
            <input type="text" id="side-name" placeholder = "Salacious sound for your side" class= "form-control">
        </div>
        <div class = "form-group">
            <label for="side-description">Side Description</label>
            <textarea type="text-area" class="form-control" id="side-description" placeholder="Specifics sketching out your sustenance "/>
        </div>
        
        <div class="form-group">
            <label for="beverage-name">Beverage Name</label>
            <input type="text" id="beverage-name" placeholder = "Beverage Name" class= "form-control">
        </div>
        <div class = "form-group">
            <label for="beverage-description">Beverage Description</label>
            <textarea type="text-area" class="form-control" id="beverage-description" placeholder="Beverage Description"/>
        </div>
        -->
    
  
    </form>





</div>
    
</template>
<script>

import EntreeInput from '../components/EntreeInput'
import SideInput from '../components/SideInput'
import BeverageInput from '../components/BeverageInput'
export default {
    name : 'create-menu',
    components : {
        EntreeInput,
        SideInput,
        BeverageInput
}
}
</script>
<style scoped>

</style>