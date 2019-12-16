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
    </div>
</template>
<script>
export default {
    name: 'side-input'
}
</script>
<style scoped>

</style>