import axios from "axios";

export default class EmployerService {
    getAll() {
        return axios.get("http://localhost:8080/api/employers/getall" );
    }
    getByEmployeeId(id) {
        return axios.get("http://localhost:8080/api/employers/getbyid?employeeId=" + id);
    }

}