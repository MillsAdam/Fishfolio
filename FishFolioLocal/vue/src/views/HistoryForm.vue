<template>
    <div>
        <b-row>
            <b-col>
                <button @click="toggleCreateHistoryForm" id="btn-filter">Create<br>History</button>
            </b-col>
            <b-col>
                <button @click="toggleUpdateHistoryForm" id="btn-filter">Update<br>History</button>
            </b-col>
            <b-col>
                <button @click="toggleDeleteHistoryForm" id="btn-filter">Delete<br>History</button>
            </b-col>
        </b-row>

        <form @submit.prevent="createHistoryForm" v-if="showCreateHistoryForm">
            <b-col>
                <input v-model="fishId" type="text" class="custom-input" id="fishId" placeholder="Enter Fish ID">
                <input v-model="recordedDate" type="text" class="custom-input" id="type" placeholder="Enter Date">
                <input v-model="recordedLength" type="text" class="custom-input" id="length" placeholder="Enter Length">
                <input v-model="recordedWeight" type="text" class="custom-input" id="weight" placeholder="Enter Weight">
            </b-col>
            <b-row>
                <b-col>
                    <button type="submit" id="btn-filter">Create History</button>
                </b-col>
                <b-col>
                    <button type="button" @click="resetForm" id="btn-filter">Reset Form</button>
                </b-col>
            </b-row>
        </form>

        <form @submit.prevent="updateHistoryForm" v-if="showUpdateHistoryForm">
            <b-col>
                <input v-model="trackingHistoryId" type="text" class="custom-input" id="trackingHistoryId" placeholder="Enter History ID">
                <input v-model="fishId" type="text" class="custom-input" id="fishId" placeholder="Enter Fish ID">
                <input v-model="recordedDate" type="text" class="custom-input" id="type" placeholder="Enter Date">
                <input v-model="recordedLength" type="text" class="custom-input" id="length" placeholder="Enter Length">
                <input v-model="recordedWeight" type="text" class="custom-input" id="weight" placeholder="Enter Weight">
            </b-col>
            <b-row>
                <b-col>
                    <button type="submit" id="btn-filter">Update History</button>
                </b-col>
                <b-col>
                    <button type="button" @click="resetForm" id="btn-filter">Reset Form</button>
                </b-col>
            </b-row>
        </form>

        <form @submit.prevent="deleteHistoryForm" v-if="showDeleteHistoryForm">
            <b-col>
                <input v-model="trackingHistoryId" type="text" class="custom-input" id="trackingHistoryId" placeholder="Enter History ID">
            </b-col>
            <b-row>
                <b-col>
                    <button type="submit" id="btn-filter">Delete History</button>
                </b-col>
                <b-col>
                    <button type="button" @click="resetForm" id="btn-filter">Reset Form</button>
                </b-col>
            </b-row>
        </form>

        <div v-if="successMessage" class="success-message">
            <p>{{ successMessage }}</p>
        </div>

        <div v-if="historyList.length > 0" class="table-container">
            <table class="table table-striped">
                <thead>
                    <tr class="table-headers">
                        <th scope="col">History ID</th>
                        <th scope="col">Fish ID</th>
                        <th scope="col">Date</th>
                        <th scope="col">Length</th>
                        <th scope="col">Weight</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="history in historyList" :key="history.id">
                        <td>{{ history.trackingHistoryId }}</td>
                        <td>{{ history.fishId }}</td>
                        <td>{{ history.recordedDate }}</td>
                        <td>{{ history.recordedLength }}</td>
                        <td>{{ history.recordedWeight }}</td>
                    </tr>
                </tbody>
            </table>
        </div>

    </div>
</template>

<script>
import TrackingHistoryService from '@/services/TrackingHistoryService.js'

export default {
    data() {
        return {
            historyList: [],
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
                await TrackingHistoryService.createTrackingHistory(newHistory);
                // console.log('History created', response.data);
                this.successMessage = 'History created!';
                setTimeout(() => {
                    this.successMessage = '';
                }, 3000);

                this.resetForm();
                this.refreshHistoryList();
            } catch (error) {
                this.error = error;
                // console.error('Error creating history', error);
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
                await TrackingHistoryService.updateTrackingHistory(this.trackingHistoryId, updateHistory);
                // console.log('History updated', response.data);
                this.successMessage = 'History updated!';
                setTimeout(() => {
                    this.successMessage = '';
                }, 3000);

                this.resetForm();
                this.refreshHistoryList();
            } catch (error) {
                this.error = error;
                // console.error('Error updating history', error);
            }
        },

        async deleteHistoryForm() {
            try {
                await TrackingHistoryService.deleteTrackingHistory(this.trackingHistoryId);
                // console.log('History deleted', response.data);
                this.successMessage = 'History deleted!';
                setTimeout(() => {
                    this.successMessage = '';
                }, 3000);

                this.resetForm();
                this.refreshHistoryList();
            } catch (error) {
                this.error = error;
                // console.error('Error deleting history', error);
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
        
        async refreshHistoryList() {
            try {
                const response = await TrackingHistoryService.getTrackingHistory({});
                // console.log('History found', response.data)
                this.historyList = response.data;
            } catch (error) {
                this.error = error;
                // console.error('Error refreshing fish list', error);
            }
        }
    },

    created() {
        this.refreshHistoryList();
    },
}
</script>

<style scoped>

.custom-input {
    margin: 5px 0px;
}

button {
  width: 100%;
  margin: 10px 0px;
}

</style>