<template>
<div class="preview">
    <!-- make this populate from the API -->
    <h2>{{list.name}}EVENT name</h2>  
    <h3>{{list.date}}EVENT DATE</h3>
    <p>{{list.description}}EVENT DESCRIPTION</p>
</div>
</template>

<script>


export default {
    name: 'event-preview',
    props: {
        list: Array
    }

}

</script>

<style scoped>
.preview {
    color: #71d861;
    background: #effffb;
    margin: 50px auto;
    border-radius: 10px;
    text-align: center;
}
</style>