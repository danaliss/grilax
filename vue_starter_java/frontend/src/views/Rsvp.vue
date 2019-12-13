<template>
<div class="rsvpForm">
    <form>

        <div class = "container">
            <h4>Will you be attending?</h4>
        <div class="form-group">
        <div class = "form-check">
            <input class="form-check-input" name = "radio-yes" type="radio" value="true">
            <label class="form-check-label" for="radio-yes">Yes</label>
        </div>
        <div class = "form-check">
            <input class="form-check-input" name = "radio-no" type="radio" value="false">
            <label class="form-check-label" for="radio-no">No</label>
        </div>
        </div>
        <div class = "container">
            <h4>Please pick one of the following</h4>
            <div class = "form-group card">
                <input class = "form-check-input" name ="radio-1" type="radio" value="true">
                <label class="form-check-label" for ="radio-1" type="radio">
                    <h6>Food item title</h6>
                    <p>Food item description</p>
                </label>
            </div>
            <div class = "form-group card">
                <input class = "form-check-input" name ="radio-2" type="radio" value="true">
                <label class="form-check-label" for ="radio-2" type="radio">
                    <h6>Food item title</h6>
                    <p>Food item description</p>
                </label>
            </div>
        </div>
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
              adultGuest:'',
              childGuest:''
            }
        }

    }
}
</script>

<style scoped>

:root {
  --gxorange: #ff7f68;
  --gxyellow: #ffdb2b;
  --gxpink: #ef2871;
  --gxgreen: rgb(113, 216, 97);
  --gxwhite: #effffb;
  --gxgreentransparent: rgb(113, 216, 97, 1)
}
.card{
    background-color: var(--gxwhite)
}
</style>