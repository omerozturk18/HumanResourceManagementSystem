import axios from "axios";

export default class SystemUserService {
    getAll() {
        return axios.get("http://localhost:8080/api/systemusers/getAll" );
    }
    getById(id) {
        return axios.get("http://localhost:8080/api/systemusers/getbyid?systemUserId=" + id);
    }

    add(systemUser) {
        return axios.post('http://localhost:8080/api/systemusers/add', systemUser)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}