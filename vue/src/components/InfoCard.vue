<template>
    <div v-if="fishList.length > 0" class="fish-container">
        <div class="fish-details">
            <h2>{{ currentFish.name }}</h2>
            <p><strong>Fish ID:</strong> {{ currentFish.fishId }}</p>
            <p><strong>Type:</strong> {{ currentFish.type }}</p>
            <p><strong>Length:</strong> {{ currentFish.length }}</p>
            <p><strong>Weight:</strong> {{ currentFish.weight }}</p>
            <p><strong>Location:</strong> {{ currentFish.location }}</p>
            <p><strong>Lure Used:</strong> {{ currentFish.lureUsed }}</p>
            <p><strong>Date Caught:</strong> {{ currentFish.dateCaught }}</p>
            <img :src="currentFish.imageUrl" alt="fish image">
        </div>
        <b-row>
            <b-col>
                <button @click="previousFish" v-if="currentIndex !== 0">Previous</button>
            </b-col>
            <b-col>
                <button @click="nextFish" v-if="currentIndex < fishList.length - 1">Next</button>
            </b-col>
        </b-row>
    </div>
</template>

<script>
export default {
    computed: {
        currentFish() {
            const listToUse = this.$store.state.filteredFishList.length > 0 
                            ? this.$store.state.filteredFishList 
                            : this.$store.state.fishList;
            return listToUse[this.currentIndex] || null;
        },

        fishList() {
            if (this.$store.state.filteredFishList.length > 0) {
                return this.$store.state.filteredFishList;
            } else {
                return this.$store.state.fishList;
            }
        },

        currentIndex() {
            return this.$store.state.currentIndex;
        }
    },

    methods: {
        nextFish() {
            if (this.currentIndex < this.fishList.length - 1) {
                this.$store.commit('INCREMENT_CURRENT_INDEX');
            }
        },

        previousFish() {
            if (this.currentIndex > 0) {
                this.$store.commit('DECREMENT_CURRENT_INDEX');
            }
        },

        resetCurrentIndex() {
            this.$store.commit('RESET_CURRENT_INDEX');
        },
    },

    created() {
        console.log(this.$store.state.fishList);
        // this.$store.commit('RESET_FISH_LIST');
        this.$store.dispatch("fetchFishList");
    },
}

</script>

<style scoped>

button {
  width: 100%;
  margin: 10px 0px;
}

img {
    width: auto;
    height: 200px;
}

</style>