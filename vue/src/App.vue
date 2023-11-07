<template>
    <div id="app">
        <div id="nav">
            <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      
            <template v-if="isLoggedIn">
                &nbsp;|&nbsp;
                <router-link v-bind:to="{ name: 'logout' }" >Logout</router-link>&nbsp;|&nbsp;
                <router-link v-bind:to="{ name: 'inventory' }">Inventory</router-link>&nbsp;|&nbsp;
                <router-link v-bind:to="{ name: 'history' }">History</router-link>
            </template>
            
            <template v-if="isAdmin">
                &nbsp;|&nbsp;
                <router-link v-bind:to="{ name: 'fish-form' }">Fish Form</router-link>&nbsp;|&nbsp;
                <router-link v-bind:to="{ name: 'history-form' }">History Form</router-link>
            </template>
            
        </div>
        <router-view />
    </div>
</template>

<script>

export default {
    computed: {
        isLoggedIn() {
            return !!this.$store.state.token;
        },
        isAdmin() {
            const isAdmin = this.$store.state.user?.authorities?.some(auth => auth.name === 'ROLE_ADMIN' ?? false);

            console.log('User: ', this.$store.state.user);
            console.log('Authorities: ', this.$store.state.user?.authorities);
            console.log('Is Admin: ', isAdmin);

            return isAdmin;
        }
    }
}

</script>

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
    width: 300px;
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

.table-container {
    width: 100%;
    max-width: 100%;
    overflow: auto;
    white-space: nowrap;
}

table {
    margin-top: 10px;
    width: 100%;
    min-width: 100%;
}

th {
    background-color: #343a40;
    color: white;
    font-weight: bold;
    padding: 10px 0px;
}

.table-headers{
    font-size: 15px;
}
.table-columns {
    cursor: pointer;
    font-size: 13px;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

tr:nth-child(odd) {
    background-color: #ffffff;
}

td {
    /* padding-top: 10px; */
    padding: 10px 5px 0px 5px;
    border: 1px solid #ddd;
    font-size: 15px;
}

</style>
