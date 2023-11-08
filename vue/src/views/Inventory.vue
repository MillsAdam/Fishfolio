<template>
    <div>
        <form @submit.prevent="searchInventory">
            <b-row>
                <b-col>
                    <label for="searchBy">Search By</label>
                    <select v-model="searchBy" id="searchBy" class="custom-select">
                        <option v-for="searchOption in searchOptions" :key="searchOption">{{ searchOption }}</option>
                    </select>
                </b-col>

                <b-col v-if="searchBy === 'Sort By'">
                    <label for="sorting">Sort By</label>
                    <select v-model="sortBy" id="sortBy" class="custom-select">
                        <option v-for="sortOption in sortOptions" :key="sortOption">{{ sortOption }}</option>
                    </select>
                </b-col>

                <b-col v-if="searchBy === 'Fish ID'">
                    <label for="fishId">Fish ID</label>
                    <input v-model="fishId" type="text" id="fishId" class="custom-input" placeholder="Enter Fish ID">
                </b-col>

                <b-col v-if="searchBy === 'Type'">
                    <label for="type">Type</label>
                    <select v-model="type" id="type" class="custom-select">
                        <option v-for="fishType in fishTypes" :key="fishType">{{ fishType }}</option>
                    </select>
                </b-col>

                <b-col v-if="searchBy === 'Location'">
                    <label for="location">Location</label>
                    <select v-model="location" id="location" class="custom-select">
                        <option v-for="fishLocation in fishLocations" :key="fishLocation">{{ fishLocation }}</option>
                    </select>
                </b-col>               
            </b-row>
            
            <b-row>
                <b-col>
                    <button type="submit" class="w-100">Apply Filters</button>
                </b-col>
                <b-col>
                    <button type="button" class="w-100" @click="clearFilters">Clear Filters</button>
                </b-col>
            </b-row>
            
        </form>

        <div v-if="fishList.length > 0" class="table-container">
            <table class="table table-striped">
                <thead>
                    <tr class="table-headers">
                        <th scope="col">Fish ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Type</th>
                        <th scope="col">Length</th>
                        <th scope="col">Weight</th>
                        <th scope="col">Location</th>
                        <th scope="col">Lure Used</th>
                        <th scope="col">Date Caught</th>
                        <!-- <th scope="col">Image</th> -->
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="fish in fishList" :key="fish.id">
                        <td>{{ fish.fishId }}</td>
                        <td>{{ fish.name }}</td>
                        <td>{{ fish.type }}</td>
                        <td>{{ fish.length }}</td>
                        <td>{{ fish.weight }}</td>
                        <td>{{ fish.location }}</td>
                        <td>{{ fish.lureUsed }}</td>
                        <td>{{ fish.dateCaught }}</td>
                        <!-- <td><img :src="fish.imageUrl" alt="fish image" width="100" height="100"></td> -->
                    </tr>
                </tbody>
            </table>
        </div>

        <div v-else>
            <p>No fish found for the selected filters</p>
        </div>
    </div>
</template>

<script>
import FishService from "../services/FishService.js";

export default {
    data() {
        return {
            filteredFishList: [],
            fishList: [],
            sortOptions: ["Most Recent", "Oldest", "Most Popular"],
            fishId: "",
            type: "",
            location: "",
            sortBy: "",
            searchBy: "",
            searchOptions: ['Sort By', 'Fish ID', 'Type', 'Location'],
        }
    },

    computed: {
        fishTypes() {
            this.$store.dispatch('getFishTypes');
            return this.$store.state.fishTypes;
        },
        
        fishLocations() {
            this.$store.dispatch('getFishLocations');
            return this.$store.state.fishLocations;
        },

    },
    

    methods: {
        async searchInventory() {
            // console.log("Sorting By:", this.sortBy);
            // console.log("Fish ID:", this.fishId);
            // console.log("Type:", this.type);
            // console.log("Location:", this.location);
            // console.log("");

            try {
                if (this.fishId != "") {
                    try {
                        const response = await FishService.getFish({
                            fishId: this.fishId
                        });
                        if (response.data.length === 0) {
                            // console.log('No fish found with the provided Fish ID');
                            this.fishList = [];
                        } else {
                            // console.log('Fish found', response.data);
                            this.fishList = response.data;
                        }

                    } catch (error) {
                        this.error = error;
                        // console.error('An error occurred while fetching the fish data', error);
                        this.fishList = [];
                    }
                    
                    
                } else if (this.type != "") {
                    const response = await FishService.getFish({
                        type: this.type
                    });
                    // console.log('Fish found', response.data);
                    this.fishList = response.data;
                } else if (this.location != "") {
                    const response = await FishService.getFish({
                        location: this.location
                    });
                    // console.log('Fish found', response.data);
                    this.fishList = response.data;
                } else if (this.sortBy != "") {
                    const response = await FishService.getFish({
                        sortBy: this.sortBy
                    });
                    // console.log('Fish found', response.data);
                    this.fishList = response.data;
                } else {
                    const response = await FishService.getFish({});
                    // console.log('Fish found', response.data);
                    this.fishList = response.data;
                }

            } catch (error) {
                this.error = error;
                // console.log('Error finding fish', error);
            }
            
        },

        resetFilters() {
            this.fishId = "";
            this.type = "";
            this.location = "";
            this.sortBy = "";
            this.searchBy = "";
        },

        clearFilters() {
            this.resetFilters();
            this.searchInventory();
        },

        getFishTypes() {
            FishService.getFishTypes().then(response => {
                // console.log('Response', response.data)
                this.fishTypes = response.data;
            }).catch(error => {
                this.error = error;
                // console.log('Error:', error);
            });
        }, 

        getFishLocations() {
            FishService.getFishLocations().then(response => {
                // console.log('Response', response.data)
                this.fishLocations = response.data;
            }).catch(error => {
                this.error = error;
                // console.log('Error:', error);
            });
        },

        async refreshFishList() {
            try {
                const response = await FishService.getFish({});
                // console.log('Fish found', response.data)
                this.fishList = response.data;
            } catch (error) {
                this.error = error;
                // console.log('Error refreshing fish list:', error);
            }
        }
    },

    created() {
        this.refreshFishList();
    }
}

</script>

<style scoped>

button {
  width: 100%;
  margin: 10px 0px;
}

</style>