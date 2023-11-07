import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000/api/fish"
})

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