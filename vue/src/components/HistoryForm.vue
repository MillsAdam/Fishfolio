<template>
    <div>
        <div class="form-row">
            <button @click="toggleCreateHistoryForm">Create History Form</button>
            <button @click="toggleUpdateHistoryForm">Update History Form</button>
            <button @click="toggleDeleteHistoryForm">Delete History Form</button>
        </div>

        <div class="form-row" v-if="showCreateHistoryForm">
            <form @submit.prevent="createHistoryForm" class="form-group">
                <input v-model="fishId" type="text" class="form-control" id="fishId" placeholder="Enter Fish ID">
                <input v-model="recordedDate" type="text" class="form-control" id="type" placeholder="Enter Date">
                <input v-model="recordedLength" type="text" class="form-control" id="length" placeholder="Enter Length">
                <input v-model="recordedWeight" type="text" class="form-control" id="weight" placeholder="Enter Weight">
                <button type="submit">Create History</button>
            </form>
        </div>

        <div class="form-row" v-if="showUpdateHistoryForm">
            <form @submit.prevent="updateHistoryForm" class="form-group">
                <input v-model="trackingHistoryId" type="text" class="form-control" id="trackingHistoryId" placeholder="Enter History ID">
                <input v-model="fishId" type="text" class="form-control" id="fishId" placeholder="Enter Fish ID">
                <input v-model="recordedDate" type="text" class="form-control" id="type" placeholder="Enter Date">
                <input v-model="recordedLength" type="text" class="form-control" id="length" placeholder="Enter Length">
                <input v-model="recordedWeight" type="text" class="form-control" id="weight" placeholder="Enter Weight">
                <button type="submit">Update Fish</button>
            </form>
        </div>

        <div class="form-row" v-if="showDeleteHistoryForm">
            <form @submit.prevent="deleteHistoryForm" class="form-group">
                <input v-model="trackingHistoryId" type="text" class="form-control" id="trackingHistoryId" placeholder="Enter History ID">
                <button type="submit">Delete Fish</button>
            </form>
        </div>

        <div v-if="successMessage" class="success-message">
            <p>{{ successMessage }}</p>
        </div>

    </div>
    
</template>

<script>
import TrackingHistoryService from '@/services/TrackingHistoryService.js'

export default {
    data() {
        return {
            trackingHistoryId: '',
            fishId: '',
            recordedDate: '',
            recordedLength: '',
            recordedWeight: '',
            showCreateHistoryForm: false,
            showUpdateHistoryForm: false,
            showDeleteHistoryForm: false,
            successMessage: '',
        }
    },

    methods: {
        async createHistoryForm() {
            try {
                const newHistory = {
                    fishId: this.fishId,
                    recordedDate: this.recordedDate,
                    recordedLength: this.recordedLength,
                    recordedWeight: this.recordedWeight,
                };
                const response = await TrackingHistoryService.createTrackingHistory(newHistory);
                console.log('History created', response.data);
                this.successMessage = 'History created!';
                setTimeout(() => {
                    this.successMessage = '';
                }, 3000);

                this.resetForm();
            } catch (error) {
                console.error('Error creating history', error);
            }
        },

        async updateHistoryForm() {
            try {
                const updateHistory = {
                    trackingHistoryId: this.trackingHistoryId,
                    fishId: this.fishId,
                    recordedDate: this.recordedDate,
                    recordedLength: this.recordedLength,
                    recordedWeight: this.recordedWeight,
                }
                const response = await TrackingHistoryService.updateTrackingHistory(this.trackingHistoryId, updateHistory);
                console.log('History updated', response.data);
                this.successMessage = 'History updated!';
                setTimeout(() => {
                    this.successMessage = '';
                }, 3000);

                this.resetForm();
            } catch (error) {
                console.error('Error updating history', error);
            }
        },

        async deleteHistoryForm() {
            try {
                const response = await TrackingHistoryService.deleteTrackingHistory(this.trackingHistoryId);
                console.log('History deleted', response.data);
                this.successMessage = 'History deleted!';
                setTimeout(() => {
                    this.successMessage = '';
                }, 3000);

                this.resetForm();
            } catch (error) {
                console.error('Error deleting history', error);
            }
        },

        resetForm() {
            this.trackingHistoryId = '';
            this.fishId = '';
            this.recordedDate = '';
            this.recordedLength = '';
            this.recordedWeight = '';
        },

        toggleCreateHistoryForm() {
            this.showCreateHistoryForm = !this.showCreateHistoryForm;
            this.showUpdateHistoryForm = false;
            this.showDeleteHistoryForm = false;
            this.resetForm();
        },

        toggleUpdateHistoryForm() {
            this.showUpdateHistoryForm = !this.showUpdateHistoryForm;
            this.showCreateHistoryForm = false;
            this.showDeleteHistoryForm = false;
            this.resetForm();
        },

        toggleDeleteHistoryForm() {
            this.showDeleteHistoryForm = !this.showDeleteHistoryForm;
            this.showCreateHistoryForm = false;
            this.showUpdateHistoryForm = false;
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