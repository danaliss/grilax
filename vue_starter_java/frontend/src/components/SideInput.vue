<template>
    <div class = "side-div">
        <div class="form-group">
            <label for="side-name">Side Name</label>
            <input type="text" id="side-name" placeholder = "Salacious sound for your side" class= "form-control">
        </div>
        <div class = "form-group">
            <label for="side-description">Side Description</label>
            <textarea type="text-area" class="form-control" id="side-description" placeholder="Specifics sketching out your sustenance "/>
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
    name: 'side-input'
}
</script>
<style scoped>

</style>