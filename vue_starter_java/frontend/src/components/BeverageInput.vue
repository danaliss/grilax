<template>
    <div id="beverage-div">
                <div class="form-group">
            <label for="beverage-name">Beverage Name</label>
            <input type="text" id="beverage-name" placeholder = "Beverage Name" class= "form-control">
        </div>
        <div class = "form-group">
            <label for="beverage-description">Beverage Description</label>
            <textarea type="text-area" class="form-control" id="beverage-description" placeholder="Beverage Description"/>
        </div>
    </div>
</template>
<script>
export default {
    name : 'beverage-input'
    
}
</script>
<style scoped>

</style>