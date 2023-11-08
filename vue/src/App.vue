<template>
    <div id="app">
        <HeaderComponent />
        <router-view />
    </div>
</template>

<script>
import HeaderComponent from '@/components/HeaderComponent.vue';

export default {
    components: {
        HeaderComponent,
    },
}

</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Urbanist:wght@300;400&display=swap");
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');

#app {
    /* font-family: "Urbanist", sans-serif; */
    font-family: 'Roboto', sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    font-size: 12px;
    padding: 16px 16px;
}

button {
    background: #2c3e50;
    color: #fff;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    text-decoration: none;
    font-size: 12px;
}

button:hover {
    background-color: #407F7F;
}

/* .form-row {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-top: 10px;
    gap: 10px;
} */

/* .form-group {
    flex: 1;
    margin-bottom: 10px;
} */

.form-input-group {
  margin-bottom: 1rem;
  display: flex;
  flex-direction: column;
  align-items: center;
}

label {
    font-weight: bold;
    display: block;
    margin-top: 10px;
    font-size: 12px;
}

select, input {
    width: 300px;
    /* padding: 8px 10px; */
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 12px; /* not used */
}

input::placeholder {
    font-size: 12px;
}

.custom-select, .custom-input {
    display: block;
    width: 100%;
    padding: .375rem .75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    border-radius: .25rem;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    height: calc(2.25rem + 2px);
}

.table-container {
    width: 100%;
    max-width: 100%;
    overflow: auto;
    white-space: nowrap;
}

table {
    width: 100%;
    min-width: 100%;
    border-collapse: collapse;
}

th {
    background-color: #343a40;
    color: white;
    font-weight: normal;
}

.table-headers{
    font-size: 12px;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

tr:nth-child(odd) {
    background-color: #ffffff;
}

td {
    font-size: 10px;
}

th, td {
    padding: 5px;
    border: none;
}

</style>
