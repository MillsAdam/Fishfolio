import axios from "axios";

const http = axios.create({
    baseURL: "https://fishfolio-app-9ef287f0b901.herokuapp.com/api/fish"
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
    getFish({ fishId, type, location, sortBy }) {
        const params = {
            fishId,
            type,
            location,
            sortBy
        };
        return http.get("", { params });
    },

    getFishTypes() {
        return http.get("/types");
    },
    getFishLocations() {
        return http.get("/locations");
    },

    getFishById(fishId) {
        return http.get(`/${fishId}`);
    },

    createFish(data) {
        return http.post("/create", data);
    },
    updateFish(fishId, data) {
        return http.put(`/update/${fishId}`, data);
    },
    deleteFish(fishId) {
        return http.delete(`/delete/${fishId}`);
    },
}