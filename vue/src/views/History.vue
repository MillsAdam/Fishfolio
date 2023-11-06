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
        searchHistory() {
            console.log("History ID:", this.trackingHistoryId);
            console.log("Fish ID:", this.fishId);
            console.log("Month:", this.month);
            console.log("Year:", this.year);
            console.log("");

            if (this.trackingHistoryId != "") {
                TrackingHistoryService.getTrackingHistory({
                    trackingHistoryId: this.trackingHistoryId
                }).then(response => {
                    console.log('Response', response.data)
                    this.historyList = response.data;
                }).catch(error => {
                    console.log('Error', error.response)
                });
            } else if (this.fishId != "") {
                TrackingHistoryService.getTrackingHistory({
                    fishId: this.fishId
                }).then(response => {
                    console.log('Response', response.data)
                    this.historyList = response.data;
                }).catch(error => {
                    console.log('Error', error.response)
                });
            } else if (this.month != "" && this.year != "") {
                TrackingHistoryService.getTrackingHistory({
                    month: this.month,
                    year: this.year
                }).then(response => {
                    console.log('Response', response.data)
                    this.historyList = response.data;
                }).catch(error => {
                    console.log('Error', error.response)
                });
            } else {
                TrackingHistoryService.getTrackingHistory({}).then(response => {
                    console.log('Response', response.data)
                    this.historyList = response.data;
                }).catch(error => {
                    console.log('Error', error.response)
                });
            }
        },

        clearFilters() {
            this.trackingHistoryId = "";
            this.fishId = "";
            this.month = "";
            this.year = "";
            this.searchHistory();
        }
    },

    created() {
        TrackingHistoryService.getTrackingHistory({}).then(response => {
            console.log('Response', response.data)
            this.historyList = response.data;
        }).catch(error => {
            console.log('Error', error.response)
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