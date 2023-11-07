import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));
const currentRole = localStorage.getItem('role'); // added to save role to localStorage

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    role: currentRole || '',
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      console.log('Committing user: ', user); // added to check role
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
      if (user.authorities && user.authorities.length > 0) {
        state.user.authorities = user.authorities;
        state.role = user.authorities[0].name;
        localStorage.setItem('role', state.role); // added to save role to localStorage
      } // added to set role
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      localStorage.removeItem('role'); // added to remove role
      delete axios.defaults.headers.common['Authorization']; // added to remove role
      state.token = '';
      state.user = {};
      state.role = ''; // added to remove role
      // axios.defaults.headers.common = {};  // removed for redundancy
    }
  }
})
