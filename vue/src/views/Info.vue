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

        <div v-if="fishList.length > 0" class="card-container">
            <InfoCard :fish="currentFish" />
        </div>

        <div v-else>
            <p>No fish found for the selected filters</p>
        </div>
    </div>
</template>

<script>
import InfoCard from "../components/InfoCard.vue";

export default {
    components: {
        InfoCard
    },

    data() {
        return {
            filteredFishList: [],
            sortOptions: ["Most Recent", "Oldest", "Most Popular"],
            fishId: "",
            type: "",
            location: "",
            sortBy: "",
            searchBy: "",
            searchOptions: ['Sort By', 'Fish ID', 'Type', 'Location'],
            currentIndex: 0,
        }
    },

    computed: {
        fishList() {
            if (this.$store.state.filteredFishList.length > 0) {
                return this.$store.state.filteredFishList;
            } else {
                return this.$store.state.fishList;
            }
        },

        currentFish() {
            const listToUse = this.$store.state.filteredFishList.length > 0 
                            ? this.$store.state.filteredFishList 
                            : this.$store.state.fishList;
            return listToUse[this.currentIndex] || null;
        },
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
            const searchCriteria = {
                fishId: this.fishId,
                type: this.type,
                location: this.location,
                sortBy: this.sortBy
            };

            console.log("Sorting By:", this.sortBy);
            console.log("Fish ID:", this.fishId);
            console.log("Type:", this.type);
            console.log("Location:", this.location);
            console.log("");

            // this.resetFilters();

            this.$store.commit('RESET_FILTERED_FISH_LIST');

            try {
                if (searchCriteria.fishId != "") {
                    await this.$store.dispatch('searchFishList', { fishId: searchCriteria.fishId });
                } else if (searchCriteria.type != "") {
                    await this.$store.dispatch('searchFishList', { type: searchCriteria.type });
                } else if (searchCriteria.location != "") {
                    await this.$store.dispatch('searchFishList', { location: searchCriteria.location });
                } else if (searchCriteria.sortBy != "") {
                    await this.$store.dispatch('searchFishList', { sortBy: searchCriteria.sortBy });
                } else {
                    this.resetFilters();
                    await this.$store.dispatch('fetchFishList');
                } 
            } catch (error) {
                console.log('Error finding fish', error);
            }

            this.resetSearchCriteria(); // fix later
            this.$store.commit('RESET_CURRENT_INDEX');
        },

        resetFilters() {
            this.fishId = "";
            this.type = "";
            this.location = "";
            this.sortBy = "";
            this.searchBy = "";
        },

        resetSearchCriteria() {
            this.fishId = "";
            this.type = "";
            this.location = "";
            this.sortBy = "";
        },

        clearFilters() {
            this.resetFilters();
            this.$store.commit('RESET_FILTERED_FISH_LIST');
            this.$store.commit('RESET_FISH_LIST');
            this.$store.dispatch('fetchFishList');
        },
    },

    created() {
        this.getFishTypes();
        this.getFishLocations();
        this.$store.commit('RESET_FISH_LIST');
        this.$store.dispatch('fetchFishList')
    }
}

</script>

<style scoped>

button {
  width: 100%;
  margin: 10px 0px;
}

</style>