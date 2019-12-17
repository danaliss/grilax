<template>
    <div id="beverage-div">
                <div class="form-group">
            <label for="beverage-name">Beverage Name</label>
            <input v-model="value.foodName"  type="text" id="beverage-name" placeholder = "Beverage Name" class= "form-control">
        </div>
        <div class = "form-group">
            <label for="beverage-description">Beverage Description</label>
            <textarea v-model="value.description" type="text-area" class="form-control" id="beverage-description" placeholder="Beverage Description"/>
        </div>
      
        <div class="form-check form-check-inline">
                <input v-model="value.vegan" class="form-check-input" type="checkbox" id="checkbox-vegan" value="true">
                <label class="form-check-label" for="checkbox-vegan">Vegan</label>
        </div>
        <div class="form-check form-check-inline">
            <input v-model="value.glutenFree" class="form-check-input" type="checkbox" id="checkbox-gluten-free" value="true">
            <label class="form-check-label" for="checkbox-gluten-free">Gluten-Free</label>
        </div>
        <div class="form-check form-check-inline">
            <input v-model="value.nutFree" class="form-check-input" type="checkbox" id="checkbox-nut-free" value="true">
            <label class="form-check-label" for="checkbox-nut-free">Nut-Free</label>
        </div>
        <br><br><br>
    </div>
</template>
<script>
export default {
    name : 'beverage-input',
    props: {
            value: {
                type: Object,
                required: true
            }
        },
        watch: {
            value() {
                this.$emit('input', this.value);
            }
        }
    
}
</script>
<style scoped>

</style>