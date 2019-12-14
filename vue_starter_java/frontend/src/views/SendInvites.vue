<template>
    <div id= "send-invites container-fluid">
        <br>
        <form class = "offset-md-3 col-md-6">
            <br>
            <h4>Invite Others to This Event</h4>
            <div class = "form-group">
            <label for = "invitee-role"></label>
            <select id = "invitee-role" class="custom-select form-control">

                <option value="attendee">Attendee</option>
                <option value="chef">Chef</option>

            </select>
            </div>
            <div class="form-group">
            <label for="email-area">Invitee Emails</label>
            <textarea class="form-control" id="email-area" type="email"  placeholder="attendee1@example.com, attendee2@example.com, attendee3@example.com" multiple/>
            </div>
            <button type="submit" class="form control btn btn-secondary">Send Invites</button>

 
        </form>





    </div>
</template>


<script>

export default {
    name: "send-invites",
}
</script>

<style scoped>

:root {
  --gxorange: #ff7f68;
  --gxyellow: #ffdb2b;
  --gxpink: #ef2871;
  --gxgreen: rgb(217, 224, 216);
   --gxgreendark: #63bd55;
  --gxwhite: #effffb;
  --gxgreentransparent: rgb(113, 216, 97, 1)
}

.form-control {
    background-color: var(--gxwhite) !important;
}
</style>