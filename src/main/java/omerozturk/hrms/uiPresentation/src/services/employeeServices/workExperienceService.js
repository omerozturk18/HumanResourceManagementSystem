import axios from "axios";

export default class SchoolService {
    getAllByBusinessDate(id) {
        return axios.get("http://localhost:8080/api/workExperiences/getAllByBusinessDate?employeeId=" + id);
    }
    add(workExperienceDtos) {
        return axios.post('http://localhost:8080/api/workExperiences/add', workExperienceDtos)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}