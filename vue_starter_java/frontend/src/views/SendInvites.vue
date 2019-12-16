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
            <input class="form-control" id="email-area" type="email"  placeholder="attendee@example.com" />
            </div>
            <button type="submit" class="form control btn btn-secondary">Send Invite</button>

 
        </form>





    </div>
</template>


<script>

export default {
    name: "send-invites",
    data() {
    return {
      eventAttendees: {
        userId: '',
        isHost: '',
        isAttending : '',
        firstName : '',
        role: 'user',
      },
    }
    }
    
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