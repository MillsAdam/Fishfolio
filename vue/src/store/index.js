import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import FishService from '@/services/FishService.js';

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    fishList: [],
    filteredFishList: [],
    currentIndex: 0,
    fishTypes: [],
    fishLocations: [],
    hasFishListBeenReset: false,
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_FISH_LIST(state, payload) {
      state.fishList = payload;
    },
    SET_FILTERED_FISH_LIST(state, payload) {
      state.filteredFishList = payload;
    },
    RESET_FISH_LIST(state) {
      state.fishList = [];
      state.hasFishListBeenReset = true;
    },
    RESET_FILTERED_FISH_LIST(state) {
      state.filteredFishList = [];
    },
    RESET_CURRENT_INDEX(state) {
      state.currentIndex = 0;
    },
    INCREMENT_CURRENT_INDEX(state) {
      state.currentIndex++;
    },
    DECREMENT_CURRENT_INDEX(state) {
      state.currentIndex--;
    },
    SET_FISH_TYPES(state, payload) {
      state.fishTypes = payload;
    },
    SET_FISH_LOCATIONS(state, payload) {
      state.fishLocations = payload;
    }
  },
  actions: {
    fetchFishList({ commit }) {
      FishService.getFish({})
      .then(response => {
        commit('SET_FISH_LIST', response.data)
      })
      .catch(error => {
        console.log('Error fetching fish', error);
      });
    },
    searchFishList({ commit }, payload) {
      console.log('Dispatch payload', payload);

      FishService.getFish(payload)
      .then(response => {
        console.log('Filtered data received:', response.data);
        commit('SET_FILTERED_FISH_LIST', response.data)
      })
      .catch(error => {
        console.log('Error fetching fish', error);
      });
    },
    getFishTypes({ commit }) {
      FishService.getFishTypes()
      .then(response => {
        commit('SET_FISH_TYPES', response.data)
      })
      .catch(error => {
        console.log('Error fetching fish types', error);
      });
    },
    getFishLocations({ commit }) {
      FishService.getFishLocations()
      .then(response => {
        commit('SET_FISH_LOCATIONS', response.data)
      })
      .catch(error => {
        console.log('Error fetching fish locations', error);
      });
    }
  }
})
