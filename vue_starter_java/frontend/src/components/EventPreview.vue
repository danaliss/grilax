<template>
<router-link tag="div" class="preview" v-bind:to="{ name:'eventDetails', params:{eventId:list.eventId}}">
    <!-- make this populate from the API -->
    <h2>{{list.name}}</h2>  
    <h3>{{list.time}} {{list.date.dayOfWeek}} {{list.date.month}} {{list.date.day}} {{list.date.year}}</h3>
    
</router-link>
</template>

<script>


export default {
    name: 'event-preview',
    props: {
        list: Object
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
