import axios from "axios";

export default class JobPositionService {
    getAll() {
        return axios.get("http://localhost:8080/api/jobpositions/getall" );
    }
    getById(id) {
        return axios.get("http://localhost:8080/api/jobpositions/getbyid?jobPositionId=" + id);
    }

    add(jobPosition) {
        return axios.post('http://localhost:8080/api/jobpositions/add', jobPosition)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}