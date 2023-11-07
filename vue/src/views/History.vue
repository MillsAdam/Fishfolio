<template>
    <div>
        <form @submit.prevent="searchHistory">
            <b-row>
                <b-col>
                    <label for="history">History ID</label>
                    <input v-model="trackingHistoryId" type="text" class="form-control" id="history" placeholder="Enter History ID"> 
                </b-col>

                <b-col cols="auto">
                    <label for="date">Date</label>
                    <div class="datePicker">
                        <b-form-datepicker
                            v-model="selectedDate"
                            @input="onDateSelected"
                            :start-view="'year'"

                            :max="new Date()"
                            :value-as-date="true"
                            button-only
                            right
                            class="mb-2"
                        ></b-form-datepicker>
                    </div>
                </b-col>

                <b-col>
                    <label for="fishId">Fish ID</label>
                    <input v-model="fishId" type="text" class="form-control" id="fishId" placeholder="Enter Fish ID">
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

        <div v-else>
            <p>No history found for the selected filters.</p>
        </div>
    </div>
</template>

<script>
import TrackingHistoryService from "../services/TrackingHistoryService.js";
import { BFormDatepicker } from 'bootstrap-vue'

export default {
    components: {
        BFormDatepicker
    }, 

    data() {
        return {
            historyList: [],
            monthOptions: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
            yearOptions: ['2022', '2023'],
            trackingHistoryId: "",
            fishId: "",
            month: "",
            year: "",
            selectedDate: "",
        }
    },

    methods: {
        async searchHistory() {
            console.log("History ID:", this.trackingHistoryId);
            console.log("Fish ID:", this.fishId);
            console.log("Month:", this.month);
            console.log("Year:", this.year);
            console.log("");

            try {
                if (this.trackingHistoryId != "") {
                    const response = await TrackingHistoryService.getTrackingHistory({
                        trackingHistoryId: this.trackingHistoryId
                    });
                    if (response.data.length == 0) {
                        console.log('No history found for the provided History ID');
                        this.historyList = [];
                    } else {
                        console.log('History found', response.data);
                        this.historyList = response.data;
                    }
                } else if (this.fishId != "") {
                    const response = await TrackingHistoryService.getTrackingHistory({
                        fishId: this.fishId
                    });
                    if (response.data.length == 0) {
                        console.log('No history found for the provided Fish ID');
                        this.historyList = [];
                    } else {
                        console.log('History found', response.data);
                        this.historyList = response.data;
                    }
                } else if (this.month != "" && this.year != "") {
                    const response = await TrackingHistoryService.getTrackingHistory({
                        month: this.month,
                        year: this.year
                    });
                    console.log('History found', response.data);
                    this.historyList = response.data;
                } else {
                    const response = await TrackingHistoryService.getTrackingHistory({});
                    console.log('History found', response.data);
                    this.historyList = response.data;
                }
                this.resetFilters(); // keep or delete?
            } catch (error) {
                console.error('Error finding history', error);
            }
        },

        resetFilters() {
            this.trackingHistoryId = "";
            this.fishId = "";
            this.month = "";
            this.year = "";
        },

        clearFilters() {
            this.trackingHistoryId = "";
            this.fishId = "";
            this.month = "";
            this.year = "";
            this.searchHistory();
        }, 

        async refreshHistoryList() {
            try {
                const response = await TrackingHistoryService.getTrackingHistory({});
                console.log('History found', response.data);
                this.historyList = response.data;
            } catch (error) {
                console.error('Error finding history', error);
            }
        }, 

        onDateSelected(newDate) {
            const selectedMonth = newDate.getMonth() + 1;
            const selectedYear = newDate.getFullYear();

            this.month = String(selectedMonth).padStart(2, 0);
            this.year = selectedYear;
            
            this.searchHistory();
        }
    },

    created() {
        this.refreshHistoryList();
    }
}
</script>

<style scoped>

button {
    width: 100%;
    margin: 10px 0px;
}

</style>