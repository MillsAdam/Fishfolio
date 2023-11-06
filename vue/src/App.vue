<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'inventory' }">Inventory</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'history' }">History</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'fish-form' }">Fish Form</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'history-form' }">History Form</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
@import url("https://fonts.googleapis.com/css2?family=Urbanist:wght@300;400&display=swap");

#app {
  font-family: "Urbanist", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

button {
  font-family: "Urbanist", sans-serif;
  /* display: inline-block; */
  background: #2c3e50;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  text-decoration: none;
  font-size: 15px;
}

button:hover {
  background-color: #407F7F;
}

.form-row {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-top: 10px;
    gap: 10px;
}

.form-group {
    flex: 1;
    margin-bottom: 10px;
}

label {
    font-weight: bold;
    display: block;
    margin-bottom: 5px;
}

select, input {
    width: 100%;
    padding: 8px 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

@media (max-width: 767px) {
    /* .form-row {
        flex-direction: column;
    }

    .form-group {
        margin-bottom: 0px;
        display: flex;
        align-items: center;
    }
    
    .form-group label {
        margin-right: 5px;
    }

    .form-group select, .form-group input {
        margin-left: 5px;
    } */
}

</style>
