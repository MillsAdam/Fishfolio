<template>
    <b-row>
        <div id="nav">
            <router-link v-bind:to="{ name: 'home' }">Home</router-link>

            <template v-if="isLoggedOut">
                <router-link v-bind:to="{ name: 'login' }">Login</router-link>
                <router-link v-bind:to="{ name: 'register' }">Register</router-link>
            </template>
        
            <template v-if="isLoggedIn">
                <router-link v-bind:to="{ name: 'logout' }" >Logout</router-link>
                <router-link v-bind:to="{ name: 'info' }">Info</router-link>

                <div class="dropdown" @click="toggleDropdown">
                    <button class="dropbtn">Data</button>
                    <div class="dropdown-content" v-show="showDropdown">
                        <router-link v-bind:to="{ name: 'inventory' }" @click.native.stop="closeDropdown">Inventory</router-link>
                        <router-link v-bind:to="{ name: 'history' }" @click.native.stop="closeDropdown">History</router-link>
                    </div>
                </div>
            </template>
            
            <template v-if="isAdmin">
                <div class="dropdown" @click="toggleDropdown">
                    <button class="dropbtn">Forms</button>
                    <div class="dropdown-content" v-show="showDropdown">
                        <router-link v-bind:to="{ name: 'fish-form' }" @click.native.stop="closeDropdown">Fish Form</router-link>
                        <router-link v-bind:to="{ name: 'history-form' }" @click.native.stop="closeDropdown">History Form</router-link>
                    </div>
                </div>
            </template>
            
        </div>
    </b-row>
    
</template>

<script>

export default {
    data () {
        return {
            showDropdown: false,
        };
    },

    methods: {
        toggleDropdown() {
            this.showDropdown = !this.showDropdown;
        },

        closeDropdown() {
            this.showDropdown = false;
        },
    },

    computed: {
        isLoggedOut() {
            return !this.isLoggedIn;
        },
        isLoggedIn() {
            return !!this.$store.state.token;
        },
        isAdmin() {
            const isAdmin = this.$store.state.user?.authorities?.some(auth => auth.name === 'ROLE_ADMIN' ?? false);

            // console.log('User: ', this.$store.state.user);
            // console.log('Authorities: ', this.$store.state.user?.authorities);
            // console.log('Is Admin: ', isAdmin);

            return isAdmin;
        }
    }
}

</script>

<style scoped>

#nav {
    background-color: #2c3e50;
    padding: 0 10px;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    margin: 0px 16px;
}

#nav > a, .dropbtn {
    background-color: #2c3e50;
    color: white;
    padding: 8px 14px;
    font-size: 12px;
    border: none;
    cursor: pointer;
    text-decoration: none;
    margin: 0 2px;
}

#nav > a {
    padding: 10px 14px;
}

.dropdown {
    display: inline-block;
    /* position: relative; */
}

.dropdown-content{
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 14px 0px rgba(0,0,0,0.2);
    z-index: 1;
    right: 0;
}

.dropdown-content a{
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    font-size: 12px;

    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

.dropdown-content a:hover {
    background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
    display: block;
}

#nav > a:hover, .dropdown:hover .dropbtn {
    background-color: #407F7F;
}

</style>