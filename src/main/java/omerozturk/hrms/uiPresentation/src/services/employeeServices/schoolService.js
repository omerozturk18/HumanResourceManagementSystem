import axios from "axios";

export default class SchoolService {
    getAllByEmployeeOrderByDateOfGraduation(id) {
        return axios.get("http://localhost:8080/api/schools/getAllByEmployeeOrderByDateOfGraduation?employeeId=" + id);
    }
    add(id) {
        return axios.post('http://localhost:8080/api/schools/add', id)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}