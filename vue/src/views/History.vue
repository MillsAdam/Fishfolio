<template>
    <div>
        <form @submit.prevent="searchHistory">
            <div class="form-row">

                <div class="form-group">
                    <label for="history">History ID</label>
                    <input v-model="trackingHistoryId" type="text" class="form-control" id="history" placeholder="Enter History ID">
                </div>

                <div class="form-group">
                    <label for="fishId">Fish ID</label>
                    <input v-model="fishId" type="text" class="form-control" id="fishId" placeholder="Enter Fish ID">
                </div>

            </div>
            <div class="form-row">

                <div class="form-group">
                    <label for="month">Month</label>
                    <select v-model="month" class="form-control" id="month">
                        <option v-for="(monthOption, index) in monthOptions" :key="monthOption" :value="String(index + 1).padStart(2, 0)">{{ monthOption }}</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="year">Year</label>
                    <select v-model="year" class="form-control" id="year">
                        <option v-for="yearOption in yearOptions" :key="yearOption">{{ yearOption }}</option>
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

export default {
    data() {
        return {
            historyList: [],
            monthOptions: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
            yearOptions: ['2022', '2023'],
            trackingHistoryId: "",
            fishId: "",
            month: "",
            year: "",
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
        }
    },

    created() {
        this.refreshHistoryList();
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