<template>
<div id="grad">
  <div id="login" class="text-center">
  <logo></logo>
    <div class="container col-3 container-fluid">
    <form class="form-signin" @submit.prevent="login">
      <br>
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="alert alert-success" role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
     
        <div class = "form-group">
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
        </div>
        <div class = "form-group ">
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
        </div>
      <div class = "form-group ">
        <button type="submit" class =  "btn btn-primary col-3">Sign in</button>
      <small id="emailHelp" class="form-text text-muted"> 
        <router-link :to="{ name: 'register' }">Need an account?</router-link>
      </small>
      </div>

    </form>
    </div>
  </div>
</div>
  
</template>

<script>
import auth from '../auth';
import Logo from '../components/Logo.vue';
export default {
  name: 'login',
  components: {
    Logo
  },
  data() {
    return {
      user: {
        username: '',
        password: '',
        
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/api/user/login`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      }) .then((response) => {
          if (response.ok) {
            return response.json();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then((json) => {
          let token = json.token;
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, '');
            }
            auth.saveToken(token);
            this.$router.push('/');
          }
        })
        
        .catch((err) => console.error(err));
    },
  },
};
</script>

<style scoped>

/* #grad {
  height: 100%;
  background-color:  var(--gxyellow); For browsers that do not support gradients 
  background-image: linear-gradient(to right, var(--gxpink), var(--gxorange), var(--gxyellow), var(--gxyellow), var(--gxyellow), var(--gxorange), var(--gxpink)); /* Standard syntax (must be last) 
} */

.col-3 {
  max-width: 250px;
}

img {
  margin: -20px;
}

</style>
