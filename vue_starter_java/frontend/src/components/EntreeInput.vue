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
    </div>
</template>
<script>
export default {
    name: "entree-input"
}
</script>
<style scoped>

</style>