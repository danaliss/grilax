<template>
    <div class = "entree-div">
         <div class="form-group">
        <label for="entree-name">Entree Name</label>
        <input type="text" id="entree-name" placeholder = "Enviable expression for your entree" class= "form-control">
        </div>

        <div class = "form-group">
            <label for="entree-description">Entree Description</label>
            <textarea type="text-area" class="form-control" id="entree-description" placeholder="Delicious details describing your dish"/>
        </div>


        <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="checkbox-vegetarian" value="true">
                <label class="form-check-label" for="checkbox-vegetarian">Vegetarian</label>
        </div>
        <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="checkbox-vegan" value="true">
                <label class="form-check-label" for="checkbox-vegan">Vegan</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="checkbox-gluten-free" value="true">
            <label class="form-check-label" for="checkbox-gluten-free">Gluten-Free</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="checkbox-nut-free" value="true">
            <label class="form-check-label" for="checkbox-nut-free">Nut-Free</label>
        </div>
        <br><br><br>
        </div>
</template>
<script>
export default {
    name: "entree-input"
}
</script>
<style scoped>

</style>