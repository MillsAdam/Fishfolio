import axios from 'axios';

const http = axios.create({
  baseURL: "https://fishfolio-app-9ef287f0b901.herokuapp.com"
})

export default {

  login(user) {
    return http.post('/login', user)
  },

  register(user) {
    return http.post('/register', user)
  }

}
