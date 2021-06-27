import axios from "axios";

export default class FavoriteJobPostingService {
    getAllByEmployeeId(id) {
        return axios.get("http://localhost:8080/api/favorite/getAllByEmployeeId?employeeId=" + id);
    }
    add(favoriteJobPosting) {
        return axios.post('http://localhost:8080/api/favorite/add', favoriteJobPosting)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}