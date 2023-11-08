<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1 class="mt-3">Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>

      <b-col class="mb-1">
        <label for="username">Username</label>
        <input type="text" id="username" class="custom-input" v-model="user.username" required autofocus />
      </b-col>

      <b-col class="mb-4">
        <label for="password">Password</label>
        <input type="password" id="password" class="custom-input" v-model="user.password" required />
      </b-col>

      <b-col class="mb-3">
        <button type="submit">Sign in</button>
      </b-col>

      <b-col>
        <p>
          <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link>
        </p>
      </b-col>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            console.log(response.data.user); // added to check role
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/"); // added if not authorized
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

</style>