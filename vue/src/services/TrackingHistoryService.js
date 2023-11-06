import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000/api/tracking-history"
})

export default {
    getTrackingHistory({ trackingHistoryId, fishId, month, year }) {
        const params = {
            trackingHistoryId,
            fishId,
            month,
            year
        };
        return http.get("", { params });
    },

    getTrackingHistoryMonths() {
        return http.get("/months");
    },
    getTrackingHistoryYears() {
        return http.get("/years");
    },

    get(trackingHistoryId) {
        return http.get(`/${trackingHistoryId}`);
    },

    createTrackingHistory(data) {
        return http.post("/create", data);
    },
    updateTrackingHistory(trackingHistoryId, data) {
        return http.put(`/update/${trackingHistoryId}`, data);
    },
    deleteTrackingHistory(trackingHistoryId) {
        return http.delete(`/delete/${trackingHistoryId}`);
    },
}