import axios from "axios";

const http = axios.create({
    baseURL: "https://fishfolio-app-9ef287f0b901.herokuapp.com/api/tracking-history"
})

http.interceptors.request.use(function (config) {
    const token = localStorage.getItem('token');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
}, function (error) {
    return Promise.reject(error);
});

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