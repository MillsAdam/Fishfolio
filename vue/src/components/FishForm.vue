<template>
    <div>
        <div class="form-row">
            <button @click="toggleCreateFishForm">Create Fish Form</button>
            <button @click="toggleUpdateFishForm">Update Fish Form</button>
            <button @click="toggleDeleteFishForm">Delete Fish Form</button>
        </div>

        <div class="form-row" v-if="showCreateFishForm">
            <form @submit.prevent="createFishForm" class="form-group">
                <input v-model="name" type="text" class="form-control" id="name" placeholder="Enter Name">
                <input v-model="type" type="text" class="form-control" id="type" placeholder="Enter Type">
                <input v-model="length" type="text" class="form-control" id="length" placeholder="Enter Length">
                <input v-model="weight" type="text" class="form-control" id="weight" placeholder="Enter Weight">
                <input v-model="location" type="text" class="form-control" id="location" placeholder="Enter Location">
                <input v-model="lureUsed" type="text" class="form-control" id="lureUsed" placeholder="Enter Lure Used">
                <input v-model="dateCaught" type="text" class="form-control" id="dateCaught" placeholder="Enter Date Caught">
                <input v-model="imageUrl" type="text" class="form-control" id="imageUrl" placeholder="Enter Image">
                <button type="submit">Create Fish</button>
            </form>
        </div>

        <div class="form-row" v-if="showUpdateFishForm">
            <form @submit.prevent="updateFishForm" class="form-group">
                <input v-model="fishId" type="text" class="form-control" id="fishId" placeholder="Enter Fish ID">
                <input v-model="name" type="text" class="form-control" id="name" placeholder="Enter Name">
                <input v-model="type" type="text" class="form-control" id="type" placeholder="Enter Type">
                <input v-model="length" type="text" class="form-control" id="length" placeholder="Enter Length">
                <input v-model="weight" type="text" class="form-control" id="weight" placeholder="Enter Weight">
                <input v-model="location" type="text" class="form-control" id="location" placeholder="Enter Location">
                <input v-model="lureUsed" type="text" class="form-control" id="lureUsed" placeholder="Enter Lure Used">
                <input v-model="dateCaught" type="text" class="form-control" id="dateCaught" placeholder="Enter Date Caught">
                <input v-model="imageUrl" type="text" class="form-control" id="imageUrl" placeholder="Enter Image">
                <button type="submit">Update Fish</button>
            </form>
        </div>

        <div class="form-row" v-if="showDeleteFishForm">
            <form @submit.prevent="deleteFishForm" class="form-group">
                <input v-model="fishId" type="text" class="form-control" id="fishId" placeholder="Enter Fish ID">
                <button type="submit">Delete Fish</button>
            </form>
        </div>

        <div v-if="successMessage" class="success-message">
            <p>{{ successMessage }}</p>
        </div>

    </div>
    
</template>

<script>
import FishService from '@/services/FishService.js'

export default {
    data() {
        return {
            fishId: '',
            name: '',
            type: '',
            length: '',
            weight: '',
            location: '',
            lureUsed: '',
            dateCaught: '',
            imageUrl: '',
            showCreateFishForm: false,
            showUpdateFishForm: false,
            showDeleteFishForm: false,
            successMessage: '',
        }
    },

    methods: {
        async createFishForm() {
            try {
                const newFish = {
                    name: this.name,
                    type: this.type,
                    length: this.length,
                    weight: this.weight,
                    location: this.location,
                    lureUsed: this.lureUsed,
                    dateCaught: this.dateCaught,
                    image: this.imageUrl,
                };
                const response = await FishService.createFish(newFish);
                console.log('Fish created', response.data);
                this.successMessage = 'Fish created!';
                setTimeout(() => {
                    this.successMessage = '';
                }, 3000);

                this.resetForm();
            } catch (error) {
                console.error('Error creating fish', error);
            }
        },

        async updateFishForm() {
            try {
                const updateFish = {
                    fishId: this.fishId,
                    name: this.name,
                    type: this.type,
                    length: this.length,
                    weight: this.weight,
                    location: this.location,
                    lureUsed: this.lureUsed,
                    dateCaught: this.dateCaught,
                    image: this.imageUrl,
                }
                const response = await FishService.updateFish(this.fishId, updateFish);
                console.log('Fish updated', response.data);
                this.successMessage = 'Fish updated!';
                setTimeout(() => {
                    this.successMessage = '';
                }, 3000);

                this.resetForm();
            } catch (error) {
                console.error('Error updating fish', error);
            }
        },

        async deleteFishForm() {
            try {
                const response = await FishService.deleteFish(this.fishId);
                console.log('Fish deleted', response.data);
                this.successMessage = 'Fish deleted!';
                setTimeout(() => {
                    this.successMessage = '';
                }, 3000);

                this.resetForm();
            } catch (error) {
                console.error('Error deleting fish', error);
            }
        },

        resetForm() {
            this.fishId = '';
            this.name = '';
            this.type = '';
            this.length = '';
            this.weight = '';
            this.location = '';
            this.lureUsed = '';
            this.dateCaught = '';
            this.imageUrl = '';
        },

        toggleCreateFishForm() {
            this.showCreateFishForm = !this.showCreateFishForm;
            this.showUpdateFishForm = false;
            this.showDeleteFishForm = false;
            this.resetForm();
        },

        toggleUpdateFishForm() {
            this.showUpdateFishForm = !this.showUpdateFishForm;
            this.showCreateFishForm = false;
            this.showDeleteFishForm = false;
            this.resetForm();
        },

        toggleDeleteFishForm() {
            this.showDeleteFishForm = !this.showDeleteFishForm;
            this.showCreateFishForm = false;
            this.showUpdateFishForm = false;
            this.resetForm();
        },
        
    },
}
</script>

<style scoped>
button {
  width: 100%;
  margin-top: 10px;
}

</style>