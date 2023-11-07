<template>
    <div>
        <form @submit.prevent="searchInventory">
            <div class="form-row">

                <div class="form-group">
                    <label for="sorting">Sort By</label>
                    <select v-model="sortBy" class="form-control" id="sortBy">
                        <option v-for="sortOption in sortOptions" :key="sortOption">{{ sortOption }}</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="fishId">Fish ID</label>
                    <input v-model="fishId" type="text" class="form-control" id="fishId" placeholder="Enter Fish ID">
                </div>
            
            </div>
            <div class="form-row">

                <div class="form-group">
                    <label for="type">Type</label>
                    <select v-model="type" class="form-control" id="type">
                        <option v-for="fishType in fishTypes" :key="fishType">{{ fishType }}</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="location">Location</label>
                    <select v-model="location" class="form-control" id="location">
                        <option v-for="fishLocation in fishLocations" :key="fishLocation">{{ fishLocation }}</option>
                    </select>
                </div>
                
            </div>
            
            <div class="form-group">
                <div class="form-row">
                    <button type="submit">Apply Filters</button>
                    <button type="button" @click="clearFilters">Clear Filters</button>
                </div>
            </div>
            
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
                        <th scope="col">Image</th>
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
                        <td><img :src="fish.image" alt="fish image" width="100" height="100"></td>
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
            fishTypes: [],
            fishLocations: [],
            sortOptions: ["Most Recent", "Oldest", "Most Popular"],
            fishId: "",
            type: "",
            location: "",
            sortBy: "",
        }
    }, 

    methods: {
        async searchInventory() {
            console.log("Sorting By:", this.sortBy);
            console.log("Fish ID:", this.fishId);
            console.log("Type:", this.type);
            console.log("Location:", this.location);
            console.log("");

            try {
                if (this.fishId != "") {
                    const response = await FishService.getFish({
                        fishId: this.fishId
                    });
                    if (response.data.length === 0) {
                        console.log('No fish found with the provided Fish ID');
                        this.fishList = [];
                    } else {
                        console.log('Fish found', response.data);
                        this.fishList = response.data;
                    }
                } else if (this.type != "") {
                    const response = await FishService.getFish({
                        type: this.type
                    });
                    console.log('Fish found', response.data);
                    this.fishList = response.data;
                } else if (this.location != "") {
                    const response = await FishService.getFish({
                        location: this.location
                    });
                    console.log('Fish found', response.data);
                    this.fishList = response.data;
                } else if (this.sortBy != "") {
                    const response = await FishService.getFish({
                        sortBy: this.sortBy
                    });
                    console.log('Fish found', response.data);
                    this.fishList = response.data;
                } else {
                    const response = await FishService.getFish({});
                    console.log('Fish found', response.data);
                    this.fishList = response.data;
                }
                this.resetFilters(); // keep or delete?
            } catch (error) {
                console.log('Error finding fish', error);
            }
            
        },

        resetFilters() {
            this.fishId = "";
            this.type = "";
            this.location = "";
            this.sortBy = "";
        },

        clearFilters() {
            this.fishId = "";
            this.type = "";
            this.location = "";
            this.sortBy = "";
            this.searchInventory();
        },

        getFishTypes() {
            FishService.getFishTypes().then(response => {
                console.log('Response', response.data)
                this.fishTypes = response.data;
            }).catch(error => {
                console.log('Error:', error);
            });
        }, 

        getFishLocations() {
            FishService.getFishLocations().then(response => {
                console.log('Response', response.data)
                this.fishLocations = response.data;
            }).catch(error => {
                console.log('Error:', error);
            });
        },

        async refreshFishList() {
            try {
                const response = await FishService.getFish({});
                console.log('Fish found', response.data)
                this.fishList = response.data;
            } catch (error) {
                console.log('Error refreshing fish list:', error);
            }
        }
    },

    created() {
        this.getFishTypes();
        this.getFishLocations();
        this.refreshFishList();
    }
}

</script>

<style scoped>
select, input {
    width: 100%;
    padding: 8px 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

button {
  width: 100%;
  margin-top: 10px;
}

</style>