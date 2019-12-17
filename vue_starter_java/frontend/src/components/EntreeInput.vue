<template>
    <div class = "entree-div">
         <div class="form-group">
        <label for="entree-name">Entree Name</label>
        <input v-model="value.foodName" type="text" id="entree-name" placeholder = "Enviable expression for your entree" class= "form-control">
        </div>

        <div class = "form-group">
            <label for="entree-description">Entree Description</label>
            <textarea  v-model="value.description" type="text-area" class="form-control" id="entree-description" placeholder="Delicious details describing your dish"/>
        </div>


        <div class="form-check form-check-inline">
                <input v-model="value.vegetarian" class="form-check-input" type="checkbox" id="checkbox-vegetarian" value="true">
                <label class="form-check-label" for="checkbox-vegetarian">Vegetarian</label>
        </div>
        <div class="form-check form-check-inline">
                <input v-model="value.vegan" class="form-check-input" type="checkbox" id="checkbox-vegan">
                <label class="form-check-label" for="checkbox-vegan">Vegan</label>
        </div>
        <div class="form-check form-check-inline">
            <input v-model="value.glutenFree" class="form-check-input" type="checkbox" id="checkbox-gluten-free" >
            <label class="form-check-label" for="checkbox-gluten-free">Gluten-Free</label>
        </div>
        <div class="form-check form-check-inline">
            <input v-model="value.nutFree" class="form-check-input" type="checkbox" id="checkbox-nut-free" >
            <label class="form-check-label" for="checkbox-nut-free">Nut-Free</label>
        </div>
        <br><br><br>
        </div>
</template>
<script>
export default {
    name: "entree-input",
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