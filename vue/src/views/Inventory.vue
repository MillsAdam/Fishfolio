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
        searchInventory() {
            console.log("Sorting By:", this.sortBy);
            console.log("Fish ID:", this.fishId);
            console.log("Type:", this.type);
            console.log("Location:", this.location);
            console.log("");

            if (this.fishId != "") {
                FishService.getFish({
                    fishId: this.fishId
                }).then(response => {
                    console.log('Response', response.data)
                    this.fishList = response.data;
                }).catch(error => {
                    console.log('Error:', error);
                });
            } else if (this.type != "") {
                FishService.getFish({
                    type: this.type
                }).then(response => {
                    console.log('Response', response.data)
                    this.fishList = response.data;
                }).catch(error => {
                    console.log('Error:', error);
                });
            } else if (this.location != "") {
                FishService.getFish({
                    location: this.location
                }).then(response => {
                    console.log('Response', response.data)
                    this.fishList = response.data;
                }).catch(error => {
                    console.log('Error:', error);
                });
            } else if (this.sortBy != "") {
                FishService.getFish({
                    sortBy: this.sortBy
                }).then(response => {
                    console.log('Response', response.data)
                    this.fishList = response.data;
                }).catch(error => {
                    console.log('Error:', error);
                });
            } else {
                FishService.getFish({}).then(response => {
                    console.log('Response', response.data)
                    this.fishList = response.data;
                }).catch(error => {
                    console.log('Error:', error);
                });
            }
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
        }
    },

    created() {
        this.getFishTypes();
        this.getFishLocations();
        FishService.getFish({}).then(response => {
            console.log('Response', response.data)
            this.fishList = response.data;
        }).catch(error => {
            console.log('Error:', error);
        });
    }
}

</script>

<style scoped>
button {
  width: 100%;
  margin-top: 10px;
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