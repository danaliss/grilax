<template>
<div class="rsvpForm">
    <form>
        <div>
            
        </div>
    </form>
</div>
</template>

<script>
export default {
    name: "rsvp",
    data(){
        return {
            rsvp: {
              eventId:'',
              userId:'',
              attending:'',
              firstName:'',
              lastName:'',
              adutGuest:'',
              childGuest:''
            }
        }

    }
}
</script>

<style scoped>

</style>