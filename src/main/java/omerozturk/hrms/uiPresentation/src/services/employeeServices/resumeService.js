import axios from "axios";

export default class ResumeService {
    getAll() {
        return axios.get("http://localhost:8080/api/resumes/getall");
    }
    getById(id) {
        return axios.get("http://localhost:8080/api/resumes/getById?resumeId=" + id);
    }
    getByEmployeeIdAndDate(id) {
        return axios.get("http://localhost:8080/api/resumes/getByEmployeeIdAndDate?employeeId=" + id);
    }

    add(resume) {
        return axios.post('http://localhost:8080/api/resumes/add', resume)
            .then(function (response) { console.log(response); })
            .catch(function (error) {
                console.log(error);
            });
    }
}