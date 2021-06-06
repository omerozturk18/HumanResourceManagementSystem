import axios from "axios";

export default class ForeignLanguageService {
    getAll() {
        return axios.get("http://localhost:8080/api/foreignlanguages/getAll" );
    }
    getByEmployeeId(id) {
        return axios.get("http://localhost:8080/api/foreignlanguages/getAllByEmployeeId?employeeId=" + id);
    }

    add(foreignLanguage) {
        return axios.post('http://localhost:8080/api/foreignlanguages/add', foreignLanguage)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}