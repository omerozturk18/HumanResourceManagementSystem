import axios from "axios";

export default class EmployeeService {
    getAll() {
        return axios.get("http://localhost:8080/api/employees/getall" );
    }
    getByEmployeeId() {
        return axios.get("http://localhost:8080/api/employees/getbyid?employeeId=1");
    }

}